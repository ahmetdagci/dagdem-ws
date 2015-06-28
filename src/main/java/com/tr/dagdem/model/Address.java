package com.tr.dagdem.model;

public class Address {
	
	private String addressId;
	private String address;
	
	public Address(){
		
	}
	
	public Address(String addressId,String address)
	{
		this.addressId = addressId;
		this.address = address;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
