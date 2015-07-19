package com.tr.dagdem.service.customer;

import java.util.List;

import com.tr.dagdem.model.customer.MusteriTanimTable;
import com.tr.dagdem.wsmodel.Customer;

public interface CustomerService {

	public MusteriTanimTable musteriSorgula(long musteriNo);
	
	public void musteriKaydet(MusteriTanimTable musteri);
	
	public List<MusteriTanimTable> musterileriGetir();
	
	public List<Customer> getCustomers();

	public void createCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
		
}
