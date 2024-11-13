package br.ifsul.tads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.tads.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
