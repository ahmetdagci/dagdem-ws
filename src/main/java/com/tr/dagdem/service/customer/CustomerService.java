package com.tr.dagdem.service.customer;

import java.util.List;

import com.tr.dagdem.model.customer.MusteriTanimTable;

public interface CustomerService {

	public MusteriTanimTable musteriSorgula(long musteriNo);
	
	public void musteriKaydet(MusteriTanimTable musteri);
	
	public List<MusteriTanimTable> musterileriGetir();
		
}
