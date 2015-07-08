package com.tr.dagdem.service.product;

import java.util.List;

import com.tr.dagdem.model.product.UrunTanimTable;
import com.tr.dagdem.model.stock.UrunStockRaporu;
import com.tr.dagdem.model.stock.UrunStockTable;

public interface ProductService {

	public List<UrunTanimTable> urunleriGetir();
	
	public void urunEkle(UrunTanimTable urun);
	
	public List<UrunStockRaporu> stoktakiUrunleriUrunAdiVeMiktarBilgileriyleGetir();
	
	public List<UrunStockRaporu> stoktakiUrunleriFirmaUrunAdiVeMiktarBilgileriyleGetir(Long firmaId);
	
	public void stogaUrunEkle(UrunStockTable urunStock);
}
