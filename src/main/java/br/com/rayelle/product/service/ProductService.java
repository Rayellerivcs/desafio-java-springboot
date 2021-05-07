package br.com.rayelle.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rayelle.product.entity.Product;
import br.com.rayelle.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findByName(String name) {
		Optional<Product> obj = repository.findByName(name);
		return obj.get();
	}
}
