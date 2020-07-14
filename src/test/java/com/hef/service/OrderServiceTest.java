package com.hef.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hef.entity.CustomerOrder;
import com.hef.entity.OrderLine;
import com.hef.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class OrderServiceTest {

    private OrderService orderService;
    private CustomerService customerService;
    private ProductService productService;

    @Autowired
    public OrderServiceTest(OrderService orderService,
                            CustomerService customerService,
                            ProductService productService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @Test
    @Transactional
    public void save() throws JsonProcessingException {
        CustomerOrder order = new CustomerOrder();
        order.setCustomer(customerService.findOne(1L));
        order.setCreatDate(new Date());

        Product product1 = productService.findById(1L);

        OrderLine orderLine1 = new OrderLine();
        orderLine1.setAmount(2);
        orderLine1.setProduct(product1);
        orderLine1.setPurchasePrice(orderLine1.computingPurchasePrice());

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);

        order.setOrderLines(orderLines);

        CustomerOrder customerOrder = orderService.save(order);

        ObjectMapper mapper = new ObjectMapper();
        String jsonCustomerOrder = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(customerOrder);
        System.out.println(jsonCustomerOrder);

    }

}
