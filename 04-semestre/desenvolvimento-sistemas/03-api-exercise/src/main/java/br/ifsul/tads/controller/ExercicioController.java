package br.ifsul.tads.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.tads.domain.EmployeeDTO;
import br.ifsul.tads.domain.SalesDTO;
import br.ifsul.tads.service.EmployeeService;
import br.ifsul.tads.service.SalesService;
import br.ifsul.tads.service.utils.Utils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ExercicioController {

	private EmployeeService es;
	private SalesService ss;

	@PostMapping("/api/performance/evaluate")
	public ResponseEntity<Object> exercicio1(@Validated @RequestBody EmployeeDTO emp, BindingResult validation) {

		if (validation.hasErrors()) {
			return ResponseEntity.badRequest().body(Utils.errorsToJson(validation.getFieldErrors()));
		}

		Object resposta = es.calcular(emp);

		return ResponseEntity.ok(resposta);
	}

	@PostMapping("/api/demand/predict")
	public ResponseEntity<Object> exercicio2(@Validated @RequestBody SalesDTO sales, BindingResult validation) {

		if (validation.hasErrors()) {
			return ResponseEntity.badRequest().body(Utils.errorsToJson(validation.getFieldErrors()));
		}
		
		Object resposta = ss.calcular(sales);
				
		return ResponseEntity.ok(resposta);
	}
}