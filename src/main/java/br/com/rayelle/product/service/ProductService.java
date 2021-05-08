package br.com.rayelle.product.service;

import java.util.List;

import br.com.rayelle.product.dto.ProductDTO;
import br.com.rayelle.product.entity.Product;

public interface ProductService {

	public List<ProductDTO> findAll();
	
	public ProductDTO findById(String id);
	
	public ProductDTO insert(Product obj);
	
	public void delete(String id);
	
	public ProductDTO update(String id, ProductDTO obj);

	void updateData(Product entity, ProductDTO obj);

	public List<ProductDTO> findProductByCustom(String q, Double min_price, Double max_price);
	
}
