package br.ifsul.tads.domain;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDTO {
	@NotEmpty(message = "The employeeId is required.")
	@Length(min = 4, max = 4, message = "The employeeId must have length 4")
	private String employeeId;
	@NotEmpty(message = "The employeeName is required.")
	private String employeeName;

	@Valid
	@NotNull(message = "The performance metrics must be reported")
	private PerformanceMetricsDTO performanceMetrics;
}