package br.com.matheus.alugueldecarros.persistencia;

import java.util.List;

import br.com.matheus.alugueldecarros.model.Usuario;
import br.com.matheus.alugueldecarros.model.Veiculo;

public class RepositorioUsuario {
    private List<Usuario> usuarios;
    private Usuario usuarioLogado;

    public RepositorioUsuario() {}

    public Boolean adicionarUsuario(String nome, String email, String senha) {
        List<Veiculo> veiculos = null;
        Usuario novoUsuario = new Usuario(nome, email, senha);
        return usuarios.add(novoUsuario);
    }

    public Boolean logar(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        usuarioLogado = null;
    }

}
