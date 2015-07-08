package com.tr.dagdem.wsmodel;

public class SaleProduct extends Product{
	
	private double salePrice;
	
	public SaleProduct(String id,String productName,double price,int quantity,double salePrice) 
	{
		super(id,productName,price,quantity);
		this.salePrice = salePrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	

}
