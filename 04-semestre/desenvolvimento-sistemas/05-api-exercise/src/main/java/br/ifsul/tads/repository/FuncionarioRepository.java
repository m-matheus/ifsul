package br.ifsul.tads.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.tads.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	Page<Funcionario> findByNomeContaining(String string, PageRequest of);

}
