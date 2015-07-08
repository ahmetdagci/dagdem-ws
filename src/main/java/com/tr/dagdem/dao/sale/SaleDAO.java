package com.tr.dagdem.dao.sale;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.model.product.UrunIadeTable;
import com.tr.dagdem.model.sale.MusteriSatisTable;
import com.tr.dagdem.model.sale.SatisIptalModel;
import com.tr.dagdem.model.sale.SatisTable;

public interface SaleDAO extends GenericDAO{
	
	public void saticiSatisKaydet(Set<SatisTable> satisTableSeti);
	
	public void musteriSatisKaydet(Set<MusteriSatisTable> musteriSatisSeti);
	
	public void musteriUrunIadeKaydet(Set<UrunIadeTable> urunIadeTables);
	
	public List<SatisIptalModel> silinebilecekUrunleriGetir(Date baslamaTarihi,Date bitisTarihi);
	
}
