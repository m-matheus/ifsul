package br.com.ifsul.monitoraifsul;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ifsul.monitoraifsul.service.UsuarioService;

@SpringBootApplication
public class MonitoraifsulApplication implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;

    public static void main(String[] args) {
        SpringApplication.run(MonitoraifsulApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("-------- Menu Principal --------");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Logar");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    usuarioService.cadastrarUsuario(scanner);
                    break;
                case 2:
                    // Adicione lógica de login aqui
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        System.out.println("Obrigado por usar o sistema!");
        scanner.close();
    }
}