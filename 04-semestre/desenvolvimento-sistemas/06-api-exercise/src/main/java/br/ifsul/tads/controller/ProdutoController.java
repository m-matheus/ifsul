package br.ifsul.tads.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.tads.dto.ProdutoDTO;
import br.ifsul.tads.service.ProdutoService;
import br.ifsul.tads.utils.ValidationUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	private ProdutoService ps;

	@GetMapping
	public ResponseEntity<Object> consultarTodos() {
		
		List<ProdutoDTO> produtos = ps.getTodos();
		
		return ResponseEntity.ok(produtos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> consultar(@PathVariable Long id) {

		ProdutoDTO produto = ps.getProduto(id);
				
		if(produto == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(produto);
	}

	@PostMapping
	public ResponseEntity<Object> criar(@Validated @RequestBody ProdutoDTO novoProduto, BindingResult validation) {

		if (validation.hasErrors()) {
			return ResponseEntity.badRequest().body(ValidationUtils.errorsToJson(validation.getFieldErrors()));
		}

		ProdutoDTO produtoCriado = ps.criar(novoProduto);

		Link selfLink = linkTo(ProdutoController.class).slash(produtoCriado.getId()).withSelfRel();
		
		produtoCriado.add(selfLink);

		return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
	}

}