package br.ifsul.tads.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifsul.tads.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Collection<Book> findByGenre(String genre);

}
