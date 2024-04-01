package com.livares.intern.controller;

import java.util.List;

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
@RequestMapping("/api/products")

public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	 // Endpoint to create a new product
	
	@PostMapping
	
	public ResponseEntity<Products>createProduct(@RequestBody Products products){
		Products createProduct=productService.createProduct(products);
		return new ResponseEntity<>(createProduct,HttpStatus.CREATED);
	}
	
	// Endpoint to retrieve a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Products>getProductById(@PathVariable Long Id){
    	Products products=productService.getProductById(Id);
    	if(products!=null)
    	{
    		return new ResponseEntity<>(products,HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<>(products,HttpStatus.NOT_FOUND);
    	}
    	
    }
    
    //Endpoint to retrieve all product
    @GetMapping
    public ResponseEntity<Products>getAllProduct(@RequestBody Products products){
    	List<Products> product =productService.getAllProducts();
    	return new ResponseEntity<>(products,HttpStatus.OK);
    			
    }
    
    //Update the product
    @PutMapping
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products product) {
        Products updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    		
	//delete the product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteProduct(@PathVariable Long Id){
    	productService.deleteProduct(Id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
