package br.ifsul.tads.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.tads.controller.domain.IProdutoDTO;
import br.ifsul.tads.controller.domain.ProdutoDTO;

@RestController
@RequestMapping("api/produtos")
public class ProdutosServiceController {

	@GetMapping("{id}")
	public ResponseEntity<IProdutoDTO> getPedido(@PathVariable Long id) {

		ProdutoDTO foo = new ProdutoDTO();
		foo.setId(id);
		foo.setNome("Bar");

		return ResponseEntity.ok(foo);
	}

	@PostMapping()
	public ResponseEntity<IProdutoDTO> getPedido(@RequestBody ProdutoDTO foo) {
		return ResponseEntity.ok(foo);
	}
}
