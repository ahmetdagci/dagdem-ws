package com.tr.dagdem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tr.dagdem.service.sale.SaleService;
import com.tr.dagdem.wsmodel.Product;
import com.tr.dagdem.wsmodel.Sale;

@RestController
public class SaleController {

	@Autowired
	private SaleService saleService;

	@RequestMapping(value="/sale",method = RequestMethod.POST)
	public int sellProducts(@RequestBody Sale sale)
	{
		int returnValue = 0;
		try 
		{
			System.out.println("sale method() - customer id:"+sale.getCustomerId());
			saleService.satisiGerceklestir(sale);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			returnValue = -1;
		}
		return returnValue;
	}
	
	
	public static void main(String args[])
	{
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Sale sale = new Sale();
        List<Product> productList = new ArrayList<Product>();
        sale.setCustomerId("3");
        sale.setUserId("123");
        Product p = new Product();
        p.setId("4");
        p.setQuantity(2);
        p.setPrice(200);
        productList.add(p);
        sale.setProductList(productList);
        ResponseEntity<Integer> postForEntity = restTemplate.postForEntity("http://localhost:3131/dagdem-ws/sale",sale,Integer.class);
        System.out.println("postForEntity.getBody()"+postForEntity.getBody());
        
	}

}
