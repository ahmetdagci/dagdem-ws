package com.tr.dagdem.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	
	public static void main(String args[])
	{
		createProduct();
        
	}
	
	private static void createProduct()
	{
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        Product p = new Product();
        p.setQuantity(10);
        p.setPrice(100);
        p.setProductType(ProductType.ORALET);
        p.setProductName("Kusburnu");
        ResponseEntity<Integer> postForEntity = restTemplate.postForEntity("http://localhost:3131/dagdem-ws/createProduct",p,Integer.class);
        System.out.println("postForEntity.getBody()"+postForEntity.getBody());
	}

}
