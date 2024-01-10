package br.com.ifsul.monitoraifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifsul.monitoraifsul.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{}
