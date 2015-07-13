package com.tr.dagdem.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tr.dagdem.dao.product.ProductDAO;
import com.tr.dagdem.model.product.UrunTanimTable;
import com.tr.dagdem.model.stock.UrunStockRaporu;
import com.tr.dagdem.model.stock.UrunStockTable;

@Service
@Qualifier("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<UrunTanimTable> urunleriGetir()
	{
		return productDAO.urunleriGetir();
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
	
//	@Resource(name="productDAO")
//	public void setProductDAO(ProductDAO productDAO) {
//		this.productDAO = productDAO;
//	}
}
