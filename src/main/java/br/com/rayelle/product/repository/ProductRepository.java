package br.com.rayelle.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rayelle.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

//	@Query(value ="SELECT * FROM Product obj " +
//		"WHERE ((:q IS NULL OR UPPER(obj.name) LIKE UPPER('%:q%') ) OR (:q IS NULL OR UPPER(obj.description) LIKE UPPER('%:q%'))) AND  (:min_price IS NULL OR obj.price >= :min_price)  AND  (:max_price IS NULL OR obj.price <=:max_price)", nativeQuery = true)
//	List<Product> search(@Param("q") String q,@Param("min_price") Double min_price,@Param("max_price") Double max_price);

}
