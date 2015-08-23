package com.tr.dagdem.dao.revenue;

import java.math.BigDecimal;

import com.tr.dagdem.dao.GenericDAO;

public interface RevenueDAO extends GenericDAO
{
	public BigDecimal musteridenYapilanTahsilatTutariSorgula(long musteriId);
	
	public BigDecimal musteriyeYapilanSatisSorgula(long musteriId);
	
	public BigDecimal tumMusterilereYapilanSatisTutari();
	
	public BigDecimal tumMusterilerdenYapilanTahsilatTutariSorgula();
}
