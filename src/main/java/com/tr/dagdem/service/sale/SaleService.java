package com.tr.dagdem.service.sale;

import java.util.Date;
import java.util.List;

import com.tr.dagdem.model.customer.MusteriTanimTable;
import com.tr.dagdem.model.dealer.SaticiTanimTable;
import com.tr.dagdem.model.sale.SatisIptalModel;
import com.tr.dagdem.wsmodel.Sale;

public interface SaleService {

	public void satisiGerceklestir(Sale sale);
	
	public void satisiGerceklestir(SaticiTanimTable satici,Date satisTarihi);
	
	public void satisiGerceklestir(SaticiTanimTable satici,MusteriTanimTable musteri,Date satisTarihi);
	
	public void iadeyiGerceklestir(SaticiTanimTable satici,MusteriTanimTable musteri,Date iadeTarihi);
	
	public List<SatisIptalModel> silinebilecekUrunleriGetir(Date baslamaTarihi,Date bitisTarihi);
	
	public void satisiIptalEt(long satisId);
	
}
