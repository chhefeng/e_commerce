package com.hef.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hef.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    private ProductService productService;

    @Autowired
    public ProductServiceTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void findAllTest() throws JsonProcessingException {
        List<Product> products = productService.findAll();

        ObjectMapper mapper = new ObjectMapper();

        String jsonProduct = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(products);
        System.out.println(jsonProduct);
    }

    @Test
    @Transactional
    public void findByIdTest() throws JsonProcessingException {
        Product product = productService.findById(3L);

        ObjectMapper mapper = new ObjectMapper();
        String jsonProduct = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(product);
        System.out.println(jsonProduct);
    }

    @Test
    public void saveTest() throws JsonProcessingException {
        Product product = new Product();



        Product product1 = productService.save(product);
    }
}
