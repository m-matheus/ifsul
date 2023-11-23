package br.com.ifsul.monitoraifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifsul.monitoraifsul.entity.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {}
