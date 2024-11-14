package br.ifsul.tads.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.tads.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	// exemplo com paginacao

	Page<Produto> findByNomeContaining(String string, PageRequest of);

}
