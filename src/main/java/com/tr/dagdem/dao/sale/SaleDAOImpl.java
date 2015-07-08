package com.tr.dagdem.dao.sale;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tr.dagdem.dao.GenericDAOImpl;
import com.tr.dagdem.model.product.UrunIadeTable;
import com.tr.dagdem.model.sale.MusteriSatisTable;
import com.tr.dagdem.model.sale.SatisIptalModel;
import com.tr.dagdem.model.sale.SatisTable;

@Repository
@Qualifier("saleDAO")
public class SaleDAOImpl extends GenericDAOImpl implements SaleDAO
{
	public void saticiSatisKaydet(Set<SatisTable> satisTableSeti)
	{	
		for(SatisTable satisTable:satisTableSeti){
			getSession().save(satisTable);	
		}
	}
	
	public void musteriSatisKaydet(Set<MusteriSatisTable> musteriSatisSeti)
	{	
		for(MusteriSatisTable musteriSatisTable:musteriSatisSeti){
			getSession().save(musteriSatisTable);	
		}
	}
	
	public void musteriUrunIadeKaydet(Set<UrunIadeTable> urunIadeTables)
	{	
		for(UrunIadeTable urunIadeTable:urunIadeTables){
			getSession().save(urunIadeTable);	
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SatisIptalModel> silinebilecekUrunleriGetir(Date baslamaTarihi,Date bitisTarihi)
	{
		String query = "select ms.satis_id as satisId," +
				"ms.adet,m.musteri_adi as musteriAdi," +
				"m.musteri_soyadi as musteriSoyadi," +
				"u.urun_adi as urunAdi," +
				"ms.adet as adet," +
				"ms.tutar as tutar," +
				"ms.satis_tarihi as satisTarihi " +
				"from musteri_satis_table ms,urun_tanim_table u, musteri_tanim_table m "+
				"where ms.etkin=:etkin and ms.satis_tarihi between :baslamaTarihi and :bitisTarihi and ms.urun_kodu=u.urun_kodu and ms.musteri_kodu= m.musteri_id";
		return (List<SatisIptalModel>)getSession().createSQLQuery(query)
			.addScalar("satisId")
			.addScalar("musteriAdi")
			.addScalar("musteriSoyadi")
			.addScalar("urunAdi")
			.addScalar("adet")
			.addScalar("tutar")
			.addScalar("satisTarihi")
			.setResultTransformer(Transformers.aliasToBean(SatisIptalModel.class))
			.setDate("baslamaTarihi", baslamaTarihi)
			.setDate("bitisTarihi", bitisTarihi)
			.setParameter("etkin", true)
			.list();
	}
}
