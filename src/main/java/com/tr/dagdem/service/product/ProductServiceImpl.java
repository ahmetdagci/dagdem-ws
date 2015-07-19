package com.tr.dagdem.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.tr.dagdem.dao.product.ProductDAO;
import com.tr.dagdem.model.product.UrunTanimTable;
import com.tr.dagdem.model.stock.UrunStockRaporu;
import com.tr.dagdem.model.stock.UrunStockTable;
import com.tr.dagdem.wsmodel.Product;

@Service
@Qualifier("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<UrunTanimTable> urunleriGetir()
	{
		return productDAO.urunleriGetir();
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProducts(String productType)
	{
		List<Product> prodList = Lists.newArrayList();
		List<UrunTanimTable> urunTanimlari = productDAO.urunleriGetir();
		for(UrunTanimTable urunTanim:urunTanimlari)
		{
			Product product = new Product(String.valueOf(urunTanim.getUrunKodu()),urunTanim.getUrunAdi(),urunTanim.getFiyat(),urunTanim.getAdet());
			prodList.add(product);
		}
		return prodList;
	}
	
	public void urunEkle(UrunTanimTable urun)
	{
		productDAO.saveOrUpdate(urun);
	}
	
	public List<UrunStockRaporu> stoktakiUrunleriUrunAdiVeMiktarBilgileriyleGetir()
	{
		return productDAO.stoktakiUrunleriUrunAdiVeMiktarBilgileriyleGetir();
	}
	
	public List<UrunStockRaporu> stoktakiUrunleriFirmaUrunAdiVeMiktarBilgileriyleGetir(Long firmaId)
	{
		return productDAO.stoktakiUrunleriFirmaUrunAdiVeMiktarBilgileriyleGetir(firmaId);
	}
	
	public void stogaUrunEkle(UrunStockTable urunStock)
	{
		productDAO.saveOrUpdate(urunStock);
	}
	
}
