package com.hef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hef.entity.Customer;
import com.hef.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
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

	@GetMapping("/{id}")
	public Customer findOne(@PathVariable Long id){
		Customer customer =  customerService.findOne(id);
		return customer;
	}

	@PostMapping("")
	public Customer save(@RequestBody Customer customer){
		return customerService.save(customer);
	}

	@PutMapping("/{id}")
	public Customer update(@RequestBody Customer customer){
		return customerService.save(customer);
	}

	@DeleteMapping("/{id}")
	public Customer delete(@RequestBody Customer customer){
		return customerService.save(customer);
	}
	
}
