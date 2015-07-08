package com.tr.dagdem.service.company;

import java.math.BigDecimal;
import java.util.List;

import com.tr.dagdem.model.company.FirmaOdemeTable;
import com.tr.dagdem.model.company.FirmaTanimTable;
import com.tr.dagdem.model.stock.UrunStockRaporu;

public interface CompanyService {

	public void firmaGuncelle(FirmaTanimTable firma);
	
	public void firmaKaydet(String firmaAdi,String firmaAdres,String gsm);
	
	public List<FirmaTanimTable> firmalar();
	
	public List<UrunStockRaporu> firmadanAlinanUrunler(long firmaKodu);
	
	public List<FirmaOdemeTable> firmayaYapilanOdemeler(long firmaKodu);
	
	public void firmayaOdemeYap(long firmaKodu,BigDecimal odemeTutari,String odemeYapanKisi);
}
