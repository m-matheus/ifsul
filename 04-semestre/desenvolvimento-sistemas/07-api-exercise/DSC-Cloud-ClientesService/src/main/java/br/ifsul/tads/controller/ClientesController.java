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

import br.ifsul.tads.controller.client.PedidosServiceClient;
import br.ifsul.tads.domain.ClienteDTO;
import br.ifsul.tads.domain.IClienteDTO;
import br.ifsul.tads.domain.IPedidoDTO;
import br.ifsul.tads.domain.PedidoDTO;

@RestController
@RequestMapping("api/clientes")
public class ClientesController {

	@Autowired
	private PedidosServiceClient pedidosClient;

	@Autowired
	private Environment environment;

	@GetMapping("{id}")
	public ResponseEntity<IClienteDTO> getCliente(@PathVariable Long id) {

		System.out.println("ClienteService::GetCliente " + environment.getProperty("local.server.port"));

		ClienteDTO foo = new ClienteDTO();
		foo.setId(id);
		foo.setNome("Zeca Pagodinho");
		foo.setEmail("zecadojogodobicho@gmail.com");

		PedidoDTO pedido = pedidosClient.getPedido(1L);

		System.out.println(pedido);

		return ResponseEntity.ok(foo);
	}

	@PostMapping()
	public ResponseEntity<IPedidoDTO> getPedido(@RequestBody PedidoDTO foo) {
		return ResponseEntity.ok(foo);
	}
}
