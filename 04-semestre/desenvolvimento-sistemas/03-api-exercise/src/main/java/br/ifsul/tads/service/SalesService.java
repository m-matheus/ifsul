package br.ifsul.tads.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import br.ifsul.tads.domain.SalesDTO;

@Service
public class SalesService {

	public Object calcular(SalesDTO sales) {

		var map = new HashMap<>();

		float predictedDemand = 0;

		for (int saleValue : sales.getSalesData())
			predictedDemand += saleValue;

		predictedDemand = predictedDemand / sales.getSalesData().length;

		map.put("productId", sales.getProductId());
		map.put("predictedDemand", predictedDemand);

		return map;
	}

}
