package com.guigaspar.customerapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String email;
	private String origin;
	
}
