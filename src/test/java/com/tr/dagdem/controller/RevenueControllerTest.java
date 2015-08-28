package com.tr.dagdem.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.tr.dagdem.wsmodel.Customer;

public class RevenueControllerTest {

	public static void main(String args[])
	{
		callQueryIncomeFromCustomer();
	}
	
	public static void callQueryIncomeFromCustomer()
	{
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Map<String, String> wsParams = new HashMap<String, String>();
        wsParams.put("customerId", "1");
        BigDecimal forObject = restTemplate.getForObject("http://localhost:3131/dagdem-ws/queryIncomeFromCustomer/{customerId}",  BigDecimal.class,wsParams);
        System.out.println("callQueryIncomeFromCustomer - postForEntity.getBody()"+forObject);
	}
	
	public static void callqueryCustomerLoan()
	{
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Map<String, String> wsParams = new HashMap<String, String>();
        wsParams.put("customerId", "1");
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
		}
	}
}
