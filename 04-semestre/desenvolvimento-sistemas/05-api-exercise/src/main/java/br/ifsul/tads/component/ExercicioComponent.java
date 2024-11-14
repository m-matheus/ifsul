package br.ifsul.tads.component;

import static java.lang.System.out;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import br.ifsul.tads.domain.Produto;
import br.ifsul.tads.repository.ProdutoRepository;
import jakarta.annotation.PostConstruct;

@Component
public class ExercicioComponent {

	@Autowired
	private ProdutoRepository pr;

	@PostConstruct
	private void run() {

		if (pr.count() == 0) {
			Produto novoProduto = new Produto();
			novoProduto.setDescricao("Café");
			novoProduto.setNome("Café orgânico IFSul");
			novoProduto.setPreco(new BigDecimal(22.9));
			novoProduto.setQuantidadeEmEstoque(100);

			pr.save(novoProduto);
		}

		/*
		 * Utilizando List
		 */
		List<Produto> produtosSalvos = pr.findAll();

		produtosSalvos.forEach(p -> out.println(p));

		/*
		 * Utilizando paginação + objeto Page + query method
		 */
		final int pageNumber = 1;
		final int pageSize = 10;

		Page<Produto> page = pr.findByNomeContaining("x", PageRequest.of(pageNumber, pageSize));

		out.println("Page number:         " + page.getNumber());
		out.println("Page n. of elements: " + page.getNumberOfElements());
		out.println("Page content:        " + page.getContent());
	}
}
