package br.ifsul.tads.repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.tads.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	List<Produto> findByPrecoBetween(BigDecimal min, BigDecimal max, Pageable page);
	

}
