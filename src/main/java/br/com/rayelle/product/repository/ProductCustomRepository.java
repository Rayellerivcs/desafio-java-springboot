package br.com.rayelle.product.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.rayelle.product.entity.Product;

@Repository
public class ProductCustomRepository {

	private final EntityManager em;
	
	public ProductCustomRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<Product> find(String q, Double min_price, Double max_price) {
		
		String query = "select P from Product P ";
		String condicao = "where";
		
		if (q != null) {
			query += condicao + " (UPPER(P.name) LIKE UPPER((CONCAT('%',:q,'%'))) OR UPPER(P.description) LIKE UPPER((CONCAT('%',:q,'%'))))";
			condicao = " and ";
		}
		
		if (min_price != null) {
			query += condicao + " P.price >= :min_price";
			condicao = " and ";
		}
		
		if (max_price != null) {
			query += condicao + " P.price <= :max_price";
		}
		
		TypedQuery<Product> emQuery= em.createQuery(query, Product.class);		
		
		if (q != null) {
			emQuery.setParameter("q", q);
		}
		
		if (min_price != null) {
			emQuery.setParameter("min_price", min_price);
		}
		
		if (max_price != null) {
			emQuery.setParameter("max_price", max_price);
		}
		
		return emQuery.getResultList();
	}
}

