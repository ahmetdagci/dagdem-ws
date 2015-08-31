package com.tr.dagdem.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.dagdem.service.revenue.RevenueService;
import com.tr.dagdem.wsmodel.Customer;
import com.tr.dagdem.wsmodel.CustomerTrafficReport;

@RestController
public class RevenueController {

	@Autowired
	private RevenueService revenueService;
	
	@RequestMapping(value="/saveRevenue",method = RequestMethod.POST)
	public int saveRevenue(@RequestBody Customer customer,@RequestParam(value="userCode") String userCode,@RequestParam(value="paymentAmount") BigDecimal paymentAmount)
	{
		int returnValue = 0;
		try 
		{
			revenueService.tahsilatKaydet(customer,userCode,paymentAmount);
		} 
		catch (Exception e) 
		{	
			returnValue = -1;
		}
		return returnValue;
	}
	
	@RequestMapping(value="/queryCustomerLoanAndIncome/{customerId}")
	public CustomerTrafficReport queryCustomerLoanAndIncome(@PathVariable("customerId") String customerId)
	{
		return revenueService.getCustomerTrafficReport(new Long(customerId));
	}
	
	@RequestMapping(value="/queryCustomerLoan/{customerId}")
	public BigDecimal queryCustomerLoan(@PathVariable("customerId") String customerId)
	{
		return revenueService.musteriBorcuSorgula(new Long(customerId));
	}
	
	@RequestMapping(value="/queryRevenueFromCustomer")
	public BigDecimal queryRevenueFromCustomer(@RequestParam("customerId") String customerId)
	{
		return revenueService.musteridenYapilanTahsilatTutariSorgula(new Long(customerId));
	}
	
	@RequestMapping("/queryRevenueFromAllCustomers")
	public BigDecimal queryRevenueFromAllCustomers()
	{
		return revenueService.tumMusterilereYapilanSatisTutari();
	}
	
	@RequestMapping("/queryCustomerTrafficReport")
	public CustomerTrafficReport getCustomerTrafficReport(@RequestParam(value="customer") Customer customer)
	{
		return revenueService.getCustomerTrafficReport(new Long(customer.getCustomerNo()));
	}
	
	
}
