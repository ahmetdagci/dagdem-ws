package com.tr.dagdem.dao.sale.report;

import java.util.Date;
import java.util.List;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.model.sale.MusteriSatisRaporu;
import com.tr.dagdem.model.sale.SatisRaporu;
import com.tr.dagdem.model.sale.UrunSatisRaporu;

public interface SaleReportDAO extends GenericDAO {

	
	public List<SatisRaporu> saticiBazliYapilanSatislariGetir(Date baslamaTarihi,Date bitisTarihi);
	
	public List<MusteriSatisRaporu> saticiBazliYapilanToplamSatislariGetir(Date baslamaTarihi,Date bitisTarihi);
	
	public List<MusteriSatisRaporu> musteriyeYapilanSatislar(long musteriNo, Date baslamaTarihi, Date bitisTarihi);
	
	public List<MusteriSatisRaporu> musterilereYapilanSatislariGetir(Date baslamaTarihi,Date bitisTarihi);;
	
	public List<MusteriSatisRaporu> musteriyeYapilanSatislariGetir(long musteriId);
	
	public List<MusteriSatisRaporu> musteriyeYapilanSatislariGetir(long musteriId,Date baslamaTarihi,Date bitisTarihi);
	
	public List<MusteriSatisRaporu> musterilereYapilanSatislariUrunVeAdetBazliGetir(Date baslamaTarihi,Date bitisTarihi);
	
	public List<UrunSatisRaporu> musterilereToplamUrunSatislari();
	
	public List<UrunSatisRaporu> stocktakiTumUrunler();
	
}
