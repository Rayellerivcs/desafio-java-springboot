package br.com.rayelle.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rayelle.product.entity.Product;
import br.com.rayelle.product.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		
		List<Product> list =  service.findAll();
				
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{name}")
	public ResponseEntity<Product> findByName(@PathVariable String name) {
		Product obj = service.findByName(name);
		return ResponseEntity.ok().body(obj);
	}
}
