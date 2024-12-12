package br.ifsul.tads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Controller
public class HomeController {

	@GetMapping(path = { "/", "/jokes/random" })
	public String home(Model model) {

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.chucknorris.io/jokes/random";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		
		String joke = "";
		joke = response.getBody();

		model.addAttribute("piada", joke);

		return "home";
	}
}
