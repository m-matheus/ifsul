package br.ifsul.tads.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.tads.domain.Funcionario;
import br.ifsul.tads.dto.FuncionarioDTO;
import br.ifsul.tads.repository.FuncionarioRepository;


@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository fr;
	private ModelMapper mapper = new ModelMapper();

	public FuncionarioDTO criar(FuncionarioDTO novoFuncionario) {

		Funcionario f = mapper.map(novoFuncionario, Funcionario.class);

		f = fr.save(f);

		novoFuncionario = mapper.map(f, FuncionarioDTO.class);

		return novoFuncionario;
	}

	public FuncionarioDTO getFuncionario(Long id) {

		Optional<Funcionario> funcionario = fr.findById(id);

		if (funcionario.isPresent())
			return mapper.map(funcionario.get(), FuncionarioDTO.class);

		return null;
	}

	public List<FuncionarioDTO> getTodos() {

		List<Funcionario> funcionario = fr.findAll();

		return funcionario.stream().map(p -> mapper.map(p, FuncionarioDTO.class)).toList();
	}

}
