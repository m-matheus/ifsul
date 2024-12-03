package br.ifsul.tads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  // Habilita o Eureka Client
public class ProdutosServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(ProdutosServiceApp.class, args);
	}

}
