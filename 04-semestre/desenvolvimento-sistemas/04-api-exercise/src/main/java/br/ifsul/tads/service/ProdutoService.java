package br.ifsul.tads.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.ifsul.tads.domain.Produto;
import br.ifsul.tads.dtos.ProdutoDTO;
import br.ifsul.tads.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository pr;
	private ModelMapper mapper = new ModelMapper();

	public ProdutoDTO criar(ProdutoDTO novoProduto) {

		Produto p = mapper.map(novoProduto, Produto.class);

		p = pr.save(p);

		novoProduto = mapper.map(p, ProdutoDTO.class);

		return novoProduto;
	}

	public ProdutoDTO getProduto(Long id) {

		Optional<Produto> produto = pr.findById(id);

		if (produto.isPresent())
			return mapper.map(produto.get(), ProdutoDTO.class);

		return null;
	}

	public List<ProdutoDTO> getTodos(BigDecimal precoMin, BigDecimal precoMax, int page, int size) {

		List<Produto> produtos = pr.findByPrecoBetween(precoMin, precoMax, PageRequest.of(page, size));

		return produtos.stream().map(p -> mapper.map(p, ProdutoDTO.class)).toList();
	}

}
