package com.satish.products.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satish.products.api.ProductsInterface;
import com.satish.products.exception.ResourceNotFoundException;
import com.satish.products.model.Product;
import com.satish.products.service.ProductService;

/**
 * @author Satish Kumar
 *
 * Controller for the Product
 */
@RestController
@RequestMapping("/api/v1/")
public class ProductController implements ProductsInterface {

	@Autowired
	private ProductService productService;
	
	@Override
	public ResponseEntity<Product> findCustomerById(Long productId) {
		return new ResponseEntity(productService.findProductById(productId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> saveCustomer(Product product) {
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> updateCustomer(Long productId, @RequestBody Product productInfo) {
		Product product = null;
		
		try {
			product = productService.findProductById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found for the id :: " + productId));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		if(product != null) {
			product.setProductName(productInfo.getProductName());
			product.setPrice(productInfo.getPrice());
			product.setCategory(productInfo.getCategory());
		}
		
		final Product updateProductInfo = productService.saveProduct(product);
		return ResponseEntity.ok(updateProductInfo);
	}

	@Override
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "productId") Long productId) {
		Product product = null;
		try {
			product = productService.findProductById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found for the id :: " + productId));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		productService.deleteProduct(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
