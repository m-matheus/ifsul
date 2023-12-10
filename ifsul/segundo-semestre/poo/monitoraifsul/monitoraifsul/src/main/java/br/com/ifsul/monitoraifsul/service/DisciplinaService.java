package br.com.ifsul.monitoraifsul.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsul.monitoraifsul.entity.Disciplina;
import br.com.ifsul.monitoraifsul.entity.Estudante;
import br.com.ifsul.monitoraifsul.repository.DisciplinaRepository;
import br.com.ifsul.monitoraifsul.repository.EstudanteRepository;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    public void associarDisciplina(Scanner scanner, Estudante estudante) {
        // Verifica se o estudante é um monitor antes de permitir a associação com uma
        // disciplina
        if (estudante.isMonitor() == true) {
            // Solicita ao usuário que digite o ID da disciplina que deseja associar
            System.out.println("");
            System.out.print("Digite o ID da disciplina que deseja associar: ");
            System.out.println("");
            long disciplinaId = scanner.nextLong();
            scanner.nextLine();

            // Busca a disciplina no repositório pelo ID fornecido, lançando uma exceção se
            // não for encontrada
            Disciplina disciplinaAssociada = disciplinaRepository.findById(disciplinaId)
                    .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com o ID: [" + disciplinaId + "]"));

            // Associa a disciplina ao estudante e salva as alterações no repositório de
            // estudantes
            estudante.setDisciplina(disciplinaAssociada);
            estudanteRepository.save(estudante);

            // Mensagem indicando que a associação foi bem-sucedida
            System.out.println("");
            System.out.println("Associado à disciplina com sucesso!");
            System.out.println("");
            System.out.println("===========================================");
        } else {
            // Mensagem indicando que apenas estudantes monitores podem associar-se a uma
            // disciplina
            System.out.println("");
            System.out.println("Você não é um estudante monitor. Não pode associar a uma disciplina.");
            System.out.println("");
            System.out.println("===========================================");
        }
    }
}
