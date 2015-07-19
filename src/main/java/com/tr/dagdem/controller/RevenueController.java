package com.tr.dagdem.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.dagdem.service.revenue.RevenueService;
import com.tr.dagdem.wsmodel.Customer;
import com.tr.dagdem.wsmodel.CustomerTrafficReport;

@RestController
public class RevenueController {

	@Autowired
	private RevenueService revenueService;
	
	@RequestMapping("/queryCustomerLoan")
	public BigDecimal queryCustomerLoan(@RequestParam(value="customer") Customer customer)
	{
		return revenueService.musteriBorcuSorgula(new Long(customer.getCustomerNo()));
	}
	
	@RequestMapping("/saveRevenue")
	public int saveRevenue(@RequestParam(value="customer") Customer customer,@RequestParam(value="paymentAmount") BigDecimal paymentAmount)
	{
		int returnValue = 0;
		try 
		{
			revenueService.tahsilatKaydet(customer, paymentAmount);
		} 
		catch (Exception e) 
		{
			returnValue = -1;
		}
		return returnValue;
	}
	
	@RequestMapping("/queryIncomeFromCustomer")
	public BigDecimal queryIncomeFromCustomer(@RequestParam(value="customer") Customer customer)
	{
		return revenueService.musteridenYapilanTahsilatTutariSorgula(new Long(customer.getCustomerNo()));
	}
	
	@RequestMapping("/queryIncomeFromAllCustomers")
	public BigDecimal queryIncomeFromAllCustomers()
	{
		return revenueService.tumMusterilereYapilanSatisTutari();
	}
	
	@RequestMapping("/queryCustomerTrafficReport")
	public CustomerTrafficReport getCustomerTrafficReport(@RequestParam(value="customer") Customer customer)
	{
		return revenueService.getCustomerTrafficReport(new Long(customer.getCustomerNo()));
	}
	
	
}
