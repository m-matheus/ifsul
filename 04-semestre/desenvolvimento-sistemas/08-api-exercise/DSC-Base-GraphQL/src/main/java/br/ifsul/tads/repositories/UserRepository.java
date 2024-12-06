package br.ifsul.tads.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifsul.tads.model.User_;

@Repository
public interface UserRepository extends JpaRepository<User_, Long> {

}
