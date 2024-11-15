package br.ifsul.tads.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import br.ifsul.tads.domain.Funcionario;
import br.ifsul.tads.dto.FuncionarioDTO;
import br.ifsul.tads.repository.FuncionarioRepository;
import br.ifsul.tads.service.FuncionarioService;
import br.ifsul.tads.utils.ValidationUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

	private FuncionarioService fs;
	@Autowired
	private FuncionarioRepository fr;

	@GetMapping("{page}/{size}")
	public ResponseEntity<Object> consultarTodos(
		@PathVariable int page,
		@PathVariable int size
	) {
		
		Page<Funcionario> pageResult = fr.findAll(PageRequest.of(page, size));
		
		return ResponseEntity.ok(pageResult);
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