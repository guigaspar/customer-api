package com.guigaspar.customerapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.guigaspar.customerapi.domain.Customer;
import com.guigaspar.customerapi.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

//http://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate

@Slf4j
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		HttpStatus status;
		List<Customer> allCustomers = new ArrayList<Customer>();
		try{
			status = HttpStatus.OK;
			allCustomers = customerService.findAll();
		}catch (Exception e) {
			log.error("Fail to get all customers");
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<List<Customer>>(allCustomers, status);
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> findCustomer(@PathVariable long id){
		
		HttpStatus status;
		Customer customerFound = new Customer();
		try{
			status = HttpStatus.OK;
			customerFound = customerService.findById(id);
		}catch (Exception e) {
			log.error("Fail to get Customer");
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<Customer>(customerFound,status);
		
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		HttpStatus status;
		Customer customerCreated = new Customer();
		try{
			status = HttpStatus.CREATED;
			customerCreated = customerService.saveCustomer(customer);
		}catch (Exception e) {
			log.error("Fail to get Customer");
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<Customer>(customerCreated,status);
	}
	
}