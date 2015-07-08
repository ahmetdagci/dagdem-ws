package com.tr.dagdem.dao.product;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tr.dagdem.dao.GenericDAOImpl;
import com.tr.dagdem.model.product.UrunTanimTable;
import com.tr.dagdem.model.stock.UrunStockRaporu;

@Repository
@Qualifier("productDAO")
public class ProductDAOImpl extends GenericDAOImpl implements ProductDAO {
	
	@SuppressWarnings("unchecked")
	public List<UrunTanimTable> urunleriGetir()
	{
		return (List<UrunTanimTable>)this.getSession().createQuery("from UrunTanimTable order by type asc ").list();
	}
	
	@SuppressWarnings("unchecked")
	public String urunAdiGetir(int urunKodu){
		List<String> urunAdListesi =(List<String>) getSession().createQuery("select urunAdi from UrunTanimTable urun where urun.urunKodu=:urunKodu")
		.setParameter("urunKodu", urunKodu).list();
		if(!urunAdListesi.isEmpty()){
			return urunAdListesi.get(0);
		}
		return StringUtils.EMPTY;
	}
	
	@SuppressWarnings("unchecked")
	public List<UrunStockRaporu> stoktakiUrunleriFirmaUrunAdiVeMiktarBilgileriyleGetir(Long firmaId) 
	{
		String query = "select u.urun_adi as urunAdi, sum(s.koli_adet*s.adet) as adet,sum(s.koli_adet) as koliAdet" + 
		" from urun_stock_table s,urun_tanim_table u where u.urun_kodu=s.urun_kodu and s.firma_kodu=:firmaId group by s.urun_kodu";
	return (List<UrunStockRaporu>)getSession().createSQLQuery(query)
		.addScalar("urunAdi")
		.addScalar("adet")
		.addScalar("koliAdet")
		.setResultTransformer(Transformers.aliasToBean(UrunStockRaporu.class))
		.setLong("firmaId", firmaId)
		.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<UrunStockRaporu> stoktakiUrunleriUrunAdiVeMiktarBilgileriyleGetir()
	{
		String query = "select u.urun_adi as urunAdi, sum(s.koli_adet*s.adet) as adet,sum(s.koli_adet) as koliAdet" + 
		" from urun_stock_table s,urun_tanim_table u where u.urun_kodu=s.urun_kodu group by s.urun_kodu";
	return (List<UrunStockRaporu>)getSession().createSQLQuery(query)
		.addScalar("urunAdi")
		.addScalar("adet")
		.addScalar("koliAdet")
		.setResultTransformer(Transformers.aliasToBean(UrunStockRaporu.class))
		.list();
	}
	
}
