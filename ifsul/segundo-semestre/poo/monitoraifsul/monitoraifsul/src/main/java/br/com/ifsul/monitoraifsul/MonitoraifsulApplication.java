package br.com.ifsul.monitoraifsul;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.ifsul.monitoraifsul.entity.Usuario;
import br.com.ifsul.monitoraifsul.service.UsuarioService;

@SpringBootApplication
public class MonitoraifsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoraifsulApplication.class, args);
	
	}


	// Usado para criar o "CommandLineRunner". Usado para definir inicializações personalizadas.	
	@Bean
    public CommandLineRunner demo(UsuarioService usuarioService) {
        return args -> {
        
			// Chama o metodo de cadastro
            Usuario usuario = usuarioService.cadastrar();
            System.out.println("Usuário criado com ID: " + usuario.getId());

        };
	}

}