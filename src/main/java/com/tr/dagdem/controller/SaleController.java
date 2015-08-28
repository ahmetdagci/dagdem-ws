package com.tr.dagdem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tr.dagdem.service.sale.SaleService;
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

}
