package br.ifsul.tads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ifsul.tads.domain.Diaria;

public interface DiariaRepository extends JpaRepository<Diaria, Long> {
    @Query("SELECT SUM(d.valor) FROM Diaria d WHERE d.poder = :poder")
    Double sumValorByPoder(@Param("poder") String poder);
}
