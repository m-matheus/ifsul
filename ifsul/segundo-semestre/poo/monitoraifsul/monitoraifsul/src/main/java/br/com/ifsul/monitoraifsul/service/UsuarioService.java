package br.com.ifsul.monitoraifsul.service;

import java.util.Optional;
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

            if (isMonitor) {
                System.out.print("Digite o ID da disciplina para monitoria: ");
                long disciplinaId = Long.parseLong(scanner.nextLine());

                Disciplina disciplina = disciplinaRepository.findById(disciplinaId)
                        .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com o ID: " + disciplinaId));

                estudante.setDisciplina(disciplina);
            }

            usuario = estudanteRepository.save(estudante);
        }

        System.out.println("Usuário cadastrado com sucesso!");
    }

    // Faz login
    // public Usuario fazerLogin(String email, String senha) {
    //     Usuario usuario = usuarioRepository.findByEmail(email);

    //     if (usuario != null && usuario.getSenha().equals(senha)) {
    //         return usuario;
    //     } else {
    //         throw new RuntimeException("Usuário não encontrado ou senha incorreta para o email: " + email);
    //     }
    // }

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
            professor.adicionarDisciplina(savedDisciplina);
            professorRepository.save(professor);

            System.out.println("Disciplina cadastrada com sucesso!");
        } else {
            System.out.println("Apenas professores podem cadastrar disciplinas.");
        }
    }
}