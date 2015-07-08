package com.tr.dagdem.service.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.dao.company.CompanyDAO;
import com.tr.dagdem.dao.product.ProductDAO;
import com.tr.dagdem.model.company.FirmaOdemeTable;
import com.tr.dagdem.model.company.FirmaTanimTable;
import com.tr.dagdem.model.stock.UrunStockRaporu;
import com.tr.dagdem.model.stock.UrunStockTable;
import com.tr.dagdem.service.BaseServisImpl;

@Service
@Qualifier("companyService")
public class CompanyServiceImpl extends BaseServisImpl implements CompanyService{
	
	private CompanyDAO companyDAO;
	
	private ProductDAO productDAO;
	
	public void firmaGuncelle(FirmaTanimTable firma)
	{	
		companyDAO.firmaKaydet(firma);
	}
	
	public void firmaKaydet(String firmaAdi,String firmaAdres,String gsm)
	{	
		FirmaTanimTable firma = new FirmaTanimTable();
		firma.setFirmaAdi(firmaAdi);
		firma.setAdres(firmaAdres);
		firma.setTarih(new Date());
		firma.setGsm(StringUtils.isNotBlank(gsm)?new Long(gsm):0);
		companyDAO.firmaKaydet(firma);
	}
	
	public void firmayaOdemeYap(long firmaKodu,BigDecimal odemeTutari,String odemeYapanKisi){
		FirmaOdemeTable firmaOdemeTable = new FirmaOdemeTable();
		firmaOdemeTable.setFirmaKodu(firmaKodu);
		firmaOdemeTable.setOdemeTarihi(new Date());
		firmaOdemeTable.setOdemeTutari(odemeTutari);
		firmaOdemeTable.setOdemeYapanKisi(odemeYapanKisi);
		companyDAO.saveOrUpdate(firmaOdemeTable);
	}
	
	public List<FirmaTanimTable> firmalar() 
	{
		return companyDAO.firmalar();
	}
	
	public List<UrunStockRaporu> firmadanAlinanUrunler(long firmaKodu){
		List<UrunStockTable> firmadanAlinanTumUrunler = companyDAO.firmadanAlinanTumUrunler(firmaKodu);
		List<UrunStockRaporu> urunStockRaporListesi = Lists.newArrayList();
		for(UrunStockTable urunStockTable:firmadanAlinanTumUrunler){
			UrunStockRaporu urunStockRaporu = new UrunStockRaporu();
			urunStockRaporu.setAdet(urunStockTable.getAdet().longValue());
			urunStockRaporu.setKoliAdet(urunStockTable.getKoliAdeti().longValue());
			urunStockRaporu.setUrunAdi(productDAO.urunAdiGetir(urunStockTable.getUrunKodu()));
			urunStockRaporu.setStockGirisTarihi(urunStockTable.getTarih());
			urunStockRaporu.setBirimFiyat(new BigDecimal(urunStockTable.getBirimFiyati()).setScale(2, RoundingMode.UP));
			urunStockRaporu.setToplamTutar(new BigDecimal(urunStockTable.getAdet()*urunStockTable.getKoliAdeti()*urunStockTable.getBirimFiyati()).setScale(2,RoundingMode.UP));
			urunStockRaporListesi.add(urunStockRaporu);
		}
		return urunStockRaporListesi;
	}
	
	public List<FirmaOdemeTable> firmayaYapilanOdemeler(long firmaKodu){
		return companyDAO.firmayaYapilanOdemeler(firmaKodu);
	}
	
	@Override
	protected GenericDAO getDAO() 
	{
		return companyDAO;
	}
	
	@Resource(name="companyDAO")
	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}
	
	@Resource(name="productDAO")
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
}
