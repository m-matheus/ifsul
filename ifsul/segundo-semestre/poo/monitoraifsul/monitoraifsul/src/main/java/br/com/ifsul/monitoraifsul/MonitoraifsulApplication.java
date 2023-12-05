package br.com.ifsul.monitoraifsul;

import java.util.Scanner;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ifsul.monitoraifsul.entity.Disciplina;
import br.com.ifsul.monitoraifsul.entity.Estudante;
import br.com.ifsul.monitoraifsul.entity.Professor;
import br.com.ifsul.monitoraifsul.entity.Usuario;
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
        Usuario usuarioLogado = null;

        while (!sair) {
            System.out.println("-------- Menu Principal --------");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Logar");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    usuarioService.cadastrarUsuario(scanner);
                    break;
                case 2:
                    usuarioLogado = usuarioService.fazerLogin(scanner);
                    if (usuarioLogado != null) {
                        System.out.println("Login bem-sucedido!");
                    }
                    break;
                case 3:
                    usuarioLogado = null;
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            if (usuarioLogado != null) {
                System.out.println("Bem-vindo, " + usuarioLogado.getNome() + "!");
                System.out.println("");

                // Funções do usuário professor
                if (usuarioLogado instanceof Professor) {
                  opcao = 0;
                  
                  System.out.println("-------- Pagina do professor --------");
                  System.out.println("1. Cadastrar Disciplina");               
                  System.out.println("2. Sair");
                  
                  opcao = scanner.nextInt();
                  scanner.nextLine();
                  
                  switch (opcao) {
                	case 1:
                		usuarioService.cadastrarDisciplina(scanner, usuarioLogado);
                		break;
                	case 2:
                		usuarioLogado = null;
                		sair = true;                	
                		break;
                	default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                  }
                }
                
                if (usuarioLogado instanceof Estudante) {
                	opcao = 0;
                    Estudante estudanteLogado = (Estudante) usuarioLogado;

                	System.out.println("-------- Pagina do Estudante --------");
                	System.out.println("1. Ver Disciplinas Disponíveis");
                    System.out.println("2. Associar a uma Disciplina (MONITORES)");
                    System.out.println("3. Marcar Agendamento (ESTUDANTE)");
                    System.out.println("4. Sair");

                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            List<Disciplina> disciplinasDisponiveis = usuarioService.listarDisciplinasDisponiveis();
                            System.out.println("Disciplinas Disponíveis:");
                            for (Disciplina disciplina : disciplinasDisponiveis) {
                                System.out.println(disciplina.getId() + ". " + disciplina.getMateria());
                            }
                            break;
                        case 2:
                            if (estudanteLogado.isMonitor()) {
                                usuarioService.associarDisciplina(scanner, estudanteLogado);
                            }
                            break;
                        case 3:
                            if (!estudanteLogado.isMonitor()) {
                                // continuar aqui
                            }
                            break;
                        case 4: 
                            usuarioLogado = null;
                            sair = true;
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }

                    
                }
            } else {
                System.out.println("Nenhum usuário logado.");
            }
        }

        
        System.out.println("Obrigado por usar o sistema!");
        scanner.close();
    }
}