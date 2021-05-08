package br.com.rayelle.product.dto;

public class ProductDTO {

	private String id;
	private String name;
	private String description;
	private Double price;
	
	public ProductDTO(String id, String name, String description, Double price) {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductDTO() {
		super();
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
