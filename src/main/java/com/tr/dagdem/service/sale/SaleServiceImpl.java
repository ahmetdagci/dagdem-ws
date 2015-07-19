package com.tr.dagdem.service.sale;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.dao.product.ProductDAO;
import com.tr.dagdem.dao.sale.SaleDAO;
import com.tr.dagdem.model.customer.MusteriTanimTable;
import com.tr.dagdem.model.dealer.SaticiTanimTable;
import com.tr.dagdem.model.product.UrunIadeTable;
import com.tr.dagdem.model.product.UrunTanimTable;
import com.tr.dagdem.model.sale.MusteriSatisTable;
import com.tr.dagdem.model.sale.SatisIptalModel;
import com.tr.dagdem.model.sale.SatisTable;
import com.tr.dagdem.service.BaseServisImpl;
import com.tr.dagdem.service.util.SatisTakipException;
import com.tr.dagdem.wsmodel.Product;
import com.tr.dagdem.wsmodel.Sale;

@Service
@Qualifier("saleService")
public class SaleServiceImpl extends BaseServisImpl implements SaleService{
	
	@Autowired
	private SaleCreationHelper saleCreationHelper;
	
	@Autowired
	private SaleDAO saleDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Transactional
	public void satisiGerceklestir(Sale sale)
	{
		Set<SatisTable> satisTableSeti = new HashSet<SatisTable>(0);
		for(Product product:sale.getProductList())
		{
			SatisTable satisTable = new SatisTable();
			satisTable.setSaticiKodu(new Long(sale.getUserId()));
			UrunTanimTable urunTanimTable = productDAO.findById(UrunTanimTable.class, product.getId());
			satisTable.setUrunKodu(urunTanimTable.getUrunKodu());
			satisTable.setAdet(product.getQuantity());
			satisTable.setSatisTarihi(new Date());
			satisTableSeti.add(satisTable);
		}
		saleDAO.saticiSatisKaydet(satisTableSeti);
	}
	
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
}
