package com.tr.dagdem.dao.sale.report;

import java.util.Date;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tr.dagdem.dao.GenericDAOImpl;
import com.tr.dagdem.model.sale.MusteriSatisRaporu;
import com.tr.dagdem.model.sale.SatisRaporu;
import com.tr.dagdem.model.sale.UrunSatisRaporu;

@Repository
@Qualifier("saleReportDAO")
public class SaleReportDAOImpl extends GenericDAOImpl implements SaleReportDAO{
	
	
	@SuppressWarnings("unchecked")
	public List<SatisRaporu> saticiBazliYapilanSatislariGetir(Date baslamaTarihi,Date bitisTarihi)
	{
		String query = getSession().getNamedQuery("rapor.yapilanSatislar").getQueryString();
		return (List<SatisRaporu>)getSession().createSQLQuery(query)
				.addScalar("saticiAdi")
				.addScalar("saticiSoyadi")
				.addScalar("urunAdi")
				.addScalar("adet")
				.setResultTransformer(Transformers.aliasToBean(SatisRaporu.class))
				.setDate("baslamaTarihi", baslamaTarihi)
				.setDate("bitisTarihi", bitisTarihi)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MusteriSatisRaporu> saticiBazliYapilanToplamSatislariGetir(Date baslamaTarihi,Date bitisTarihi)
	{
		String query = "select u.urun_adi as urunAdi, a.adet as adet "+ 
				" from urun_tanim_table u,(select st.urun_kodu,sum(st.adet) adet "+ 
				" from satis_table st where st.satis_tarih between :baslamaTarihi and :bitisTarihi group by st.urun_kodu) a"+
				" where	u.urun_kodu = a.urun_kodu";
		return (List<MusteriSatisRaporu>)getSession().createSQLQuery(query)
		.addScalar("urunAdi")
		.addScalar("adet")
		.setResultTransformer(Transformers.aliasToBean(MusteriSatisRaporu.class))
		.setDate("baslamaTarihi", baslamaTarihi)
		.setDate("bitisTarihi", bitisTarihi)
		.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MusteriSatisRaporu> musterilereYapilanSatislariUrunVeAdetBazliGetir(Date baslamaTarihi,Date bitisTarihi)
	{
		String query = "select u.urun_adi as urunAdi, a.adet as adet, a.toplamTutar as toplamSatisTutari" + 
		" from urun_tanim_table u, (select st.urun_kodu,sum(st.adet) adet,sum(st.tutar) toplamTutar "+
		" from musteri_satis_table st where st.etkin=:etkin and st.satis_tarihi between :baslamaTarihi and :bitisTarihi	group by st.urun_kodu) a"+ 
		" where	a.urun_kodu = u.urun_kodu";
	return (List<MusteriSatisRaporu>)getSession().createSQLQuery(query)
		.addScalar("urunAdi")
		.addScalar("adet")
		.addScalar("toplamSatisTutari")
		.setResultTransformer(Transformers.aliasToBean(MusteriSatisRaporu.class))
		.setDate("baslamaTarihi", baslamaTarihi)
		.setDate("bitisTarihi", bitisTarihi)
		.setParameter("etkin", true)
		.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MusteriSatisRaporu> musterilereYapilanSatislariGetir(Date baslamaTarihi,Date bitisTarihi)
	{
		
		String query = "select musteri.musteri_adi as musteriAdi,u.urun_adi as urunAdi,	a.adet as adet, a.toplamTutar as toplamSatisTutari" + 
		" from musteri_tanim_table musteri,urun_tanim_table u, (select	st.musteri_kodu, st.urun_kodu,sum(st.adet) adet,sum(st.tutar) toplamTutar "+
		" from musteri_satis_table st where st.etkin=:etkin and st.satis_tarihi between :baslamaTarihi and :bitisTarihi	group by musteri_kodu,urun_kodu) a"+ 
		" where	a.musteri_kodu=musteri.musteri_id and a.urun_kodu = u.urun_kodu";
	return (List<MusteriSatisRaporu>)getSession().createSQLQuery(query)
		.addScalar("musteriAdi")
		.addScalar("urunAdi")
		.addScalar("adet")
		.addScalar("toplamSatisTutari")
		.setResultTransformer(Transformers.aliasToBean(MusteriSatisRaporu.class))
		.setDate("baslamaTarihi", baslamaTarihi)
		.setDate("bitisTarihi", bitisTarihi)
		.setParameter("etkin", true)
		.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MusteriSatisRaporu> musteriyeYapilanSatislariGetir(long musteriNo)
	{
		String query = "select musteri.musteri_adi as musteriAdi,u.urun_adi as urunAdi,	a.adet as adet, a.toplamTutar as toplamSatisTutari" + 
		" from musteri_tanim_table musteri,urun_tanim_table u, (select	st.musteri_kodu, st.urun_kodu,sum(st.adet) adet,sum(st.tutar) toplamTutar"+
		" from musteri_satis_table st where st.etkin=:etkin and st.musteri_kodu=:musteriKodu group by musteri_kodu,urun_kodu) a"+ 
		" where	a.musteri_kodu=musteri.musteri_id and a.urun_kodu = u.urun_kodu";
		
		String q = "select musteriSatis.pk.musteri.musteriAdi as musteriAdi ,musteriSatis.pk.urun.urunAdi as urunAdi ,musteriSatis.adet as adet from MusteriSatisTable musteriSatis where musteriSatis.etkin = true and musteriSatis.pk.musteri.id=:musteriId";
	return (List<MusteriSatisRaporu>)getSession().createQuery(q)
		.setResultTransformer(Transformers.aliasToBean(MusteriSatisRaporu.class))
		.setParameter("musteriId", musteriNo)
		.list();
	}

	@SuppressWarnings("unchecked")
	public List<MusteriSatisRaporu> musteriyeYapilanSatislariGetir(long musteriNo, Date baslamaTarihi, Date bitisTarihi) {
		String query = "select musteri.musteri_adi as musteriAdi,u.urun_adi as urunAdi,	a.adet as adet, a.toplamTutar as toplamSatisTutari" + 
		" from musteri_tanim_table musteri,urun_tanim_table u, (select	st.musteri_kodu, st.urun_kodu,sum(st.adet) adet,sum(st.tutar) toplamTutar"+
		" from musteri_satis_table st where st.etkin=:etkin and st.musteri_kodu=:musteriKodu  and st.satis_tarihi between :baslamaTarihi and :bitisTarihi group by musteri_kodu,urun_kodu) a"+ 
		" where	a.musteri_kodu=musteri.musteri_id and a.urun_kodu = u.urun_kodu";
	return (List<MusteriSatisRaporu>)getSession().createSQLQuery(query)
		.addScalar("musteriAdi")
		.addScalar("urunAdi")
		.addScalar("adet")
		.addScalar("toplamSatisTutari")
		.setResultTransformer(Transformers.aliasToBean(MusteriSatisRaporu.class))
		.setParameter("musteriKodu", musteriNo)
		.setDate("baslamaTarihi", baslamaTarihi)
		.setDate("bitisTarihi", bitisTarihi)
		.setParameter("etkin", true)
		.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MusteriSatisRaporu> musteriyeYapilanSatislar(long musteriNo, Date baslamaTarihi, Date bitisTarihi) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select "); 
		queryBuilder.append("urun.urun_adi as urunAdi,musteriSatis.adet as adet,musteriSatis.tutar as toplamSatisTutari,musteriSatis.satis_tarihi as satisTarihi ");
		queryBuilder.append("from ");
		queryBuilder.append("musteri_satis_table musteriSatis,urun_tanim_table urun ");
		queryBuilder.append("where musteriSatis.etkin=:etkin and ");
		queryBuilder.append("musteriSatis.musteri_kodu=:musteriKodu and ");
		queryBuilder.append("musteriSatis.satis_tarihi between :baslamaTarihi and :bitisTarihi and ");
		queryBuilder.append("musteriSatis.urun_kodu = urun.urun_kodu ");
		queryBuilder.append("order by musteriSatis.satis_tarihi desc");
	return (List<MusteriSatisRaporu>)getSession().createSQLQuery(queryBuilder.toString())
		.addScalar("urunAdi")	
		.addScalar("adet")
		.addScalar("toplamSatisTutari")
		.addScalar("satisTarihi")
		.setResultTransformer(Transformers.aliasToBean(MusteriSatisRaporu.class))
		.setParameter("musteriKodu", musteriNo)
		.setDate("baslamaTarihi", baslamaTarihi)
		.setDate("bitisTarihi", bitisTarihi)
		.setParameter("etkin", true)
		.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<UrunSatisRaporu> musterilereToplamUrunSatislari()
	{	
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select a.urun_kodu as urunKodu ,u.urun_adi as urunAdi,a.adet as adet from urun_tanim_table u, ");
		queryBuilder.append("(select musteriSatis.urun_kodu  urun_kodu,sum(adet) adet from musteri_satis_table musteriSatis where musteriSatis.etkin=:etkin group by musteriSatis.urun_kodu) a ");
		queryBuilder.append("where u.urun_kodu = a.urun_kodu");
		return (List<UrunSatisRaporu>)getSession().createSQLQuery(queryBuilder.toString())
		.addScalar("urunKodu")
		.addScalar("urunAdi")
		.addScalar("adet")
		.setResultTransformer(Transformers.aliasToBean(UrunSatisRaporu.class))
		.setParameter("etkin", true)
		.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<UrunSatisRaporu> stocktakiTumUrunler()
	{
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select a.urun_kodu as urunKodu ,u.urun_adi as urunAdi,a.adet as adet from urun_tanim_table u, ");
		queryBuilder.append("(select urunStok.urun_kodu,sum(urunStok.koli_adet*urunStok.adet) adet from urun_stock_table urunStok group by urunStok.urun_kodu) a ");
		queryBuilder.append("where u.urun_kodu = a.urun_kodu");
		return (List<UrunSatisRaporu>)getSession().createSQLQuery(queryBuilder.toString())
		.addScalar("urunKodu")
		.addScalar("urunAdi")
		.addScalar("adet")
		.setResultTransformer(Transformers.aliasToBean(UrunSatisRaporu.class))
		.list();
	}
	
}
