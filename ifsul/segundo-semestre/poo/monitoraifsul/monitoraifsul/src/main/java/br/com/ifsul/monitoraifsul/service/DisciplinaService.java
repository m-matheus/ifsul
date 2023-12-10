package br.com.ifsul.monitoraifsul.service;

import java.util.List;
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
    
    public List<Disciplina> listarDisciplinas() {
        // Utiliza o método findAll do repositório de disciplinas para retornar a lista completa de disciplinas
        System.out.println("===========================================");
        System.out.println("----------- Lista de Disciplinas ----------");
        System.out.println("");
        
        List<Disciplina> disciplinas = disciplinaRepository.findAll();
        
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas cadastradas ainda.");
            System.out.println();
            System.out.println("===========================================");
        }

        for (Disciplina disciplina : disciplinas) {
            System.out.println("ID: [" + disciplina.getId() + "] Materia: [" + disciplina.getMateria() + "]");
        }
        System.out.println();
        System.out.println("===========================================");
        
        return disciplinas;
    }
    
    public void excluirDisciplina(Scanner scanner) {
        
        // Lista as disciplinas disponíveis
        List<Disciplina> disciplinas = listarDisciplinas();
    
        if (disciplinas.isEmpty()) {
            System.out.println("===========================================");
            System.out.println();
            System.out.println("Não há disciplinas para excluir.");
            System.out.println();
            System.out.println("===========================================");
            return;
        }
    
        // Solicita ao usuário que escolha um ID para excluir
        System.out.println("");
        System.out.print("Digite o ID da disciplina que deseja excluir: ");
        long disciplinaId = Long.parseLong(scanner.nextLine());
    
        // Verifica se o ID fornecido está na lista de disciplinas
        boolean disciplinaEncontrada = disciplinas.stream().anyMatch(disciplina -> disciplina.getId() == disciplinaId);
    
        if (disciplinaEncontrada) {
            // Busca a disciplina no banco de dados pelo ID e a exclui
            Disciplina disciplina = disciplinaRepository.findById(disciplinaId)
                    .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com o ID: " + disciplinaId));
    
            List<Estudante> estudantes = estudanteRepository.findByDisciplina(disciplina);
            
            for (Estudante estudante : estudantes) {
                estudante.setDisciplina(null);
                estudanteRepository.save(estudante);
            }

            disciplinaRepository.delete(disciplina);
            System.out.println("");
            System.out.println("Disciplina excluída com sucesso!");
            System.out.println("");
            System.out.println("===========================================");
        } else {
            System.out.println("");
            System.out.println("ID de disciplina inválido. Nenhuma disciplina foi excluída.");
            System.out.println();
            System.out.println("===========================================");
        }
    }

    public void editarDisciplina(Scanner scanner) {
        // Lista as disciplinas disponíveis
        List<Disciplina> disciplinas = listarDisciplinas();
    
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas para editar.");
            System.out.println();
            System.out.println("===========================================");
            return;
        }
    
        // Solicita ao usuário que escolha um ID para editar
        System.out.println();
        System.out.print("Digite o ID da disciplina que deseja editar: ");
        long disciplinaId = Long.parseLong(scanner.nextLine());
    
        // Verifica se o ID fornecido está na lista de disciplinas
        boolean disciplinaEncontrada = disciplinas.stream().anyMatch(disciplina -> disciplina.getId() == disciplinaId);
    
        if (disciplinaEncontrada) {
            // Busca a disciplina no banco de dados pelo ID
            Disciplina disciplina = disciplinaRepository.findById(disciplinaId)
                    .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com o ID: " + disciplinaId));
    
            // Solicita as alterações desejadas ao usuário
            System.out.print("Digite o novo nome da disciplina: ");
            String novoNome = scanner.nextLine();
            disciplina.setMateria(novoNome);    

    
            // Salva as alterações no banco de dados
            disciplinaRepository.save(disciplina);
            
            System.out.println("===========================================");
            System.out.println();
            System.out.println("Disciplina editada com sucesso!");
            System.out.println();
            System.out.println("===========================================");
        } else {
            System.out.println("===========================================");
            System.out.println();
            System.out.println("ID de disciplina inválido. Nenhuma disciplina foi editada.");
            System.out.println();
            System.out.println("===========================================");
        }
    }
}
