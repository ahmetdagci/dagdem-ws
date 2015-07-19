package com.tr.dagdem.service.revenue;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.dao.revenue.RevenueDAO;
import com.tr.dagdem.model.revenue.TahsilatTable;
import com.tr.dagdem.service.BaseServisImpl;
import com.tr.dagdem.wsmodel.Customer;
import com.tr.dagdem.wsmodel.CustomerTrafficReport;

@Service
@Qualifier("revenueService")
public class RevenueServiceImpl extends BaseServisImpl implements RevenueService {
	
	@Autowired
	private RevenueDAO revenueDAO;
	
	@Transactional
	public void tahsilatKaydet(Customer customer,BigDecimal paymentAmount)
	{
		TahsilatTable tahsilatTable = new TahsilatTable();
		tahsilatTable.setMusteriKodu(new Long(customer.getCustomerNo()));
		tahsilatTable.setTarih(new Date());
		tahsilatTable.setTutar(paymentAmount);
		revenueDAO.saveOrUpdate(tahsilatTable);
	}
	
	public void tahsilatKaydet(TahsilatTable tahsilatTable) 
	{
		revenueDAO.saveOrUpdate(tahsilatTable);
	}

	public BigDecimal tumMusterilereYapilanSatisTutari()
	{
		return revenueDAO.tumMusterilereYapilanSatisTutari();
	}
	
	public BigDecimal tumMusterilerdenYapilanTahsilatTutariSorgula() 
	{
		return revenueDAO.tumMusterilerdenYapilanTahsilatTutariSorgula();
	}
	
	public BigDecimal musteridenYapilanTahsilatTutariSorgula(long musteriKodu)
	{
		return revenueDAO.musteridenYapilanTahsilatTutariSorgula(musteriKodu);	
	}
	
	@Transactional
	public BigDecimal musteriBorcuSorgula(long musteriKodu)
	{
		BigDecimal musteriyeYapilanSatisTutari = revenueDAO.musteriyeYapilanSatisSorgula(musteriKodu);
		BigDecimal musteridenYapilanTahsilatTutari = revenueDAO.musteridenYapilanTahsilatTutariSorgula(musteriKodu);
		return musteriyeYapilanSatisTutari.subtract(musteridenYapilanTahsilatTutari);
	}
	
	public CustomerTrafficReport getCustomerTrafficReport(Long musteriKodu)
	{
		BigDecimal musteriyeYapilanSatisTutari = revenueDAO.musteriyeYapilanSatisSorgula(musteriKodu);
		BigDecimal musteridenYapilanTahsilatTutari = revenueDAO.musteridenYapilanTahsilatTutariSorgula(musteriKodu);
		CustomerTrafficReport customerTrafficReport = new CustomerTrafficReport(new Long(musteriKodu), musteridenYapilanTahsilatTutari, musteriyeYapilanSatisTutari);
		return customerTrafficReport;
	}
	
	@Override
	protected GenericDAO getDAO() {
		return revenueDAO;
	}

}
