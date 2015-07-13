package com.tr.dagdem.dao.company;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tr.dagdem.dao.GenericDAOImpl;
import com.tr.dagdem.model.company.FirmaOdemeTable;
import com.tr.dagdem.model.company.FirmaTanimTable;
import com.tr.dagdem.model.stock.UrunStockTable;


@Repository
@Qualifier("companyDAO")
public class CompanyDAOImpl extends GenericDAOImpl implements CompanyDAO {

	public void firmaKaydet(FirmaTanimTable firma)
	{
		getSession().saveOrUpdate(firma);	
	}
	
	@SuppressWarnings("unchecked")
	public List<FirmaTanimTable> firmalar() 
	{
		return getSession().createCriteria(FirmaTanimTable.class).addOrder(Order.asc("firmaAdi")).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<UrunStockTable> firmadanAlinanTumUrunler(long firmaKodu){
		return getSession().createCriteria(UrunStockTable.class).add(Restrictions.eq("firmaKodu", firmaKodu)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<FirmaOdemeTable> firmayaYapilanOdemeler(long firmaKodu){
		return getSession().createCriteria(FirmaOdemeTable.class).add(Restrictions.eq("firmaKodu", firmaKodu)).list();
	}
}
