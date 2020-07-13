package com.hef.service;

import java.util.List;


import com.hef.entity.Customer;


public interface CustomerService {

	List<Customer> findAll();
	Customer save(Customer customer);
	Customer findOne(Long id);
	void deleteOne(Long id);


}
