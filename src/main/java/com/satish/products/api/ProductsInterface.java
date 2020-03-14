package com.satish.products.api;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.satish.products.model.Product;

/**
 * @author Satish Kumar
 *
 */
public interface ProductsInterface {
	
	@GetMapping("products/{productId}")
    public ResponseEntity<Product> findCustomerById(@PathVariable(value = "productId") Long productId);
 	
 	@PostMapping("products")
    public ResponseEntity<Product> saveCustomer(@RequestBody Product product);
 	
 	@PutMapping("products/{productId}")
 	public ResponseEntity<Product>updateCustomer(@PathVariable(value = "productId") Long productId,@RequestBody Product product);
 	
 	@DeleteMapping("products/{productId}")
 	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "productId") Long productId);

}
