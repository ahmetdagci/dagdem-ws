package com.tr.dagdem.service.sale.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.dao.sale.report.SaleReportDAO;
import com.tr.dagdem.model.sale.MusteriSatisRaporu;
import com.tr.dagdem.model.sale.SatisRaporu;
import com.tr.dagdem.model.sale.UrunSatisRaporu;
import com.tr.dagdem.service.BaseServisImpl;

@Service("saleReportService")
public class SaleReportServiceImpl extends BaseServisImpl implements SaleReportService{
	
	@Autowired
	private SaleReportDAO saleReportDAO;
	
	public List<SatisRaporu> saticiBazliYapilanSatislariGetir(Date baslamaTarihi,Date bitisTarihi)
	{
		return saleReportDAO.saticiBazliYapilanSatislariGetir(baslamaTarihi, bitisTarihi); 
	}
	
	public List<MusteriSatisRaporu> saticiBazliYapilanToplamSatislariGetir(Date baslamaTarihi,Date bitisTarihi)
	{
		return saleReportDAO.saticiBazliYapilanToplamSatislariGetir(baslamaTarihi, bitisTarihi); 
	}
	
	public List<MusteriSatisRaporu> musteriyeYapilanSatislar(long musteriNo, Date baslamaTarihi, Date bitisTarihi)
	{
		return saleReportDAO.musteriyeYapilanSatislar(musteriNo,baslamaTarihi, bitisTarihi);
	}
	
	public List<MusteriSatisRaporu> musterilereYapilanSatislariGetir(Date baslamaTarihi,Date bitisTarihi)
	{
		return saleReportDAO.musterilereYapilanSatislariGetir(baslamaTarihi, bitisTarihi); 
	}
	
	public List<MusteriSatisRaporu> musterilereYapilanSatislariUrunVeAdetBazliGetir(Date baslamaTarihi,Date bitisTarihi)
	{
		return saleReportDAO.musterilereYapilanSatislariUrunVeAdetBazliGetir(baslamaTarihi, bitisTarihi);
	}
	
	public List<MusteriSatisRaporu> musteriyeYapilanSatislariGetir(long musteriId,Date baslamaTarihi,Date bitisTarihi)
	{
		return saleReportDAO.musteriyeYapilanSatislariGetir(musteriId, baslamaTarihi, bitisTarihi);
	}
	
	@Transactional
	public List<MusteriSatisRaporu> musteriyeYapilanTumSatislariGetir(long musteriId)
	{
		return saleReportDAO.musteriyeYapilanSatislariGetir(musteriId); 
	}
	
	public List<UrunSatisRaporu> musterilereToplamUrunSatislari()
	{
		List<UrunSatisRaporu> musterilereToplamUrunSatislari = saleReportDAO.musterilereToplamUrunSatislari();
		List<UrunSatisRaporu> stocktakiTumUrunler = saleReportDAO.stocktakiTumUrunler();
		return stocktaKalanUrunMiktarlari(stocktakiTumUrunler,musterilereToplamUrunSatislari);
	}
	
	private List<UrunSatisRaporu> stocktaKalanUrunMiktarlari(List<UrunSatisRaporu> stocktakiTumUrunler,List<UrunSatisRaporu> musterilereToplamUrunSatislari)
	{	
		List<UrunSatisRaporu> stocktaKalanUrunListesiRaporu = new ArrayList<UrunSatisRaporu>();
		for(UrunSatisRaporu urunSatisRaporu:stocktakiTumUrunler)
		{	
			long adet =urunSatisRaporu.getAdet();
			UrunSatisRaporu musteriSatisUrunRaporu = UrunSatisRaporu.urunKoduylaUrunBul(musterilereToplamUrunSatislari, urunSatisRaporu.getUrunKodu());
			if(musteriSatisUrunRaporu!=null)
			{
				adet = adet-musteriSatisUrunRaporu.getAdet();
			}
			UrunSatisRaporu satisraporu = new UrunSatisRaporu(urunSatisRaporu.getUrunKodu(),urunSatisRaporu.getUrunAdi(),adet);
			stocktaKalanUrunListesiRaporu.add(satisraporu);
		}
		return stocktaKalanUrunListesiRaporu;
	}
	
	@Override
	protected GenericDAO getDAO() {
		return saleReportDAO;
	}
	
}
