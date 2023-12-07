package br.com.ifsul.monitoraifsul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifsul.monitoraifsul.entity.Agendamento;
import br.com.ifsul.monitoraifsul.entity.Disciplina;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
     List<Agendamento> findByDisciplina(Disciplina disciplina);

}
