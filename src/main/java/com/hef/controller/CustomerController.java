package com.hef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hef.entity.Customer;
import com.hef.service.CustomerService;

@RestController
@RequestMapping("/rest/customer")
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;		
	}

	@GetMapping("/list")
	public List<Customer> getCustomers(){
		List<Customer> customers =  customerService.findAll();
		return customers;
	}

	@PostMapping("/post")
	public Customer postCustomer(@RequestBody Customer customer){
		return customerService.save(customer);
	}
	
	
}
