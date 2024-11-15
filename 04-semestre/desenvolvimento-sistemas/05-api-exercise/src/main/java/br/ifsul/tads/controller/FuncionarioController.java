package br.ifsul.tads.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.tads.dto.FuncionarioDTO;
import br.ifsul.tads.service.FuncionarioService;
import br.ifsul.tads.utils.ValidationUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

	private FuncionarioService fs;

	@GetMapping
	public ResponseEntity<Object> consultarTodos() {
		
		List<FuncionarioDTO> funcionarios = fs.getTodos();
		
		return ResponseEntity.ok(funcionarios);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> consultar(@PathVariable Long id) {

		FuncionarioDTO funcionario = fs.getFuncionario(id);
				
		if(funcionario == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(funcionario);
	}

	@PostMapping
	public ResponseEntity<Object> criar(@Validated @RequestBody FuncionarioDTO novoFuncionario, BindingResult validation) {

		if (validation.hasErrors()) {
			return ResponseEntity.badRequest().body(ValidationUtils.errorsToJson(validation.getFieldErrors()));
		}

		FuncionarioDTO funcionarioCriado = fs.criar(novoFuncionario);

		Link selfLink = linkTo(FuncionarioController.class).slash(funcionarioCriado.getId()).withSelfRel();
		
		funcionarioCriado.add(selfLink);

		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioCriado);
	}

}