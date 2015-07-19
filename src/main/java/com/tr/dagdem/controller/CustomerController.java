package com.tr.dagdem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.dagdem.service.customer.CustomerService;
import com.tr.dagdem.wsmodel.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}
	
	@RequestMapping("/createCustomer")
	public void createCustomer(@RequestParam(value="customer") Customer customer)
	{
		customerService.createCustomer(customer);
	}
	
	@RequestMapping("/updateCustomer")
	public void updateCustomer(@RequestParam(value="customer") Customer customer)
	{
		customerService.updateCustomer(customer);
	}

}
