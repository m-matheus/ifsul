package br.ifsul.tads.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifsul.tads.model.User_;
import br.ifsul.tads.repositories.UserRepository;

@Controller
public class UserResolver {

	@Autowired
	private UserRepository userRepository;

	@QueryMapping
	public User_ user(@Argument Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@QueryMapping
	public Collection<User_> users() {
		return userRepository.findAll();
	}

	@MutationMapping
	public User_ createUser(@Argument String name, @Argument String email) {
		User_ newUser = new User_();
		newUser.setName(name);
		newUser.setEmail(email);
		userRepository.save(newUser);
		return newUser;
	}
}