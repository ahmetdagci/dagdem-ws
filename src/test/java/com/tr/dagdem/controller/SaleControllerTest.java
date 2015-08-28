package com.tr.dagdem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.tr.dagdem.wsmodel.Product;
import com.tr.dagdem.wsmodel.Sale;

public class SaleControllerTest {
	

	public static void main(String args[])
	{
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Sale sale = new Sale();
        List<Product> productList = new ArrayList<Product>();
        sale.setCustomerId("1");
        sale.setUserId("123");
        Product p = new Product();
        p.setId("1");
        p.setQuantity(2);
        p.setPrice(200);
        productList.add(p);
        sale.setProductList(productList);
        ResponseEntity<Integer> postForEntity = restTemplate.postForEntity("http://localhost:3131/dagdem-ws/sale",sale,Integer.class);
        System.out.println("postForEntity.getBody()"+postForEntity.getBody());
        
	}

}
