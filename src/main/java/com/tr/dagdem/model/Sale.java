package com.tr.dagdem.model;

import java.util.List;

public class Sale {
	
	private String userId;
	private String customerId;
	private List<Product> productList;
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
