package br.ifsul.tads.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descricao;
	@Column(precision = 10, scale = 2)
	private BigDecimal preco;
	private Integer quantidadeEmEstoque;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
}
