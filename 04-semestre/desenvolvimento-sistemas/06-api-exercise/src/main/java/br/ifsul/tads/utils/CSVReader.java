package br.ifsul.tads.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import br.ifsul.tads.domain.Diaria;
import br.ifsul.tads.repository.DiariaRepository;

public final class CSVReader {

	public static void read(String file, DiariaRepository dr) throws IOException {
		Reader in = new FileReader(file);

		int count = 0;

		Iterable<CSVRecord> records = CSVFormat.EXCEL.builder()
				// .setHeader("Exercicio", "Mes", "Poder") // demais colunas na mesma ordem do arquivo fonte
				.setHeader() // header automático
				.setDelimiter(';')
				.build()
				.parse(in);

		for (CSVRecord record : records) {
			count++;
			String exercicio = record.get("Exercicio");
			String mes = record.get("Mes");
			String poder = record.get("Poder");
			String orgao = record.get("Orgao");
			String valor = record.get("Valor");

			Diaria diaria = new Diaria();

			diaria.setExercicio(exercicio);
			diaria.setMes(mes);
			diaria.setPoder(poder);
			diaria.setOrgao(orgao);
			diaria.setValor(Double.parseDouble(valor.replace(",", ".")));
			
			dr.save(diaria);

			if (count == 1000) {
				break;
			}
		}
	}
}
