package com.tr.dagdem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.dagdem.service.product.ProductService;
import com.tr.dagdem.wsmodel.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
    public List<Product> getProducts(@RequestParam(value="productType") String productType) 
    {
		return productService.getProducts(productType);
    }
    
}
