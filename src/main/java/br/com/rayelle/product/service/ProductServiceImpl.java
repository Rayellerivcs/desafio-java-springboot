package br.com.rayelle.product.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.rayelle.product.dto.ProductDTO;
import br.com.rayelle.product.entity.Product;
import br.com.rayelle.product.repository.ProductCustomRepository;
import br.com.rayelle.product.repository.ProductRepository;
import br.com.rayelle.product.service.exceptions.BadRequestException;
import br.com.rayelle.product.service.exceptions.ResourceNotFoundException;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repository;

	private ProductCustomRepository customRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public ProductServiceImpl (ProductCustomRepository customRepository) {
		this.customRepository = customRepository;
	}
	
	public List<ProductDTO> findAll(){
		List<ProductDTO> listDTO = modelMapper.map(repository.findAll(), new TypeToken<List<ProductDTO>>() {}.getType());
		return listDTO;
	}
	
	public ProductDTO findById(String id) {
		Optional<Product> obj = repository.findById(id);
		
		return modelMapper.map(obj.orElseThrow(() -> new ResourceNotFoundException(id)), ProductDTO.class);
	}
	
	public ProductDTO insert(Product obj) {
		try {
			return modelMapper.map(repository.save(obj), ProductDTO.class); 
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
	
	public ProductDTO update(String id, ProductDTO obj) {
		try {
			Product entity = repository.getOne(id);
			updateData(entity, obj);
		
			return modelMapper.map(repository.save(modelMapper.map(entity, Product.class)), ProductDTO.class);
		} catch (Exception e) {
			throw new ResourceNotFoundException(e);
		}
	}

	public void updateData(Product entity, ProductDTO obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
	}

	public List<ProductDTO> findProductByCustom(String q, Double min_price, Double max_price) {

		List<ProductDTO> listDTO = modelMapper.map(customRepository.find(q, min_price, max_price), new TypeToken<List<ProductDTO>>() {}.getType());
		return listDTO;
	}

}
