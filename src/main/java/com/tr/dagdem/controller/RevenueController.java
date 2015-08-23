package com.tr.dagdem.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tr.dagdem.service.revenue.RevenueService;
import com.tr.dagdem.wsmodel.Customer;
import com.tr.dagdem.wsmodel.CustomerTrafficReport;

@RestController
public class RevenueController {

	@Autowired
	private RevenueService revenueService;
	
	public static void main(String args[])
	{
		callSaveRevenue();
      
	}
	public static void callqueryCustomerLoan()
	{
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Map<String, String> wsParams = new HashMap<String, String>();
        wsParams.put("customerId", "151");
        BigDecimal forObject = restTemplate.getForObject("http://localhost:3131/dagdem-ws/queryCustomerLoan/{customerId}",  BigDecimal.class,wsParams);
        System.out.println("postForEntity.getBody()"+forObject);
	}
	
	public static void callSaveRevenue()
	{
	     try{
		 BigDecimal paymentAmount = new BigDecimal("100");
		 final String url = "http://localhost:3131/dagdem-ws/saveRevenue?userCode=resul&paymentAmount="+paymentAmount+"";
         RestTemplate restTemplate = new RestTemplate();
         restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
         Customer customer = new Customer();
         customer.setCustomerId("2");
         ResponseEntity<Integer> integerResponseEntity = restTemplate.postForEntity(url, customer, Integer.class);
         System.out.println(integerResponseEntity.getBody());
         }catch (Exception e) 
         {
			e.printStackTrace();
		}
	}
	
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
			e.printStackTrace();
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
	
	@RequestMapping(value="/queryIncomeFromCustomer/{customerId}")
	public BigDecimal queryIncomeFromCustomer(@PathVariable("customerId") String customerId)
	{
		return revenueService.musteridenYapilanTahsilatTutariSorgula(new Long(customerId));
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
