package br.ifsul.tads.dto;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProdutoDTO extends RepresentationModel<ProdutoDTO> {

	private Long id;
	@NotEmpty
	private String nome;
	private String descricao;
	@NotNull
	private BigDecimal preco;
	@NotNull
	private Integer quantidadeEmEstoque;

}
