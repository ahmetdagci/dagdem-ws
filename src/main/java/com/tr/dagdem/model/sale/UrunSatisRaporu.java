package com.tr.dagdem.model.sale;

import java.util.List;

public class UrunSatisRaporu {

	private String urunKodu;
	private String urunAdi;
	private long adet;
	
	public UrunSatisRaporu()
	{
		
	}
	
	public UrunSatisRaporu(String urunKodu,long adet)
	{	
		this.urunKodu = urunKodu;
		this.adet = adet;
	}
	
	public UrunSatisRaporu(String urunKodu,String urunAdi,long adet)
	{	
		this.urunKodu = urunKodu;
		this.urunAdi = urunAdi;
		this.adet = adet;
	}
	public String getUrunKodu() {
		return urunKodu;
	}
	
	public void setUrunKodu(String urunKodu) {
		this.urunKodu = urunKodu;
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
	
	public static UrunSatisRaporu urunKoduylaUrunBul(List<UrunSatisRaporu> urunSatisRaporListesi,String urunKodu)
	{
		for(UrunSatisRaporu urunSatisRaporu:urunSatisRaporListesi){
			if(urunSatisRaporu.getUrunKodu().equals(urunKodu))
			{
				return urunSatisRaporu;
			}
		}
		return null;
	} 
}
