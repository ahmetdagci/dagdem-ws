package com.tr.dagdem.dao.product;

import java.util.List;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.model.product.UrunTanimTable;
import com.tr.dagdem.model.stock.UrunStockRaporu;

public interface ProductDAO extends GenericDAO{
	
	public List<UrunTanimTable> urunleriGetir();
	
	public String urunAdiGetir(int urunKodu);
	
	public List<UrunStockRaporu> stoktakiUrunleriUrunAdiVeMiktarBilgileriyleGetir();
	
	public List<UrunStockRaporu> stoktakiUrunleriFirmaUrunAdiVeMiktarBilgileriyleGetir(Long firmaId);
	
}
