package com.tr.dagdem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.dagdem.model.Product;
import com.tr.dagdem.model.Sale;

@RestController
public class ProductController {

	@RequestMapping("/products")
    public List<Product> getProducts(@RequestParam(value="productType") String productType) {
     
		List<Product> productList = new ArrayList<Product>();
		Product product1 = new Product("p1","Oralet",2.2,1);
		Product product2 = new Product("p2","Süt Tozu",4,1);
		productList.add(product1);
		productList.add(product2);
		return productList;
    }
	
	
	
	@RequestMapping("/sale")
	public int sellProducts(@RequestParam(value="sale") Sale sale)
	{
		System.out.println(sale.getUserId() + sale.getCustomerId());
		return 0;
	}
    
}
