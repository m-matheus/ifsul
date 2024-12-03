package br.ifsul.tads.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.ifsul.tads.domain.PedidoDTO;

@FeignClient(name = "pedidos-service")
public interface PedidosServiceClient {

	@GetMapping("/api/pedidos/{id}")
	PedidoDTO getPedido(@PathVariable Long id);

}