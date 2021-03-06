package com.tr.dagdem.wsmodel;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Customer implements Serializable{
	
	private String customerId;
	private String customerNo;
	private String name;
	private String lastName;
	private String gsmNo;
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
	
	public String getCustomerNo()
	{
		return customerNo;
	}
	
	public void setCustomerNo(String customerNo)
	{
		this.customerNo = customerNo;
	}
	
	public String getGsmNo()
	{
		return gsmNo;
	}
	
	public void setGsmNo(String gsmNo)
	{
		this.gsmNo = gsmNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
