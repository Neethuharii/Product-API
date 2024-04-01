package com.livares.intern.controller;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livares.intern.Model.Products;
import com.livares.intern.service.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	 //To create a new product
	
	@PostMapping("/createProduct")
	public String  createProduct(@RequestBody Products products){
		 productService.createProduct(products);
		 return "product added sucessfully";
	}
	
	// To retrieve a product by ID
    @GetMapping("/getProductById/{Id}")
    public Products getProductById(@PathVariable Long Id){
    	return productService.getProductById(Id);
    	
    	
    }
    
    //To retrieve all product
    @GetMapping("/getAllProducts")
    public  List getAllProduct(@RequestBody Products products){
    	return productService.getAllProducts();
    			
    }
    
    //Update the product
    @PutMapping("/update/{Id}")
    public Products updateProduct(@PathVariable Long Id, @RequestBody Products products) {
       return productService.updateProduct(Id, products);
    
    }
    		
	//delete the product
    @DeleteMapping("delete/{Id}")
    public void deleteProduct(@PathVariable Long Id) {
        productService.deleteProduct(Id);
    }
}
