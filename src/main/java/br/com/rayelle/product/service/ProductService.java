package br.com.rayelle.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.rayelle.product.entity.Product;
import br.com.rayelle.product.repository.ProductCustomRepository;
import br.com.rayelle.product.repository.ProductRepository;
import br.com.rayelle.product.service.exceptions.BadRequestException;
import br.com.rayelle.product.service.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	private ProductCustomRepository customRepository;
	
	public ProductService (ProductCustomRepository customRepository) {
		this.customRepository = customRepository;
	}
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(String id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Product insert(Product obj) {
		try {
			return repository.save(obj); 
		} catch (Exception e) {
			throw new BadRequestException(e);
		}
	}
	
	public void delete(String id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Product update(String id, Product obj) {
		try {
			Product entity = repository.getOne(id);
			updateData(entity, obj);
		
			return repository.save(entity);
		} catch (Exception e) {
			throw new BadRequestException(e);
		}
	}

	private void updateData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
	}

	public List<Product> findProductByCustom(String q, Double min_price, Double max_price) {

		return customRepository.find(q, min_price, max_price);
	}
	
}
