package br.com.ifsul.monitoraifsul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifsul.monitoraifsul.entity.Disciplina;
import br.com.ifsul.monitoraifsul.entity.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    // Retorna um booleano se o estudante é monitor ou não
    List<Estudante> findByMonitor(boolean b);
    // Retorna a disciplina do estudante
    List<Estudante> findByDisciplina(Disciplina disciplina);

}
