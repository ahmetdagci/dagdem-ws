package com.tr.dagdem.dao.company;

import java.util.List;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.model.company.FirmaOdemeTable;
import com.tr.dagdem.model.company.FirmaTanimTable;
import com.tr.dagdem.model.stock.UrunStockTable;


public interface CompanyDAO extends GenericDAO{
	
	public void firmaKaydet(FirmaTanimTable firma);
	
	public List<FirmaTanimTable> firmalar();
	
	public List<UrunStockTable> firmadanAlinanTumUrunler(long firmaKodu);
	
	public List<FirmaOdemeTable> firmayaYapilanOdemeler(long firmaKodu);
}
