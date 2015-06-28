package com.tr.dagdem.model;

public class Customer {
	
	private String customerId;
	private String name;
	private String lastName;
	private Address address;
	
	public Customer() {
	}
	
	public Customer(String customerId,String name,String lastName) 
	{
		this.customerId = customerId;
		this.name = name;
		this.lastName = lastName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
