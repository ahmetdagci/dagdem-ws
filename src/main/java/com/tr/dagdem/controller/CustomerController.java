package com.tr.dagdem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/createCustomer",method = RequestMethod.POST)
	public void createCustomer(@RequestBody Customer customer)
	{
		customerService.createCustomer(customer);
	}
	
	@RequestMapping(value="/updateCustomer",method = RequestMethod.POST)
	public void updateCustomer(@RequestBody Customer customer)
	{
		customerService.updateCustomer(customer);
	}
}
