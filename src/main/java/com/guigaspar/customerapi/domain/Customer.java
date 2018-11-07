package com.guigaspar.customerapi.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.guigaspar.customerapi.event.CustomerEventListener;

import lombok.Data;

@Data
@Entity(name = "customers")
@EntityListeners(CustomerEventListener.class)
public class Customer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String email;
	private String origin;
	
}
