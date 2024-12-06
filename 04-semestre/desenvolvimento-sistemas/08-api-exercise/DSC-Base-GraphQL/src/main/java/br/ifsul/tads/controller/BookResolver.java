package br.ifsul.tads.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifsul.tads.model.Book;
import br.ifsul.tads.repositories.BookRepository;

@Controller
public class BookResolver {

	@Autowired
	private BookRepository bookRepository;	

	@QueryMapping
	public Optional<Book> book(@Argument Long id) {
		return bookRepository.findById(id);
	}
	
	@QueryMapping
	public Collection<Book> books() {
		return bookRepository.findAll();
	}

	@QueryMapping
	public Collection<Book> booksByGenre(@Argument String genre) {
		return bookRepository.findByGenre(genre);
	}

	@MutationMapping
	public Book createBook(@Argument String title, @Argument String genre) {
		Book newBook = new Book();
		newBook.setTitle(title);
		newBook.setGenre(genre);
		bookRepository.save(newBook);
		return newBook;
	}

	@MutationMapping
	public Book updateBook(@Argument Long id, @Argument String title, @Argument String genre) {
		Book book = bookRepository.findById(id).orElse(null);
		if (book != null) {
			book.setTitle(title);
			book.setGenre(genre);
			bookRepository.save(book);
		}
		return book;
	}

	@MutationMapping
	public boolean deleteBook(@Argument Long id) {
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
		}
		return true;
	}
}