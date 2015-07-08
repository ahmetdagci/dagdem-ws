package com.tr.dagdem.dao.revenue;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tr.dagdem.dao.GenericDAOImpl;

@Repository
@Qualifier("revenueDAO")
public class RevenueDAOImpl extends GenericDAOImpl implements RevenueDAO{

	public BigDecimal musteridenYapilanTahsilatTutariSorgula(long musteriKodu)
	{	
		BigDecimal musteriToplamOdemeTutari = (BigDecimal)getSession().createQuery("select sum(tahsilat.tutar) from TahsilatTable tahsilat where tahsilat.musteriKodu=:musteriKodu")
		.setParameter("musteriKodu", musteriKodu).uniqueResult();
		if(musteriToplamOdemeTutari==null)
		{
			musteriToplamOdemeTutari = BigDecimal.ZERO;
		}
		return musteriToplamOdemeTutari;
	}
	
	public BigDecimal musteriBorcuSorgula(long musteriKodu)
	{
		BigDecimal toplamBorcTutari = (BigDecimal)getSession().createQuery("select sum(tutar) from MusteriSatisTable musteriSatis where musteriSatis.etkin=true and musteriSatis.musteriKodu=:musteriKodu")
		.setParameter("musteriKodu", musteriKodu)
		.uniqueResult();
		if(toplamBorcTutari==null)
		{
			toplamBorcTutari = BigDecimal.ZERO;
		}
		return toplamBorcTutari.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
