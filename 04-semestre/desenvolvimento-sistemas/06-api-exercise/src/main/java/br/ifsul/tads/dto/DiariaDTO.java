package br.ifsul.tads.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiariaDTO {
    private String exercicio;
    private String mes;
    @NotEmpty
    private String poder;
    private String orgao;
    private Double valor;
}
