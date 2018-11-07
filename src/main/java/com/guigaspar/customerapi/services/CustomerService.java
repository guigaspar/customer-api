package com.guigaspar.customerapi.services;

import java.util.List;

import com.guigaspar.customerapi.domain.Customer;

public interface CustomerService {
	
	Customer saveCustomer(Customer customer);
	Customer findById(Long l);
	List<Customer> findAll();
	Customer delete(Long l);
	
}
