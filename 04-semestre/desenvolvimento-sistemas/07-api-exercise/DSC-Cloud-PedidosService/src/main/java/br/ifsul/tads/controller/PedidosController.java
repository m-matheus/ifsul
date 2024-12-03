package br.ifsul.tads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.tads.controller.client.ProdutosServiceClient;
import br.ifsul.tads.domain.IPedidoDTO;
import br.ifsul.tads.domain.PedidoDTO;
import br.ifsul.tads.domain.ProdutoDTO;

@RestController
@RequestMapping("api/pedidos")
public class PedidosController {

	@Autowired
	private ProdutosServiceClient produtosClient;

	@Autowired
	private Environment environment;

	@GetMapping("{id}")
	public ResponseEntity<IPedidoDTO> getPedido(@PathVariable Long id) {

		System.out.println("PedidoService::GetPedido " + environment.getProperty("local.server.port"));

		PedidoDTO foo = new PedidoDTO();
		foo.setId(id);
		foo.setNome("Bar");

		ProdutoDTO produto = produtosClient.getProduto(1L);

		System.out.println(produto);

		return ResponseEntity.ok(foo);
	}

	@PostMapping()
	public ResponseEntity<IPedidoDTO> getPedido(@RequestBody PedidoDTO foo) {
		return ResponseEntity.ok(foo);
	}
}
