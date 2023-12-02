package br.com.ifsul.monitoraifsul.service;

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

    public void cadastrarUsuario(Scanner scanner) {
        System.out.println("-------- Cadastro de Usuário --------");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        System.out.print("Você é um professor? (true/false): ");
        boolean isProfessor = scanner.nextBoolean();
        scanner.nextLine(); 

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
            int semestre = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Você é um monitor? (true/false): ");
            boolean isMonitor = scanner.nextBoolean();
            scanner.nextLine(); 

            Estudante estudante = new Estudante();
            estudante.setNome(nome);
            estudante.setEmail(email);
            estudante.setSenha(senha);
            estudante.setMatricula(matricula);
            estudante.setCurso(curso);
            estudante.setSemestre(semestre);
            estudante.setMonitor(isMonitor);

            if (isMonitor) {
                // Associar o estudante a uma disciplina para monitoria
                System.out.print("Digite o ID da disciplina para monitoria: ");
                long disciplinaId = scanner.nextLong();
                scanner.nextLine(); 

                Disciplina disciplina = disciplinaRepository.findById(disciplinaId)
                        .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com o ID: " + disciplinaId));

                estudante.setDisciplina(disciplina);
            }

            usuario = estudanteRepository.save(estudante);
        }

        System.out.println("Usuário cadastrado com sucesso!");
    }
}