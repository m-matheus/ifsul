package br.ifsul.tads.domain;

import lombok.Data;

@Data
public class PedidoDTO implements IPedidoDTO {

	private Long id;
	private String nome;

}
