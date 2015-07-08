package com.tr.dagdem.model.sale;

import java.io.Serializable;


@SuppressWarnings("serial")
public class SatisRaporu implements Serializable {
	
	private String saticiAdi;
	private String saticiSoyadi;
	private String urunAdi;
	private long adet;
	
	public SatisRaporu()
	{
		
	}
	
	public SatisRaporu(String saticiAdi,String saticiSoyadi,String urunAdi,long adet)
	{
		this.saticiAdi = saticiAdi;
		this.saticiSoyadi = saticiSoyadi;
		this.urunAdi = urunAdi;
		this.adet = adet;
	}

	public String getSaticiAdi() {
		return saticiAdi;
	}

	public void setSaticAdi(String saticiAdi) {
		this.saticiAdi = saticiAdi;
	}
	
	public String getSaticiSoyadi() {
		return saticiSoyadi;
	}
	
	public void setSaticiSoyadi(String saticiSoyadi) {
		this.saticiSoyadi = saticiSoyadi;
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
	
	public String saticiAdiSoyadi()
	{
		return saticiAdi+" "+ saticiSoyadi;
	}
}
