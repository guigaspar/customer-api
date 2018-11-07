package com.guigaspar.customerapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guigaspar.customerapi.domain.Customer;
import com.guigaspar.customerapi.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{
	
	CustomerRepository customerRepository;
		
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer;
	}

	@Override
	public Customer findById(Long l) {
		Optional<Customer> customer = customerRepository.findById(l);
		
		if(!customer.isPresent())
			return null;
		
		return customer.get();
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customer = customerRepository.findAll();
		return customer;
	}
	
	@Override
	public Customer delete(Long l) {
		customerRepository.deleteById(l);
		return null;
	}
}
