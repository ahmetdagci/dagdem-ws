package com.tr.dagdem.wsmodel;

import java.math.BigDecimal;

public class CustomerTrafficReport {
	
	private Long customerNo;
	private BigDecimal totalPaymentAmount;
	private BigDecimal totalSaleAmount;
	
	public CustomerTrafficReport(Long customerNo,BigDecimal totalPaymentAmount,BigDecimal totalSaleAmount)
	{
		this.customerNo = customerNo;
		this.totalPaymentAmount = totalPaymentAmount;
		this.totalSaleAmount = totalSaleAmount;
	}
	
	public Long getCustomerNo() 
	{
		return customerNo;
	}
	
	public void setCustomerNo(Long customerNo) {
		this.customerNo = customerNo;
	}
	
	public BigDecimal getTotalPaymentAmount() {
		return totalPaymentAmount;
	}
	
	public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) 
	{
		this.totalPaymentAmount = totalPaymentAmount;
	}
	public BigDecimal getTotalSaleAmount() {
		return totalSaleAmount;
	}
	public void setTotalSaleAmount(BigDecimal totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}
	

}
