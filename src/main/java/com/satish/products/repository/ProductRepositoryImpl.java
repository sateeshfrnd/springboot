package com.satish.products.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.satish.products.model.Product;

public class ProductRepositoryImpl {
	
	@Autowired
	private ProductRepository productRepository;	

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> findProductById(Long productId) {
		return productRepository.findById(productId);
	}
	
	public void deleteProduct(Product product) {
		productRepository.delete(product);		
	}
}
