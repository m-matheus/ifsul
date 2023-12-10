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
import br.com.ifsul.monitoraifsul.service.AgendamentoService;
import br.com.ifsul.monitoraifsul.service.DisciplinaService;
import br.com.ifsul.monitoraifsul.service.UsuarioService;


@SpringBootApplication
public class MonitoraifsulApplication implements CommandLineRunner {
    
    // Injeta automáticamente uma instância de UsuarioService e AgendamentoService
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private DisciplinaService disciplinaService;

    public static void main(String[] args) {
        SpringApplication.run(MonitoraifsulApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        Usuario usuarioLogado = null;

        while (!sair) {
            // Exibe o menu principal para o usuário
            System.out.println("===========================================");
            System.out.println("-------------- Menu Principal -------------");
            System.out.println("[1] Cadastrar Usuário");
            System.out.println("[2] Logar");
            System.out.println("[3] Excluir Usuário");
            System.out.println("[4] Editar Usuário");
            System.out.println("[5] Encerrar programa");
            System.out.println("===========================================");

            boolean voltar = false;

            while (!voltar) {
                // Solicita ao usuário que escolha uma opção do menu
                int opcao = scanner.nextInt();
                scanner.nextLine();

                // Realiza a ação correspondente à opção escolhida pelo usuário
                switch (opcao) {
                    case 1:
                        // Chama o serviço para cadastrar um novo usuário
                        usuarioService.cadastrarUsuario(scanner);
                        break;
                    case 2:
                        // Chama o serviço para realizar o login do usuário
                        usuarioLogado = usuarioService.fazerLogin(scanner);
                        if (usuarioLogado != null) {
                            System.out.println("Login bem-sucedido!");
                        }else{
                            System.out.println("===========================================");
                            System.out.println("");
                            System.out.println("ERRO! E-mail e/ou senha incorretos.");  
                            System.out.println("");
                            System.out.println("===========================================");                                     
                        }
                        break;
                    case 3:
                        usuarioService.excluirUsuario(scanner);
                        break;
                    case 4:
                        usuarioService.editarUsuario(scanner);
                        break;
                    case 5:
                        // Efetua o logout e encerra o loop de interação com o usuário
                        usuarioLogado = null;
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }

                // Executa ações adicionais se um usuário estiver logado
                if (usuarioLogado != null) {
                    System.out.println("Bem-vindo, " + usuarioLogado.getNome() + "!");
                    System.out.println("");
                    System.out.println("===========================================");
                    
                    // Funções específicas para usuários do tipo Professor
                    if (usuarioLogado instanceof Professor) {
                    
                        while (!voltar){
                            opcao = 0;
                            System.out.println("----------- Pagina do professor -----------");
                            System.out.println("[1] Cadastrar Disciplina");               
                            System.out.println("[2] Excluir Disciplina");
                            System.out.println("[3] Editar Disciplina");
                            System.out.println("[4] Logout");
                            System.out.println("===========================================");
                            
                            // Solicita ao professor que escolha uma opção
                            opcao = scanner.nextInt();
                            scanner.nextLine();
                            
                            switch (opcao) {
                                case 1:
                                    // Chama o serviço para cadastrar uma nova disciplina pelo professor
                                    usuarioService.cadastrarDisciplina(scanner, usuarioLogado);
                                    break;
                                case 2:
                                    disciplinaService.excluirDisciplina(scanner);
                                    break;
                                case 3:
                                    disciplinaService.editarDisciplina(scanner);
                                    break;
                                case 4:
                                    // Efetua o logout e encerra o loop de interação com o professor
                                    usuarioLogado = null;
                                    voltar = true;                	
                                    break;
                                default:
                                    System.out.println("Opção inválida. Tente novamente.");
                                    break;
                            }
                        }
                    }
                    
                    // Funções específicas para usuários do tipo Estudante
                    if (usuarioLogado instanceof Estudante) {
                        opcao = 0;
                        Estudante estudanteLogado = (Estudante) usuarioLogado;

                        while (!voltar){   
                            System.out.println("----------- Pagina do Estudante -----------");
                            System.out.println("[1] Ver Disciplinas Disponíveis");
                            System.out.println("[2] Associar a uma Disciplina (MONITOR)");
                            System.out.println("[3] Disponibilizar Agendamento (MONITOR)");
                            System.out.println("[4] Editar Agendamento (MONITOR)");
                            System.out.println("[5] Excluir Agendamento (MONITOR)");
                            System.out.println("[6] Marcar Agendamento (ESTUDANTE)");                    
                            System.out.println("[7] Logout");
                            System.out.println("===========================================");
                        
                            // Solicita ao estudante que escolha uma opção
                            opcao = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcao) {
                                case 1:
                                    disciplinaService.listarDisciplinas();                   
                                    break;
                                case 2:
                                    // Permite ao estudante associar-se a uma disciplina se for monitor
                                    if (estudanteLogado.isMonitor()) {
                                        disciplinaService.listarDisciplinas();                   
                                        disciplinaService.associarDisciplina(scanner, estudanteLogado);
                                        break;
                                    }else{
                                        System.out.println("===========================================");
                                        System.out.println("");
                                        System.out.println("ERRO! Você não possui autorização para selecionar essa opção.");  
                                        System.out.println("");
                                        System.out.println("===========================================");                                     
                                    }
                                    break;
                                case 3:
                                    // Permite ao estudante monitor disponibilizar agendamentos
                                    if (estudanteLogado.isMonitor()) {
                                        agendamentoService.disponibilizarAgendamentos(scanner, estudanteLogado);
                                        break;
                                    }else{
                                       System.out.println("===========================================");
                                       System.out.println("");
                                       System.out.println("ERRO! Você não possui autorização para selecionar essa opção.");
                                       System.out.println("");
                                       System.out.println("===========================================");
                                    }
                                    break;
                                case 4:
                                    if (estudanteLogado.isMonitor()) {
                                        agendamentoService.editarAgendamento(scanner);
                                        break;
                                    }else{
                                       System.out.println("===========================================");
                                       System.out.println("");
                                       System.out.println("ERRO! Você não possui autorização para selecionar essa opção.");
                                       System.out.println("");
                                       System.out.println("===========================================");                                       
                                    }
                                    break;    
                                case 5:
                                    if (estudanteLogado.isMonitor()) {
                                        agendamentoService.excluirAgendamento(scanner);
                                        break;
                                    }else{
                                        System.out.println("===========================================");
                                        System.out.println("");
                                        System.out.println("ERRO! Você não possui autorização para selecionar essa opção.");
                                        System.out.println("");
                                        System.out.println("===========================================");
                                    }
                                    break;
                                case 6:
                                    // Permite ao estudante não monitor selecionar um agendamento disponível
                                    if (!estudanteLogado.isMonitor()) {
                                        agendamentoService.selecionarAgendamento(scanner, estudanteLogado);
                                        break;
                                    }else{
                                       System.out.println("===========================================");
                                       System.out.println("");
                                       System.out.println("ERRO! Você não possui autorização para selecionar essa opção.");
                                       System.out.println("");
                                       System.out.println("===========================================");
                                    }
                                    break;
                                case 7:
                                    // Efetua o logout e encerra o loop de interação com o estudante
                                    usuarioLogado = null;
                                    voltar = true;
                                    break;
                                default:
                                    System.out.println("===========================================");    
                                    System.out.println("");
                                    System.out.println("Opção inválida. Tente novamente.");
                                    System.out.println("");
                                    System.out.println("===========================================");
                                    break;
                            }
                        }
                        
                    }
                } 
                break;
            }
        }

        // Mensagem de encerramento após sair do loop principal
        System.out.println("===========================================");
        System.out.println("");
        System.out.println("Obrigado por usar o Monitora IFSUL! Volte Sempre <3");
        System.out.println("");
        System.out.println("===========================================");
        scanner.close();
    }
}