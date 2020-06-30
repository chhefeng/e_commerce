package com.hef.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hef.entity.Customer;
import com.hef.entity.CustomerOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CustomerServiceTest {

    private CustomerService customerService;

    @Autowired
    public CustomerServiceTest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void saveCustomerTest() throws JsonProcessingException {
        List<CustomerOrder> orders = new ArrayList<>();

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Hefeng");
        customer.setLastName("Chen");
        customer.setCustomerOrders(new ArrayList<>());

        Customer customer1 = customerService.save(customer);

        ObjectMapper mapper = new ObjectMapper();
        String jsonCustomer = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(customer1);
        System.out.println(jsonCustomer);
    }



}
