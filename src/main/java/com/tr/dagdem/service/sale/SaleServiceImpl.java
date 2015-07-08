package com.tr.dagdem.service.sale;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.dao.sale.SaleDAO;
import com.tr.dagdem.model.customer.MusteriTanimTable;
import com.tr.dagdem.model.dealer.SaticiTanimTable;
import com.tr.dagdem.model.product.UrunIadeTable;
import com.tr.dagdem.model.sale.MusteriSatisTable;
import com.tr.dagdem.model.sale.SatisIptalModel;
import com.tr.dagdem.model.sale.SatisTable;
import com.tr.dagdem.service.BaseServisImpl;
import com.tr.dagdem.service.util.SatisTakipException;

@Service
@Qualifier("saleService")
public class SaleServiceImpl extends BaseServisImpl implements SaleService{
	
	private SaleCreationHelper saleCreationHelper;
	private SaleDAO saleDAO;
	
	public void satisiGerceklestir(SaticiTanimTable satici,Date satisTarihi) 
	{
		Set<SatisTable> satisTableSeti = saleCreationHelper.musteriSepetindenSatisOlustur(satici,satisTarihi);
		saleDAO.saticiSatisKaydet(satisTableSeti);
	}
	
	public void iadeyiGerceklestir(SaticiTanimTable satici,MusteriTanimTable musteri,Date iadeTarihi)
	{
		if(iadeTarihi==null)
		{
			throw new SatisTakipException("İade tarihi boş olamaz, lütfen iade tarihi giriniz");
		}
		Set<UrunIadeTable> musteriUrunIadeSeti = saleCreationHelper.saticiIadeSepetindenIadeEdilecekUrunleriOlustur(satici,musteri,iadeTarihi);
		saleDAO.musteriUrunIadeKaydet(musteriUrunIadeSeti);
	}
	
	public void satisiGerceklestir(SaticiTanimTable satici,MusteriTanimTable musteri,Date satisTarihi) 
	{	
		if(satisTarihi==null)
		{
			throw new SatisTakipException("Satış tarihi boş olamaz, lütfen satış tarihi giriniz");
		}
		Set<MusteriSatisTable> musteriSatisTableSeti = saleCreationHelper.musteriSepetindenSatisOlustur(satici,musteri,satisTarihi);
		saleDAO.musteriSatisKaydet(musteriSatisTableSeti);
	}
	
	public void satisiIptalEt(long satisId)
	{
		MusteriSatisTable musteriSatis = saleDAO.findById(MusteriSatisTable.class, satisId);
		musteriSatis.setEtkin(false);
		saleDAO.merge(musteriSatis);
	}
	
	public List<SatisIptalModel> silinebilecekUrunleriGetir(Date baslamaTarihi,Date bitisTarihi)
	{
		return saleDAO.silinebilecekUrunleriGetir(baslamaTarihi, bitisTarihi);
	}
	
	@Override
	protected GenericDAO getDAO() {
		return null;
	}
	
	@Resource(name="saleDAO")
	public void setSaleDAO(SaleDAO saleDAO) {
		this.saleDAO = saleDAO;
	}
	
	@Resource(name="saleCreationHelper")
	public void setSaleCreationHelper(SaleCreationHelper saleCreationHelper) {
		this.saleCreationHelper = saleCreationHelper;
	}
}
