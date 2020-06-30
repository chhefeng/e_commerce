package com.hef.service;

import java.util.List;
import com.hef.entity.Product;
import javassist.NotFoundException;


public interface ProductService {
	
	public List<Product> findAll();
	
	public Product findById(Long id);
	
	public Product save(Product product);

	Product updateProduct(Product product, Long id) throws NotFoundException;

	public void deleteById(Long id);



}
