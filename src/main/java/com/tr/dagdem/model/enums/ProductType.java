package com.tr.dagdem.model.enums;

public enum ProductType {
	
	CAY(1),
	ORALET(2),
	DIGER(3);
	
	private int productType;
	
	private ProductType(int productType)
	{
		this.productType = productType;
	}
	
	public int getProductType() {
		return productType;
	}
	
}
