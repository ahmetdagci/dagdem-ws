package com.tr.dagdem.model.sale;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class MusteriSatisRaporu implements Serializable {
	
	private String musteriAdi;
	private String urunAdi;
	private long adet;
	private BigDecimal toplamSatisTutari;
	private Date satisTarihi;
	private String saticiAdi;
	
	public MusteriSatisRaporu()
	{
		
	}
	
	public MusteriSatisRaporu(String musteriAdi,String urunAdi,long adet,BigDecimal toplamSatisTutari)
	{
		this.musteriAdi = musteriAdi;
		this.urunAdi = urunAdi;
		this.adet = adet;
		this.toplamSatisTutari = toplamSatisTutari;
	}
	
	public MusteriSatisRaporu(String urunAdi,long adet,BigDecimal toplamSatisTutari,Date satisTarihi)
	{
		this.urunAdi = urunAdi;
		this.adet = adet;
		this.toplamSatisTutari = toplamSatisTutari;
		this.satisTarihi = satisTarihi;
	}


	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
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
	
	public BigDecimal getToplamSatisTutari() {
		return toplamSatisTutari;
	}
	
	public void setToplamSatisTutari(BigDecimal toplamSatisTutari) {
		this.toplamSatisTutari = toplamSatisTutari;
	}
	
	public Date getSatisTarihi() {
		return satisTarihi;
	}
	
	public void setSatisTarihi(Date satisTarihi) {
		this.satisTarihi = satisTarihi;
	}
	
	public String getSaticiAdi() {
		return saticiAdi;
	}
	
	public void setSaticiAdi(String saticiAdi) {
		this.saticiAdi = saticiAdi;
	}
	
	public static BigDecimal satisTutariniHesapla(List<MusteriSatisRaporu> satislar)
	{
		BigDecimal toplamSatisTutari = BigDecimal.ZERO;
		
		for(MusteriSatisRaporu satisRaporu:satislar)
		{
			toplamSatisTutari = toplamSatisTutari.add(satisRaporu.getToplamSatisTutari());
		}
		return toplamSatisTutari;
	}
}
