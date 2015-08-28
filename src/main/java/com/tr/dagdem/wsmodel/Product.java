package com.tr.dagdem.wsmodel;

import java.io.Serializable;

import com.tr.dagdem.model.enums.ProductType;

@SuppressWarnings("serial")
public class Product implements Serializable{
	
	private String id;
	private String productName;
	private double price;
	private int quantity;
	private ProductType productType;
	
	public Product(){
		
	}
	
	public Product(String id,String productName,double price,int quantity)
	{
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product(String id,String productName,ProductType productType,double price,int quantity)
	{
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productType = productType;
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
	
	public ProductType getProductType() {
		return productType;
	}
	
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

}
