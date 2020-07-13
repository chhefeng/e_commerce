package com.hef.service.impl;

import java.util.List;

import com.hef.dao.CustomerRepository;
import com.hef.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hef.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findOne(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public void deleteOne(Long id) {
		customerRepository.deleteById(id);

	}

	@Transactional
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

}
