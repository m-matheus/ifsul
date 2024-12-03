package br.ifsul.tads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer 
public class Cloud_Server {

	public static void main(String[] args) {
		SpringApplication.run(Cloud_Server.class, args);
	}

}
