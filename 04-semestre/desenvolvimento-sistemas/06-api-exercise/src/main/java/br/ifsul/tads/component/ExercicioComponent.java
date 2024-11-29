package br.ifsul.tads.component;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.tads.repository.DiariaRepository;
import br.ifsul.tads.utils.CSVReader;
import jakarta.annotation.PostConstruct;

@Component
public class ExercicioComponent {

	@Autowired
	private DiariaRepository dr;

	@PostConstruct
	private void run() {

		try {
			CSVReader.read("src/main/resources/Diarias-RS-2024.csv", dr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
