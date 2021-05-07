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
		
		Product p1 = new Product(null, "Star Wars: Dark Edition", "Edição épica para uma saga eterna!", 79.0);
		Product p2 = new Product(null, "Câmera HD", "Câmera HD - PlayStation 5", 369.0);
		Product p3 = new Product(null, "Just Dance 2020", "Just Dance 2020 - Edição Padrão - PlayStation 4", 278.9);
		Product p4 = new Product(null, "Console Nintendo Switch", "Console Nintendo Switch - Azul Neon e Vermelho", 2420.99);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
	}

}
