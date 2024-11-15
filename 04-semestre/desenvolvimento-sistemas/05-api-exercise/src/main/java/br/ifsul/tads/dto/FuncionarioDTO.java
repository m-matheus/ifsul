package br.ifsul.tads.dto;

import org.springframework.hateoas.RepresentationModel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FuncionarioDTO extends RepresentationModel<FuncionarioDTO> {

	private Long id;
	@NotEmpty
	private String nome;
	@NotNull
	private String profissao;
	@NotNull
	private double salario;

}
