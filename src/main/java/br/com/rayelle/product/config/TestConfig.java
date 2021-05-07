package br.com.rayelle.product.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.rayelle.product.entity.Product;
import br.com.rayelle.product.repository.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product(null, "Glue", "White Glue", 2.9);
		Product p2 = new Product(null, "Pen", "Ballpoint Pen", 4.9);
		
		productRepository.saveAll(Arrays.asList(p1, p2));
		
	}

}
