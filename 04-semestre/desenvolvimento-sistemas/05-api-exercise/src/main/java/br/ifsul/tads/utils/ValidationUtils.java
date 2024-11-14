package br.ifsul.tads.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;

public final class ValidationUtils {

	public static Map<String, Object> errorsToJson(List<FieldError> allErrors) {
		var errorsMap = new HashMap<String, Object>();

		errorsMap.put("errors",
				allErrors.stream().map(v -> v.getField() + ": " + v.getDefaultMessage()).collect(Collectors.toList()));

		return errorsMap;
	}
}
