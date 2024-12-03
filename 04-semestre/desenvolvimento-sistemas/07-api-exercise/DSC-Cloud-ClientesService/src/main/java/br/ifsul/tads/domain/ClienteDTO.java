package br.ifsul.tads.domain;

import lombok.Data;

@Data
public class ClienteDTO implements IClienteDTO{
	
	Long id;
	String nome;
	String email;

}
