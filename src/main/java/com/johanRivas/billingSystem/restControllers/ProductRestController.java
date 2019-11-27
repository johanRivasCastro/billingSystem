package com.johanRivas.billingSystem.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.johanRivas.billingSystem.models.entity.Product;
import com.johanRivas.billingSystem.models.service.ProductServiceImpl;

@RestController
public class ProductRestController {

	@Autowired
	private ProductServiceImpl productService;

	@GetMapping("/rest/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/rest/product/{id}")
	public Product getProductById(@PathVariable("id") long id) {
		return productService.getProductById(id);
	}
}
