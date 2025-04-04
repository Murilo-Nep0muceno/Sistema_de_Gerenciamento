function form(event){
    event.preventDefault()
    const nome = document.querySelector("#nome").value
    const email = document.querySelector("#email").value
    const senha = document.querySelector("#senha").value
    
    const usuario = {
        nome: nome,
        email: email,
        senha: senha,

    }

    fetch('http://localhost:8080/usuarios', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json' 
        },
        body: JSON.stringify(usuario) 
        
      })
      .then(response => response.json() )
      .then(data => console.log('Sucesso:', data))
      .catch(error => console.error('Erro:', error));

}
function editarUsuario(button) {
    const id = button.getAttribute('data-id');
    const nome = button.getAttribute('data-nome');
    const email = button.getAttribute('data-email');
    const senha = button.getAttribute('data-senha');

    // Preenche o formulário de edição
    document.getElementById("editId").value = id;
    document.getElementById("editNome").value = nome;
    document.getElementById("editEmail").value = email;
    document.getElementById("editSenha").value = senha;

    // Mostra o form de edição
    document.getElementById("editForm").style.display = "block";
}

function salvarEdicao(event) {
    event.preventDefault();

    const id = document.getElementById('editId').value;
    const nome = document.getElementById('editNome').value;
    const email = document.getElementById('editEmail').value;
    const senha = document.getElementById('editSenha').value;

    const usuarioAtualizado = { nome, email, senha };

    fetch(`/usuarios/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuarioAtualizado)
    })
    .then(response => {
        if (response.ok) {
            alert('Usuário atualizado com sucesso!');
            location.reload(); // Recarregar a página para atualizar a lista
        } else {
            alert('Erro ao atualizar o usuário.');
        }
    })
    .catch(error => console.error('Erro:', error));
}



function excluirUsuario(id) {
    if (confirm('Tem certeza que deseja excluir o usuário?')) {
        fetch(`/usuarios/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                alert('Usuário excluído com sucesso!');
                // Recarrega a página para atualizar a lista de usuários
                location.reload();
            } else {
                alert('Erro ao excluir o usuário.');
            }
        })
        .catch(error => console.error('Erro:', error));
    }
}