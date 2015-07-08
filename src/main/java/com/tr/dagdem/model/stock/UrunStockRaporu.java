package com.tr.dagdem.model.stock;

import java.math.BigDecimal;
import java.util.Date;

public class UrunStockRaporu {

	private String urunAdi;
	private long koliAdet;
	private Long adet;
	private long toplamAdet;
	private Date stockGirisTarihi;
	private BigDecimal toplamTutar;
	private BigDecimal birimFiyat;
	
	public UrunStockRaporu()
	{
	}
	
	public UrunStockRaporu(String urunAdi,long adet)
	{
		this.urunAdi = urunAdi;
		this.adet = adet;
	}
	
	public String getUrunAdi() {
		return urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public Long getAdet() {
		return adet;
	}

	public void setAdet(Long adet) {
		this.adet = adet;
	}
	
	public long getKoliAdet() {
		return koliAdet;
	}
	
	public void setKoliAdet(long koliAdet) {
		this.koliAdet = koliAdet;
	}
	
	public long getToplamAdet() {
		return adet*koliAdet;
	}
	
	public Date getStockGirisTarihi() {
		return stockGirisTarihi;
	}
	
	public BigDecimal getToplamTutar() {
		return toplamTutar;
	}
	
	public BigDecimal getBirimFiyat() {
		return birimFiyat;
	}
	
	public void setBirimFiyat(BigDecimal birimFiyat) {
		this.birimFiyat = birimFiyat;
	}
	
	public void setToplamTutar(BigDecimal toplamTutar) {
		this.toplamTutar = toplamTutar;
	}
	
	public void setStockGirisTarihi(Date stockGirisTarihi) {
		this.stockGirisTarihi = stockGirisTarihi;
	}
}
