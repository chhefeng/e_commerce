package com.hef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hef.entity.Product;
import com.hef.service.ProductService;

@RestController
@RequestMapping({"/rest", ""})
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/product/list")
	public List<Product> getProducts() {
		List<Product> products = productService.findAll();
		for (Product prod: products) {
			System.out.println(prod);
		}
		return products;
	}
	
	// get a product
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable Long id) {
		Product product = productService.findById(id);
		System.out.println("object product inside getMapping = " + product);
		return product;
	}

	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product){
		return productService.save(product);
	}

}
