package com.guigaspar.customerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guigaspar.customerapi.domain.Customer;
import com.guigaspar.customerapi.services.CustomerService;

//http://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerService.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer findCustomer(@PathVariable long id){
		return customerService.findById(id);
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
}