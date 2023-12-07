package br.com.ifsul.monitoraifsul.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsul.monitoraifsul.entity.Agendamento;
import br.com.ifsul.monitoraifsul.entity.Disciplina;
import br.com.ifsul.monitoraifsul.entity.Estudante;
import br.com.ifsul.monitoraifsul.entity.Professor;
import br.com.ifsul.monitoraifsul.entity.Usuario;
import br.com.ifsul.monitoraifsul.repository.AgendamentoRepository;
import br.com.ifsul.monitoraifsul.repository.DisciplinaRepository;
import br.com.ifsul.monitoraifsul.repository.EstudanteRepository;
import br.com.ifsul.monitoraifsul.repository.ProfessorRepository;
import br.com.ifsul.monitoraifsul.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;


    // Cadastra o usuario.
    public void cadastrarUsuario(Scanner scanner) {
        System.out.println("-------- Cadastro de Usuário --------");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        System.out.print("Você é um professor? (true/false): ");
        boolean isProfessor = Boolean.parseBoolean(scanner.nextLine());

        Usuario usuario;

        if (isProfessor) {
            System.out.print("Digite a formação: ");
            String formacao = scanner.nextLine();

            Professor professor = new Professor();
            professor.setNome(nome);
            professor.setEmail(email);
            professor.setSenha(senha);
            professor.setFormacao(formacao);

            usuario = professorRepository.save(professor);
        } else {
            System.out.print("Digite a matrícula: ");
            String matricula = scanner.nextLine();

            System.out.print("Digite o curso: ");
            String curso = scanner.nextLine();

            System.out.print("Digite o semestre: ");
            int semestre = Integer.parseInt(scanner.nextLine());

            System.out.print("Você é um monitor? (true/false): ");
            boolean isMonitor = Boolean.parseBoolean(scanner.nextLine());

            Estudante estudante = new Estudante();
            estudante.setNome(nome);
            estudante.setEmail(email);
            estudante.setSenha(senha);
            estudante.setMatricula(matricula);
            estudante.setCurso(curso);
            estudante.setSemestre(semestre);
            estudante.setMonitor(isMonitor);

            // if (isMonitor) {
            //     System.out.print("Digite o ID da disciplina para monitoria: ");
            //     long disciplinaId = Long.parseLong(scanner.nextLine());

            //     Disciplina disciplina = disciplinaRepository.findById(disciplinaId)
            //             .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com o ID: " + disciplinaId));

            //     estudante.setDisciplina(disciplina);
            // }

            usuario = estudanteRepository.save(estudante);
        }

        System.out.println("Usuário cadastrado com sucesso!");
    }
    

    public Usuario fazerLogin(Scanner scanner) {
        System.out.println("-------- Login --------");
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        } else {
            throw new RuntimeException("Usuário não encontrado ou senha incorreta para o email: " + email);
        }
    }

    public void cadastrarDisciplina(Scanner scanner, Usuario usuario) {
        if (usuario instanceof Professor) {
            System.out.println("-------- Cadastro de Disciplina --------");
            System.out.print("Digite o nome da disciplina: ");
            String nomeDisciplina = scanner.nextLine();

            Disciplina disciplina = new Disciplina();
            disciplina.setMateria(nomeDisciplina);

            Disciplina savedDisciplina = disciplinaRepository.save(disciplina);

            Professor professor = (Professor) usuario;
            // professor.getDisciplinas().add(savedDisciplina);
            professorRepository.save(professor);

            System.out.println("Disciplina cadastrada com sucesso!");
        } else {
            System.out.println("Apenas professores podem cadastrar disciplinas.");
        }
    }

    public List<Estudante> listarEstudantesMonitores() {
        return estudanteRepository.findByMonitor(true);
    }

    public List<Disciplina> listarDisciplinasDisponiveis() {
        return disciplinaRepository.findAll();
    }

    public void associarDisciplina(Scanner scanner, Estudante estudante) {
        if (estudante.isMonitor()) {
            System.out.print("Digite o ID da disciplina que deseja associar: ");
            long disciplinaId = scanner.nextLong();
            scanner.nextLine();
    
            Disciplina disciplinaAssociada = disciplinaRepository.findById(disciplinaId)
                    .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com o ID: " + disciplinaId));
    
            estudante.setDisciplina(disciplinaAssociada);
            estudanteRepository.save(estudante);
    
            System.out.println("Associado à disciplina com sucesso!");
        } else {
            System.out.println("Você não é um estudante monitor. Não pode associar a uma disciplina.");
        }
    }

     public void disponibilizarAgendamentos(Scanner scanner, Estudante estudante) {
        if (estudante.isMonitor() && estudante.getDisciplina() != null) {
            System.out.print("Digite o dia da semana do agendamento: ");
            String diaSemana = scanner.nextLine();

            System.out.print("Digite o turno do agendamento: ");
            String turno = scanner.nextLine();

            System.out.print("Digite o número de vagas disponíveis: ");
            int vagas = scanner.nextInt();
            scanner.nextLine();

            Agendamento agendamento = new Agendamento();
            agendamento.setDiaSemana(diaSemana);
            agendamento.setTurno(turno);
            agendamento.setVagas(vagas);
            // agendamento.setEstudanteMonitor(estudante);
            // agendamento.setDisciplina(estudante.getDisciplina());

            agendamentoRepository.save(agendamento);

            System.out.println("Agendamento disponibilizado com sucesso!");
        } else {
            System.out.println("Você não é um estudante monitor ou não está associado a uma disciplina.");
        }
    }

    public void selecionarAgendamento(Scanner scanner, Estudante estudante) {
        List<Agendamento> agendamentosDisponiveis = agendamentoRepository.findByDisciplina(estudante.getDisciplina());
        

        if (!agendamentosDisponiveis.isEmpty()) {
            System.out.println("Agendamentos Disponíveis:");
            for (Agendamento agendamento : agendamentosDisponiveis) {
                System.out.println(agendamento.getId() + ". Dia: " + agendamento.getDiaSemana() +
                        ", Turno: " + agendamento.getTurno() + ", Vagas: " + agendamento.getVagas());
            }

            System.out.print("Digite o ID do agendamento que deseja selecionar: ");
            long agendamentoId = scanner.nextLong();
            scanner.nextLine();

            Agendamento agendamentoSelecionado = agendamentoRepository.findById(agendamentoId)
                    .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + agendamentoId));

            // Lógica para associar o agendamento ao usuário não monitor
            estudante.getAgendaNormal().add(agendamentoSelecionado);
            estudanteRepository.save(estudante);

            System.out.println("Agendamento selecionado com sucesso!");
        } else {
            System.out.println("Não há agendamentos disponíveis para a disciplina associada.");
        }
    }
    
}