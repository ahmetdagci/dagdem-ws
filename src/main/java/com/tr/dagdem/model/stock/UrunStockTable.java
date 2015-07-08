package com.tr.dagdem.model.stock;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


@SuppressWarnings("serial")
@Entity
@Table(name = "URUN_STOCK_TABLE",catalog = "satistakip")
public class UrunStockTable implements Serializable {

	private long id;
	private Long firmaKodu;
	private String firmaAdi;
	private int urunKodu;
	private String urunAdi;
	private Integer koliAdeti;
	private Integer adet;
	private double birimFiyati;
	private Date tarih;
	
	@Id
    @Column(name = "STOCK_ID", unique = true, nullable = false, precision = 23, scale = 0)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    
    @Column(name = "FIRMA_KODU", nullable = false,precision = 23, scale = 0)
    public Long getFirmaKodu() {
		return firmaKodu;
	}
    
    public void setFirmaKodu(Long firmaKodu) {
		this.firmaKodu = firmaKodu;
	}
    
    @Column(name = "FIRMA_ADI", length = 200)
    @Max(200)
    public String getFirmaAdi() {
		return firmaAdi;
	}
    
    public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}
    
    @Column(name = "URUN_KODU",precision = 7, scale = 0)
    public int getUrunKodu() {
		return urunKodu;
	}
    
    public void setUrunKodu(int urunKodu) {
		this.urunKodu = urunKodu;
	}
    
    @Column(name = "URUN_ADI", length=200)
    @Max(200)
    public String getUrunAdi() {
		return urunAdi;
	}
    
    public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
    
    @Column(name = "KOLI_ADET", precision = 7, scale = 0)
    public Integer getKoliAdeti() {
		return koliAdeti;
	}
    
    public void setKoliAdeti(Integer koliAdeti) {
		this.koliAdeti = koliAdeti;
	}
    
    @Column(name = "ADET", precision = 7, scale = 0)
    public Integer getAdet() {
		return adet;
	}
    
    public void setAdet(Integer adet) {
		this.adet = adet;
	}
    
    @Column(name = "BIRIM_FIYATI", precision = 10, scale = 2)
    public double getBirimFiyati() {
		return birimFiyati;
	}
    
    public void setBirimFiyati(double birimFiyati) {
		this.birimFiyati = birimFiyati;
	}

    @Temporal(TemporalType.DATE)
	@Column(name = "TARIH")
    public Date getTarih() {
		return tarih;
	}

    public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
}
