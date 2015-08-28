package com.tr.dagdem.controller;

import java.nio.charset.Charset;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.tr.dagdem.model.enums.ProductType;
import com.tr.dagdem.wsmodel.Product;

public class ProductControllerTest 
{
	public static void main(String args[])
	{
		getProducts();
        
	}
	
	private static void getProducts()
	{
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        ResponseEntity<Object[]> postForEntity = restTemplate.postForEntity("http://localhost:3131/dagdem-ws/products",ProductType.CAY,Object[].class);
        System.out.println("postForEntity.getBody()"+postForEntity.getBody());
	}
	
	private static void createProduct()
	{
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        Product p = new Product();
        p.setId("4");
        p.setQuantity(2);
        p.setPrice(200);
        p.setProductType(ProductType.CAY);
        p.setProductName("Tiryaki Çay");
        ResponseEntity<Integer> postForEntity = restTemplate.postForEntity("http://localhost:3131/dagdem-ws/createProduct",p,Integer.class);
        System.out.println("postForEntity.getBody()"+postForEntity.getBody());
	}

}
