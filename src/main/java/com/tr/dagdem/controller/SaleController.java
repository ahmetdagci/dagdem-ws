package com.tr.dagdem.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tr.dagdem.model.enums.ProductType;
import com.tr.dagdem.model.sale.MusteriSatisRaporu;
import com.tr.dagdem.service.sale.SaleService;
import com.tr.dagdem.service.sale.report.SaleReportService;
import com.tr.dagdem.wsmodel.Product;
import com.tr.dagdem.wsmodel.Sale;

@RestController
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@Autowired
	private SaleReportService saleReportService;
	
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
	
	@RequestMapping(value="/musteriyeSatilanUrunler")
	public List<MusteriSatisRaporu> musteriyeSatilanUrunler(@RequestParam("customerId") String customerId)
	{
		List<MusteriSatisRaporu> musteriyeYapilanSatislar = saleReportService.musteriyeYapilanTumSatislariGetir(new Long(customerId));
		for(MusteriSatisRaporu musteriSatisRaporu:musteriyeYapilanSatislar)
		{
			System.out.println(musteriSatisRaporu.getMusteriAdi()+"-"+musteriSatisRaporu.getUrunAdi()+"-"+musteriSatisRaporu.getAdet());
		}
		return musteriyeYapilanSatislar;
	}
	
	
	public static void main(String args[])
	{
		createProduct();
        
	}
	
	private static void createProduct()
	{
		RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        MusteriSatisRaporu[] postForEntity = restTemplate.getForObject("http://localhost:3131/dagdem-ws/musteriyeSatilanUrunler?customerId=1",MusteriSatisRaporu[].class);
        
        
	}

}
