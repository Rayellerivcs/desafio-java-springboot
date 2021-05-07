package br.com.rayelle.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rayelle.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	Optional<Product> findByName(String name);

}
