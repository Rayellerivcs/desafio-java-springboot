package br.com.rayelle.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rayelle.product.dto.ProductDTO;
import br.com.rayelle.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	ProductDTO save(ProductDTO obj);
	
}