package com.tr.dagdem.service.revenue;

import java.math.BigDecimal;

import com.tr.dagdem.model.revenue.TahsilatTable;
import com.tr.dagdem.wsmodel.Customer;
import com.tr.dagdem.wsmodel.CustomerTrafficReport;

public interface RevenueService {
	
	public void tahsilatKaydet(Customer customer,BigDecimal paymentAmount);
	
	public void tahsilatKaydet(TahsilatTable tahsilatTable);
	
	public BigDecimal tumMusterilerdenYapilanTahsilatTutariSorgula();
	
	public BigDecimal tumMusterilereYapilanSatisTutari();
	
	public BigDecimal musteridenYapilanTahsilatTutariSorgula(long musteriKodu);
	
	public BigDecimal musteriBorcuSorgula(long musteriKodu);
	
	public CustomerTrafficReport getCustomerTrafficReport(Long customerNo);

}
