package com.guigaspar.customerapi.event;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import com.guigaspar.customerapi.domain.Customer;

public class CustomerEventListener {
	
	@PostPersist
	@PostUpdate
	public void processCustomerCreate(final Customer customer){
		System.out.println("event: " +customer);
	}
	
}