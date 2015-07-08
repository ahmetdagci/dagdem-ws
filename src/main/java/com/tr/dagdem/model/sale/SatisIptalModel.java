package com.tr.dagdem.model.sale;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;


public class SatisIptalModel {

	private long satisId;
	private String musteriAdi;
	private String musteriSoyadi;
	private String urunAdi;
	private long adet;
	private BigDecimal tutar;
	private Date satisTarihi;
	
	public SatisIptalModel()
	{
		
	}
	public SatisIptalModel(long satisId,long adet,String musteriAdi,String musteriSoyadi,String urunAdi,BigDecimal tutar,Date satisTarihi)
	{	
		this.satisId = satisId;
		this.adet = adet;
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
		this.urunAdi = urunAdi;
		this.tutar = tutar;
		this.satisTarihi = satisTarihi;
	}
	
	public long getSatisId() {
		return satisId;
	}
	
	public void setSatisId(long satisId) {
		this.satisId = satisId;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}
	
	public String getMusteriSoyadi() {
		return musteriSoyadi;
	}
	
	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
	}
	
	public String getUrunAdi() {
		return urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public long getAdet() {
		return adet;
	}

	public void setAdet(long adet) {
		this.adet = adet;
	}
	
	public BigDecimal getTutar() {
		return tutar;
	}
	
	public void setTutar(BigDecimal tutar) {
		this.tutar = tutar;
	}

	public Date getSatisTarihi() {
		return satisTarihi;
	}
	
	public void setSatisTarihi(Date satisTarihi) {
		this.satisTarihi = satisTarihi;
	}
	
	public String getMusteriAdiSoyadi()
	{
		return StringUtils.join(new Object[]{this.getMusteriAdi()," ",this.getMusteriSoyadi()}).toUpperCase();
	}
	
}
