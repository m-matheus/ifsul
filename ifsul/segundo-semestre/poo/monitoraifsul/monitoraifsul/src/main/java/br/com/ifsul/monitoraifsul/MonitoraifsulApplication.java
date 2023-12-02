package br.com.ifsul.monitoraifsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MonitoraifsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoraifsulApplication.class, args);

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
                    cadastrarUsuario(scanner);
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

    private static void cadastrarUsuario(Scanner scanner) {
        // Lógica de cadastro de usuário aqui
    }
}