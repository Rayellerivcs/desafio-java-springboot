package br.com.rayelle.product.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rayelle.product.entity.Product;
import br.com.rayelle.product.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {

		List<Product> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable String id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
//		return ResponseEntity.noContent().build();
		return ResponseEntity.ok().build();
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product obj) {
		obj = service.update(id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

//	@GetMapping(value = "/search")
//	public ResponseEntity<List<Product>> search(@RequestParam (required = false) String q, 
//													  @RequestParam (required = false) Double min_price,
//													  @RequestParam (required = false) Double max_price) {
//		
//		return ResponseEntity.ok().body(service.search(q, min_price, max_price));
//	}
	@GetMapping(value = "/search")
	public ResponseEntity<List<Product>> findProductByCustom(@RequestParam (required = false) String q, 
													  @RequestParam (required = false) Double min_price,
													  @RequestParam (required = false) Double max_price) {
		
		return ResponseEntity.ok().body(service.findProductByCustom(q, min_price, max_price));
	}
	
}
