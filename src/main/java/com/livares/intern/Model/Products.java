package com.livares.intern.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@jakarta.persistence.Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Getter
//@Setter
public class Products {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(Long id, String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    
    
    

}
