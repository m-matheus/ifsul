package br.ifsul.tads.controller.domain;

import lombok.Data;

@Data
public class ProdutoDTO implements IProdutoDTO {

	private Long id;
	private String nome;

}
