package com.tr.dagdem.controller;

import java.nio.charset.Charset;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.tr.dagdem.wsmodel.Customer;

public class CustomerControllerTest {
	

	public static void main(String args[])
	{
		createCustomer();
	}

	private static void createCustomer()
	{
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        Customer customer = new Customer();
        customer.setName("Mehmet");
        customer.setLastName("Alkan");
        customer.setGsmNo("5322721143");
        restTemplate.postForEntity("http://localhost:3131/dagdem-ws/createCustomer",customer,Void.class);
	}

}
