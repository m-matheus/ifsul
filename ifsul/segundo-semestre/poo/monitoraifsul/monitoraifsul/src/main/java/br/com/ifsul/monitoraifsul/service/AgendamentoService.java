package br.com.ifsul.monitoraifsul.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsul.monitoraifsul.entity.Agendamento;
import br.com.ifsul.monitoraifsul.entity.Disciplina;
import br.com.ifsul.monitoraifsul.entity.Estudante;
import br.com.ifsul.monitoraifsul.entity.Usuario;
import br.com.ifsul.monitoraifsul.repository.AgendamentoRepository;
import br.com.ifsul.monitoraifsul.repository.EstudanteRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    public void disponibilizarAgendamentos(Scanner scanner, Estudante estudante) {
        // Verifica se o estudante é um monitor e está associado a uma disciplina antes
        // de permitir a disponibilização de agendamentos
        if (estudante.isMonitor() && estudante.getDisciplina() != null) {
            // Solicita ao usuário que digite as informações do agendamento
            System.out.println("===========================================");
            System.out.print("Digite o dia da semana do agendamento: ");
            String diaSemana = scanner.nextLine();
            System.out.print("Digite o turno do agendamento: ");
            String turno = scanner.nextLine();
            System.out.print("Digite o número de vagas disponíveis: ");
            int vagas = scanner.nextInt();
            scanner.nextLine();

            // Cria uma nova instância de Agendamento e atribui os dados fornecidos
            Agendamento agendamento = new Agendamento();
            agendamento.setDiaSemana(diaSemana);
            agendamento.setTurno(turno);
            agendamento.setVagas(vagas);

            // Salva o agendamento no repositório de agendamentos
            agendamentoRepository.save(agendamento);

            // Mensagem indicando que o agendamento foi disponibilizado com sucesso
            System.out.println("");
            System.out.println("===========================================");
            System.out.println("");
            System.out.println("Agendamento disponibilizado com sucesso!");
            System.out.println("");
            System.out.println("===========================================");
        } else {
            // Mensagem indicando que apenas estudantes monitores associados a uma
            // disciplina podem disponibilizar agendamentos
            System.out.println("Você não é um estudante monitor ou não está associado a uma disciplina.");
        }
    }

    public void selecionarAgendamento(Scanner scanner, Estudante estudante) {
        // Obtém a lista de agendamentos disponíveis pela disciplina
        List<Agendamento> agendamentosDisponiveis = agendamentoRepository.findByDisciplina(estudante.getDisciplina());
    
        // Verifica se há agendamentos disponíveis
        if (!agendamentosDisponiveis.isEmpty() && !estudante.isMonitor()) {
            // Exibe os agendamentos disponíveis para que o estudante faça uma escolha
            System.out.println("===========================================");
            System.out.println("Agendamentos Disponíveis:");
            for (Agendamento agendamento : agendamentosDisponiveis) {
                System.out.println("[" + agendamento.getId() + "] Dia: " + agendamento.getDiaSemana() +
                        ", Turno: " + agendamento.getTurno() + ", Vagas: " + agendamento.getVagas());
            }
    
            // Solicita ao usuário que digite o ID do agendamento que deseja selecionar
            System.out.println("");
            System.out.println("Digite o ID do agendamento que deseja selecionar: ");
            System.out.println("===========================================");
            long agendamentoId = scanner.nextLong();
            scanner.nextLine();
    
            // Busca o agendamento no repositório pelo ID fornecido, lançando uma exceção se
            // não for encontrado
            Agendamento agendamentoSelecionado = agendamentoRepository.findById(agendamentoId)
                    .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + agendamentoId));
    
            // Verifica se há vagas disponíveis no agendamento
            if (agendamentoSelecionado.getVagas() > 0) {
                // Adiciona o agendamento selecionado à agenda normal do estudante
                estudante.getAgendaNormal().add(agendamentoSelecionado);
    
                // Diminui o número de vagas no agendamento
                agendamentoSelecionado.setVagas(agendamentoSelecionado.getVagas() - 1);
    
                // Salva as alterações nos repositórios de estudantes e agendamentos
                estudanteRepository.save(estudante);
                agendamentoRepository.save(agendamentoSelecionado);
    
                // Mensagem indicando que o agendamento foi selecionado com sucesso
                System.out.println("===========================================");
                System.out.println("");
                System.out.println("Agendamento selecionado com sucesso!");
                System.out.println("");
                System.out.println("===========================================");
            } else {
                // Mensagem indicando que não há vagas disponíveis no agendamento
                System.out.println("===========================================");
                System.out.println("");
                System.out.println("Não há vagas disponíveis no agendamento selecionado.");
                System.out.println("");
                System.out.println("===========================================");
            }
        } else {
            // Mensagem indicando que não há agendamentos disponíveis para a disciplina
            // associada
            System.out.println("===========================================");
            System.out.println("");
            System.out.println("Não há agendamentos disponíveis para a disciplina associada.");
            System.out.println("");
            System.out.println("===========================================");
        }
    }

    public List<Agendamento> listarAgendamentos() {
        // Utiliza o método findAll do repositório de agendamentos para retornar a lista
        // completa de agendamentos
        System.out.println("===========================================");
        System.out.println("------------ Lista de Agendamentos ------------");
        System.out.println("");

        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        
        for (Agendamento agendamento : agendamentos) {
            System.out.println("ID: [" + agendamento.getId() + "] Dia: [" + agendamento.getDiaSemana() + "] Turno: [" + agendamento.getTurno() + "]");
        }

        return agendamentos;
    }

    public void excluirAgendamento(Scanner scanner) {
        
        // Lista os agendamentos disponíveis
        List<Agendamento> agendamentos = listarAgendamentos();
    
        if (agendamentos.isEmpty()) {
            System.out.println("Não há agendamentos para excluir.");
            return;
        }
    
        // Solicita ao usuário que escolha um ID para excluir
        System.out.println("");
        System.out.print("Digite o ID do agendamento que deseja excluir: ");
        long agendamentoId = Long.parseLong(scanner.nextLine());
    
        // Verifica se o ID fornecido está na lista de agendamentos
        boolean agendamentoEncontrado = agendamentos.stream().anyMatch(agendamento -> agendamento.getId() == agendamentoId);
    
        if (agendamentoEncontrado) {
            // Busca o usuário no banco de dados pelo ID e o exclui
            Agendamento agendamento = agendamentoRepository.findById(agendamentoId)
                    .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + agendamentoId));
    
            agendamentoRepository.delete(agendamento);
            System.out.println("");
            System.out.println("Agendamento excluído com sucesso!");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("ID de agendamento inválido. Nenhum agendamento foi excluído.");
        }
    }
}
