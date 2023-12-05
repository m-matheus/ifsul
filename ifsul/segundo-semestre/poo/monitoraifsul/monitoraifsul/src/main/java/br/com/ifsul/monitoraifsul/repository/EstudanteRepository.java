package br.com.ifsul.monitoraifsul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifsul.monitoraifsul.entity.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    List<Estudante> findByMonitor(boolean b);

}
