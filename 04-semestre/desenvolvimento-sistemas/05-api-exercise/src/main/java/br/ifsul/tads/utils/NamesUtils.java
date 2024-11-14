package br.ifsul.tads.utils;

import java.util.Random;

public final class NamesUtils {

	private static String[] _names = { "Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel", "Helena",
			"Igor", "Juliana", "Lucas", "Mariana", "Nicolas", "Olivia", "Paulo", "Quenia", "Renato", "Sara", "Tiago",
			"Viviane" };

	private static String[] _lastNames = { "Silva", "Santos", "Oliveira", "Souza", "Pereira", "Costa", "Rodrigues",
			"Almeida", "Nascimento", "Lima", "Araujo", "Fernandes", "Barbosa", "Vieira", "Carvalho", "Ribeiro",
			"Martins", "Gomes", "Mendes", "Freitas" };

	private static String[] _professions = { "Engenheiro(a)", "Médico(a)", "Advogado(a)", "Professor(a)",
			"Arquiteto(a)", "Enfermeiro(a)", "Farmacêutico(a)", "Dentista", "Psicólogo(a)", "Veterinário(a)",
			"Jornalista", "Designer", "Programador(a)", "Analista", "Eletricista", "Carpinteiro(a)", "Mecânico(a)",
			"Chefe de Cozinha", "Motorista", "Contador(a)" };

	public static String getRandomName() {

		Random r = new Random();

		/**
		 * TODO Gera uma combinação aleatória de um nome + sobrenome
		 */

		int randomIntValue = r.nextInt(20);

		final String generatedName = String.format("%s %s", _names[0], _lastNames[0]);

		return generatedName;
	}

	public static String getRandomProfession() {

		/**
		 * TODO Implementar a lógica
		 */

		final String profession = _professions[0];

		return "";
	}
}