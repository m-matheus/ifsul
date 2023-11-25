package br.com.ifsul.monitoraifsul.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsul.monitoraifsul.entity.Usuario;
import br.com.ifsul.monitoraifsul.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    // Injeta automáticamente as dependências.
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario cadastrar() {
        // Criando um teclado.
        Scanner scanner = new Scanner(System.in);

        // Pedindo os dados para criar o novo usuário.
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        // Criando um novo usuário e setando os valores digitados anteriormente nele.
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        // Fechando o teclado.
        scanner.close();

        // Salvando o usuário no banco com o repository.
        return usuarioRepository.save(usuario);
    }

    // Recebe como parâmetro email e senha
    public Usuario fazerLogin(String email, String senha) {
        // Procura pelo email fornecido
        Usuario usuario = usuarioRepository.findByEmail(email);

        // Se encontra o email E a senha do parâmetro é igual a senha do email que foi encontrado, retorna o usuário.
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        
        return null;
    }

}
