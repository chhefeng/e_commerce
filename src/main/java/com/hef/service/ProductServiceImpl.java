package com.hef.service;

import java.util.List;

import com.hef.dao.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hef.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productRepository.getOne(id);
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public Product updateProduct(Product product, Long id) throws NotFoundException {
		Product prod = productRepository.getOne(id);
		if (prod == null) {
			throw new NotFoundException("该博客不存在");
		}
		BeanUtils.copyProperties(product, prod);
		return productRepository.save(prod);
	}


	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

}
