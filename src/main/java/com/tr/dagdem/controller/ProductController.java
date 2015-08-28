package com.tr.dagdem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tr.dagdem.model.enums.ProductType;
import com.tr.dagdem.service.product.ProductService;
import com.tr.dagdem.wsmodel.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/products",method = RequestMethod.POST)
    public List<Product> getProducts(@RequestBody ProductType productType) 
    {
		System.out.println("productType"+productType);
		return productService.getProducts(productType);
    }
	
	@RequestMapping(value="/createProduct",method = RequestMethod.POST)
    public int createProduct(@RequestBody Product product) 
    {
		try {
			System.out.println("product"+product.getProductName());
			productService.urunEkle(product);
			return 0;
		} catch (Exception e) {
			return -1;
		}
    }
}
