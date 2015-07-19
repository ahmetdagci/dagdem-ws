package com.tr.dagdem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.dagdem.service.sale.SaleService;
import com.tr.dagdem.wsmodel.Sale;

@RestController
public class SaleController {

	@Autowired
	private SaleService saleService;

	@RequestMapping("/sale")
	public int sellProducts(@RequestParam(value = "sale") Sale sale)
	{
		int returnValue = 0;
		try 
		{
			saleService.satisiGerceklestir(sale);
		} 
		catch (Exception e) 
		{
			returnValue = -1;
		}
		return returnValue;
	}

}
