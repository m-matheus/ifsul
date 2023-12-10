package br.com.ifsul.monitoraifsul.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsul.monitoraifsul.entity.Disciplina;
import br.com.ifsul.monitoraifsul.entity.Estudante;
import br.com.ifsul.monitoraifsul.entity.Professor;
import br.com.ifsul.monitoraifsul.entity.Usuario;
import br.com.ifsul.monitoraifsul.repository.DisciplinaRepository;
import br.com.ifsul.monitoraifsul.repository.EstudanteRepository;
import br.com.ifsul.monitoraifsul.repository.ProfessorRepository;
import br.com.ifsul.monitoraifsul.repository.UsuarioRepository;

@Service
public class UsuarioService {
    // Injeta automáticamente a depência do repositório selecionado
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    // Cadastra o usuario.
    public void cadastrarUsuario(Scanner scanner) {
        // Solicita ao usuário as informações e lê as entradas
        System.out.println("===========================================");
        System.out.println("----------- Cadastro de Usuário -----------");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        System.out.print("Você é um professor? (true/false): ");
        boolean isProfessor = Boolean.parseBoolean(scanner.nextLine());

        // Cria uma instância de Usuário
        Usuario usuario;

        // Verifica se o usuário é professor
        if (isProfessor) {
            // Solicita ao usuário as informações especificas de professor e lê as entradas
            System.out.print("Digite a formação: ");
            String formacao = scanner.nextLine();

            // Cria uma instância de Professor e atribui os dados fornecidos
            Professor professor = new Professor();
            professor.setNome(nome);
            professor.setEmail(email);
            professor.setSenha(senha);
            professor.setFormacao(formacao);

            // Salva o professor no repositório de professores e atribui à variável usuario
            usuario = professorRepository.save(professor);
        } else {
            // Se não for um professor, é um estudante

            // Solicita ao usuário as informações especificas de estudante e lê as entradas
            System.out.print("Digite a matrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Digite o curso: ");
            String curso = scanner.nextLine();
            System.out.print("Digite o semestre: ");
            int semestre = Integer.parseInt(scanner.nextLine());
            System.out.print("Você é um monitor? (true/false): ");
            boolean isMonitor = Boolean.parseBoolean(scanner.nextLine());

            // Cria uma instância de Estudante e atribui os dados fornecidos
            Estudante estudante = new Estudante();
            estudante.setNome(nome);
            estudante.setEmail(email);
            estudante.setSenha(senha);
            estudante.setMatricula(matricula);
            estudante.setCurso(curso);
            estudante.setSemestre(semestre);
            estudante.setMonitor(isMonitor);

            // Salva o estudante no repositório de estudantes e atribui à variável usuario
            usuario = estudanteRepository.save(estudante);
        }

        // Exibe uma mensagem indicando que o usuário foi cadastrado com sucesso
        System.out.println("===========================================");
        System.out.println("");
        System.out.println("Usuário cadastrado com sucesso!");
        System.out.println("");
    }

    public Usuario fazerLogin(Scanner scanner) {
        // Solicita ao usuário as informações de login para autenticação
        System.out.println("===========================================");
        System.out.println("------------------ Login ------------------");
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        System.out.println("===========================================");
        System.out.println(" ");

        // Busca um usuário no repositório com o email fornecido
        Usuario usuario = usuarioRepository.findByEmail(email);

        // Verifica se o usuário foi encontrado e se a senha fornecida coincide com a
        // senha salva no banco de dados
        if (usuario != null && usuario.getSenha().equals(senha)) {
            // Retorna o usuário se as credenciais estiverem corretas
            return usuario;
        } else {
            // Lança uma exceção se o usuário não for encontrado ou se a senha estiver
            // incorreta
            throw new RuntimeException("Usuário não encontrado ou senha incorreta para o email: " + email);
        }
    }

    public void cadastrarDisciplina(Scanner scanner, Usuario usuario) {
        // Verifica se o usuário é um Professor antes de permitir o cadastro da
        // disciplina
        if (usuario instanceof Professor) {
            // Solicita ao usuário que digite as informações da disciplina
            System.out.println("===========================================");
            System.out.println("---------- Cadastro de Disciplina ---------");
            System.out.print("Digite o nome da disciplina: ");
            String nomeDisciplina = scanner.nextLine();

            // Cria uma nova instância de Disciplina e atribui os dados fornecidos
            Disciplina disciplina = new Disciplina();
            disciplina.setMateria(nomeDisciplina);

            // Salva a disciplina no repositório
            disciplinaRepository.save(disciplina);

            // Converte o usuário para Professor, pois já foi verificado que é do tipo
            // Professor
            Professor professor = (Professor) usuario;

            // Salva as alterações no repositório de professores
            professorRepository.save(professor);

            // Mensagem indicando que o cadastro da disciplina foi bem-sucedido
            System.out.println();
            System.out.println("Disciplina cadastrada com sucesso!");
            System.out.println();
            System.out.println("===========================================");
        }
    }

    public List<Estudante> listarEstudantesMonitores() {
        // Utiliza o método findByMonitor do repositório de estudantes para retornar a
        // lista de estudantes monitores
        return estudanteRepository.findByMonitor(true);
    }

    // public List<Disciplina> listarDisciplinasDisponiveis() {
    //     // Utiliza o método findAll do repositório de disciplinas para retornar a lista
    //     // completa de disciplinas
    //     return disciplinaRepository.findAll();
    // }

    public List<Usuario> listarUsuarios() {
        System.out.println("===========================================");
        System.out.println("------------ Lista de Usuários ------------");
        System.out.println("");
    
        // Recupera a lista de todos os usuários do banco de dados
        List<Usuario> usuarios = usuarioRepository.findAll();
    
        // Exibe as informações de cada usuário
        for (Usuario usuario : usuarios) {
            System.out.println("ID: [" + usuario.getId() + "] Nome: [" + usuario.getNome() + "] Email: [" + usuario.getEmail() + "]");
        }
    
        return usuarios;
    }
    
    public void excluirUsuario(Scanner scanner) {
        // Lista os usuários disponíveis
        List<Usuario> usuarios = listarUsuarios();
    
        if (usuarios.isEmpty()) {
            System.out.println("Não há usuários para excluir.");
            return;
        }
    
        // Solicita ao usuário que escolha um ID para excluir
        System.out.println("");
        System.out.print("Digite o ID do usuário que deseja excluir: ");
        long usuarioId = Long.parseLong(scanner.nextLine());
    
        // Verifica se o ID fornecido está na lista de usuários
        boolean usuarioEncontrado = usuarios.stream().anyMatch(usuario -> usuario.getId() == usuarioId);
    
        if (usuarioEncontrado) {
            // Busca o usuário no banco de dados pelo ID e o exclui
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + usuarioId));
    
            usuarioRepository.delete(usuario);
            System.out.println("");
            System.out.println("Usuário excluído com sucesso!");
        } else {
            System.out.println("");
            System.out.println("ID de usuário inválido. Nenhum usuário foi excluído.");
        }
    } 

    public void editarUsuario(Scanner scanner) {
        // Lista os usuários disponíveis
        List<Usuario> usuarios = listarUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("Não há usuários para editar.");
            return;
        }

        // Solicita ao usuário que escolha um ID para editar
        System.out.print("Digite o ID do usuário que deseja editar: ");
        long usuarioId = Long.parseLong(scanner.nextLine());

        // Verifica se o ID fornecido está na lista de usuários
        boolean usuarioEncontrado = usuarios.stream().anyMatch(usuario -> usuario.getId() == usuarioId);

        if (usuarioEncontrado) {
            // Busca o usuário no banco de dados pelo ID
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + usuarioId));

            // Solicita as alterações desejadas ao usuário
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            usuario.setNome(novoNome);

            System.out.print("Digite o novo email: ");
            String novoEmail = scanner.nextLine();
            usuario.setEmail(novoEmail);

            // Salva as alterações no banco de dados
            usuarioRepository.save(usuario);

            System.out.println("Usuário editado com sucesso!");
        } else {
            System.out.println("ID de usuário inválido. Nenhum usuário foi editado.");
        }
    }
}