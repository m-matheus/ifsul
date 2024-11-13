package br.ifsul.tads.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.ifsul.tads.domain.EmployeeDTO;

@Service
public class EmployeeService {

	public Map<String, Object> calcular(EmployeeDTO emp) {

		String evaluation = "Não Atende";
		float average = 0;

		average += emp.getPerformanceMetrics().getCommunication();
		average += emp.getPerformanceMetrics().getInitiative();
		average += emp.getPerformanceMetrics().getQualityOfWork();
		average += emp.getPerformanceMetrics().getTeamwork();
		average = average / 4;

		if (average >= 85)
			evaluation = "Excede";
		else if (average >= 70 && average < 85)
			evaluation = "Atende";

		Map<String, Object> response = new HashMap<>();

		response.put("employeeId", emp.getEmployeeId());
		response.put("employeeName", emp.getEmployeeName());
		response.put("averageScore", average);
		response.put("evaluation", evaluation);

		return response;
	}

}
