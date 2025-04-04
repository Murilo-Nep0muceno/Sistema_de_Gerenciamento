🧱 Arquitetura MVC (Model-View-Controller)

A estrutura da aplicação foi baseada no padrão MVC, amplamente utilizado para separar responsabilidades e tornar o código mais limpo, organizado e de fácil manutenção. Abaixo, explicamos cada camada e sua função no projeto:
🔹 Model (Modelo)

Representa os objetos de domínio da aplicação. No nosso caso, a entidade Usuarios foi criada para representar os usuários no sistema.

Exemplo de atributos no modelo:

private Long id;
private String nome;
private String email;
private String senha;

🔹 View (Visão)

A camada de visualização foi construída com o Thymeleaf, que facilita a renderização dinâmica de páginas HTML utilizando dados fornecidos pelo backend. Isso permite a criação de formulários interativos, listagens, e ações como editar e excluir usuários.
🔹 Controller (Controlador)

Os controladores (@Controller e @RestController) são responsáveis por receber requisições HTTP, processar os dados (via Model) e retornar uma View (HTML) ou um JSON (no caso de APIs REST).

Exemplos de endpoints:

    @GetMapping("/usuarios") → retorna a página HTML com a lista de usuários.

    @PostMapping("/api") → cadastra um novo usuário via JSON (Postman).

    @DeleteMapping("/api/{id}") → deleta um usuário pelo ID.

    @PutMapping("/api/{id}") → atualiza os dados de um usuário existente.

✅ Validação de Campos com Bean Validation

A validação dos dados foi realizada com a especificação Bean Validation (Jakarta Validation), integrada ao Spring Boot.

A entidade Usuarios foi anotada com restrições de validação, como:

@NotBlank(message = "Nome é obrigatório")
@Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")

@Email(message = "Email deve ser válido")

@Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")

Quando os dados são enviados para a API via JSON (por exemplo, usando o Postman), o Spring valida automaticamente os campos. Caso algum campo esteja inválido, é retornado um erro com as mensagens correspondentes.
📡 APIs REST

A aplicação também oferece suporte para comunicação via API REST, permitindo integração com sistemas externos ou uso em frontends modernos (ex: React, Angular, etc).
Exemplo de Endpoints:

    GET /usuarios/api → Retorna todos os usuários.

    GET /usuarios/api/{id} → Retorna um único usuário por ID.

    POST /usuarios/api → Cadastra um novo usuário.

    PUT /usuarios/api/{id} → Atualiza um usuário existente.

    DELETE /usuarios/api/{id} → Exclui um usuário.
