package com.tr.dagdem.model;

public class Product {
	
	private String id;
	private String productName;
	private double price;
	private int quantity;
	
	public Product(){
		
	}
	
	public Product(String id,String productName,double d,int quantity)
	{
		this.id = id;
		this.productName = productName;
		this.price = d;
		this.quantity = quantity;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
