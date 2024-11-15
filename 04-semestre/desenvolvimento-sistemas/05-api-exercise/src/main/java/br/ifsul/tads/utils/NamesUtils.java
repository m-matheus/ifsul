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
		int randomIntValue = r.nextInt(_names.length);
		int randomIntValue2 = r.nextInt(_lastNames.length);

		final String generatedName = String.format("%s %s", _names[randomIntValue], _lastNames[randomIntValue2]);

		return generatedName;
	}

	public static String getRandomProfession() {

		Random r = new Random();
		int randomIntValue = r.nextInt(_professions.length);

		final String profession = _professions[randomIntValue];

		return profession;
	}

	public static double getRandomSalario() {

		Random r = new Random();
		int randomIntValue = r.nextInt(2000, 20000);

		final double salario = randomIntValue;

		return salario;
	}
}