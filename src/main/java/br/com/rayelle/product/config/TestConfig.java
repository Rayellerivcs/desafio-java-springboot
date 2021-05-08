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
		Product p5 = new Product(null, "The Legend Of Zeld", "The Legend Of Zelda: Breath Of The Wild - Nintendo Switch", 479.9);
		Product p6 = new Product(null, "RESTful Web Services, Java, Spring Boot, Spring MVC and JPA", "Implement API calls: Sign-up, sign-in, email verification, password reset, update, delete. Deploy to Amazon AWS Cloud.", 219.90);
		Product p7 = new Product(null, "Alexa", "Novo Echo Dot (4ª Geração): Smart Speaker com Alexa - Cor Preta", 284.05);
		Product p8 = new Product(null, "Monitor", "Monitor LG Gamer UltraWide 25\" IPS Full HD", 899.99);
		Product p9 = new Product(null, "Suporte para Monitor", "Suporte Articulado de Mesa com Pistão a Gás", 159.89);
		Product p10 = new Product(null, "Echo Studio", "Smart Speaker com áudio de alta fidelidade e Alexa", 1424.05);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
		
	}

}
