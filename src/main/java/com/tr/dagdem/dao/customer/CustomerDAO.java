package com.tr.dagdem.dao.customer;

import java.util.List;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.model.customer.MusteriTanimTable;

public interface CustomerDAO extends GenericDAO{
	
	public MusteriTanimTable musteriSorgula(long musteriNo);
	
	public List<MusteriTanimTable> musterileriGetir();
	
}
