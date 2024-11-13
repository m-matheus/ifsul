package br.ifsul.tads.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SalesDTO {

	@NotEmpty
	private String productId;
	@NotEmpty
	@Size(min = 2, message = "Sales data must have at least two records")
	private Integer[] salesData;

}
