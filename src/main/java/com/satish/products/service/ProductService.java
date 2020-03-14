package com.satish.products.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.satish.products.model.Product;
import com.satish.products.repository.ProductRepositoryImpl;

@Service
public class ProductService {
	
	private ProductRepositoryImpl productRepository;

	public ProductService(ProductRepositoryImpl productRepository) {
		this.productRepository = productRepository;
	}

	public Product saveProduct(Product product) {
		return productRepository.saveProduct(product);
	}

	public Optional<Product> findProductById(Long productId) {
		return productRepository.findProductById(productId);
	}

	public void deleteProduct(Product product) {
		productRepository.deleteProduct(product);
	}
}
