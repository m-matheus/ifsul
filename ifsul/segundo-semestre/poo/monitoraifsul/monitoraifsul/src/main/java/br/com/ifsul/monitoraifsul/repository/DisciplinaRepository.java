package br.com.ifsul.monitoraifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifsul.monitoraifsul.entity.Disciplina;


@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
}
