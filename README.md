✨ **Tecnologias Utilizadas**

A aplicação de gerenciamento foi desenvolvida com foco em organização, clareza e boas práticas de arquitetura. As principais tecnologias utilizadas foram:

- Java 21
- Spring Boot 3.4.4
- Spring MVC
- Maven
- Spring Data JPA
- MySQL
- Thymeleaf
- Bean Validation (Jakarta Validation)

---

🧱 **Arquitetura MVC (Model-View-Controller)**

A estrutura da aplicação foi baseada no padrão **MVC**, amplamente utilizado para separar responsabilidades e tornar o código mais limpo, organizado e de fácil manutenção. Abaixo, explicamos cada camada e sua função no projeto:

### 🔹 Model (Modelo)

Representa os objetos de domínio da aplicação.

#### **Entidade Usuarios**
A entidade **Usuarios** foi criada para representar os usuários no sistema.

Exemplo de atributos no modelo:

```java
private Long id;
private String nome;
private String email;
private String senha;
```

#### **Entidade Produtos**
A entidade **Produtos** foi criada para representar os produtos disponíveis no sistema.

Exemplo de atributos no modelo:

```java
private Long id;
private String nome;
private String descricao;
private Double preco;
```

---

### 🔹 View (Visão)

A camada de visualização foi construída com o **Thymeleaf**, que facilita a renderização dinâmica de páginas HTML utilizando dados fornecidos pelo backend. Isso permite a criação de formulários interativos, listagens e ações como editar e excluir usuários e produtos.

---

### 🔹 Controller (Controlador)

Os controladores (`@Controller` e `@RestController`) são responsáveis por receber requisições HTTP, processar os dados (via Model) e retornar uma **View** (HTML) ou um **JSON** (no caso de APIs REST).

#### **Exemplos de Endpoints para Usuarios:**

- `@GetMapping("/usuarios")` → retorna a página HTML com a lista de usuários.
- `@PostMapping("/usuarios/api")` → cadastra um novo usuário via JSON (Postman).
- `@DeleteMapping("/usuarios/api/{id}")` → deleta um usuário pelo ID.
- `@PutMapping("/usuarios/api/{id}")` → atualiza os dados de um usuário existente.

#### **Exemplos de Endpoints para Produtos:**

- `@GetMapping("/produtos")` → retorna a página HTML com a lista de produtos.
- `@PostMapping("/produtos/api")` → cadastra um novo produto via JSON.
- `@DeleteMapping("/produtos/api/{id}")` → deleta um produto pelo ID.
- `@PutMapping("/produtos/api/{id}")` → atualiza os dados de um produto existente.

---

📅 **Validação de Campos com Bean Validation**

A validação dos dados foi realizada com a especificação **Bean Validation (Jakarta Validation)**, integrada ao Spring Boot.

#### **Validação da entidade Usuarios**
```java
@NotBlank(message = "Nome é obrigatório")
@Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
private String nome;

@Email(message = "Email deve ser válido")
private String email;

@Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
private String senha;
```

#### **Validação da entidade Produtos**
```java
@NotBlank(message = "Nome é obrigatório")
@Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
private String nome;

@NotBlank(message = "Descrição é obrigatória")
private String descricao;

@DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
private Double preco;
```

Quando os dados são enviados para a API via JSON (por exemplo, usando o Postman), o Spring valida automaticamente os campos. Caso algum campo esteja inválido, é retornado um erro com as mensagens correspondentes.

---

💼 **APIs REST**

A aplicação também oferece suporte para comunicação via **API REST**, permitindo integração com sistemas externos ou uso em frontends modernos (ex: React, Angular, etc.).

#### **Exemplo de Endpoints para Usuarios:**
- `GET /usuarios/api` → Retorna todos os usuários.
- `GET /usuarios/api/{id}` → Retorna um único usuário por ID.
- `POST /usuarios/api` → Cadastra um novo usuário.
- `PUT /usuarios/api/{id}` → Atualiza um usuário existente.
- `DELETE /usuarios/api/{id}` → Exclui um usuário.

#### **Exemplo de Endpoints para Produtos:**
- `GET /produtos/api` → Retorna todos os produtos.
- `GET /produtos/api/{id}` → Retorna um único produto por ID.
- `POST /produtos/api` → Cadastra um novo produto.
- `PUT /produtos/api/{id}` → Atualiza um produto existente.
- `DELETE /produtos/api/{id}` → Exclui um produto.

---

🧪 **Testes das APIs**

Todos os testes das APIs (endpoints REST para Usuários e Produtos) foram organizados e podem ser acessados no link abaixo:

🔗 [Testes das APIs - Google Drive](https://drive.google.com/drive/folders/1HXA0LV1Jnavnf1ZTAG2JDN7q5iRPwMco?usp=drive_link)

O conteúdo inclui:
- Requisições simuladas com Postman.
- Exemplos de payloads JSON válidos e inválidos.
- Respostas esperadas e mensagens de erro de validação.

Isso garante maior transparência e facilidade para quem desejar testar a aplicação localmente ou em ambiente de desenvolvimento.

