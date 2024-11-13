package br.ifsul.tads.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ifsul.tads.domain.Product;
import br.ifsul.tads.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository pr;

    @PostMapping
    public Object createProduct(@RequestBody Product product) {
        if (product.getName() != null && product.getDescription() != null && product.getPrice() != null && product.getStock() != null) {
            pr.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public Object getProduct(@PathVariable Long id) {
        Optional<Product> productOptional = pr.findById(id);
        if (productOptional.isPresent()) {
           return productOptional.get();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public Object updateProduct(@PathVariable Long id, @RequestBody Product product) {
        
        Optional<Product> productOptional = pr.findById(id);
        if (productOptional.isPresent()) {
            Product newProduct = productOptional.get();
            newProduct.setName(product.getName());
            newProduct.setDescription(product.getDescription());
            newProduct.setPrice(product.getPrice());
            newProduct.setStock(product.getStock());
            return pr.save(newProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = pr.findById(id);
        if (productOptional.isPresent()) {
            pr.delete(productOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
