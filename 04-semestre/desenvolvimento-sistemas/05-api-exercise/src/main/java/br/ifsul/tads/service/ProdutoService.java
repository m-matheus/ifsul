package br.ifsul.tads.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.tads.domain.Produto;
import br.ifsul.tads.dto.ProdutoDTO;
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

	public List<ProdutoDTO> getTodos() {

		List<Produto> produtos = pr.findAll();

		return produtos.stream().map(p -> mapper.map(p, ProdutoDTO.class)).toList();
	}

}
