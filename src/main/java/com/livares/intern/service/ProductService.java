package com.livares.intern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livares.intern.Model.Products;
import com.livares.intern.Repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Method to create a new product
    public Products createProduct(Products product) {
        return productRepository.save(product);
    }

    // Method to retrieve a product by ID
    public Products getProductById(Long id) {
        Optional<Products> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    // Method to retrieve all products
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to update a product
    public Products updateProduct(Long id, Products product) {
        Optional<Products> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Products existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    // Method to delete a product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
