package com.tr.dagdem.service.revenue;

import java.math.BigDecimal;

import com.tr.dagdem.model.revenue.TahsilatTable;

public interface RevenueService {
	
	public void tahsilatKaydet(TahsilatTable tahsilatTable);
	
	public BigDecimal musteridenYapilanTahsilatTutariSorgula(long musteriKodu);
	
	public BigDecimal musteriBorcuSorgula(long musteriKodu);

}
