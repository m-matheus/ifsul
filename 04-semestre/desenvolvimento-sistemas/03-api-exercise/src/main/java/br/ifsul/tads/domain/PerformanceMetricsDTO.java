package br.ifsul.tads.domain;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PerformanceMetricsDTO {

	@NotNull(message = "Each performance metric must be reported")
	@Range(min = 0, max = 100, message = "Each performance metric must have a value between 0 and 100")
	private Integer qualityOfWork, communication, teamwork, initiative;
}
