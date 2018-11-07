package com.guigaspar.customerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guigaspar.customerapi.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}