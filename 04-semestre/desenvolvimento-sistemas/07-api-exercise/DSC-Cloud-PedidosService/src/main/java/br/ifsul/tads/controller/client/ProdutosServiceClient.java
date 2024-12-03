package br.ifsul.tads.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.ifsul.tads.domain.ProdutoDTO;

@FeignClient(name = "produtos-service")
public interface ProdutosServiceClient {

	@GetMapping("/api/produtos/{id}")
	ProdutoDTO getProduto(@PathVariable Long id);

}