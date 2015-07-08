package com.tr.dagdem.model.product;

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
@Table(name="URUN_IADE_TABLE",catalog="satistakip")
public class UrunIadeTable implements Serializable{
	
	private long id;
	private long saticiKodu;
	private long musteriKodu;
	private long urunKodu;
	private String iadeNedeni;
	private long adet;
	private Date iadeTarihi;
	private Date tarih;
	
	@Id
    @Column(name = "IADE_ID", unique = true, nullable = false, precision = 23, scale = 0)
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
    
    @Column(name = "SATICI_KODU", precision = 23, scale = 0)
    public long getSaticiKodu() {
		return saticiKodu;
	}
    
    public void setSaticiKodu(long saticiKodu) {
		this.saticiKodu = saticiKodu;
	}
    
    @Column(name = "MUSTERI_KODU", precision = 23, scale = 0)
    public long getMusteriKodu() {
		return musteriKodu;
	}
    
    public void setMusteriKodu(long musteriKodu) {
		this.musteriKodu = musteriKodu;
	}
    
    @Column(name = "URUN_KODU", precision = 23, scale = 0)
    public long getUrunKodu() {
		return urunKodu;
	}
    
    public void setUrunKodu(long urunKodu) {
		this.urunKodu = urunKodu;
	}
    
    
    @Column(name = "ADET", precision = 10, scale = 0)
    public long getAdet() {
		return adet;
	}
    
    public void setAdet(long adet) {
		this.adet = adet;
	}
    
    @Temporal(TemporalType.DATE)
	@Column(name = "IADE_TARIHI")
    public Date getIadeTarihi() {
		return iadeTarihi;
	}

    public void setIadeTarihi(Date iadeTarihi) {
		this.iadeTarihi = iadeTarihi;
	}

    @Temporal(TemporalType.DATE)
	@Column(name = "TARIH")
    public Date getTarih() {
		return tarih;
	}
    
    public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
    
    @Column(name = "IADE_NEDENI", length = 300)
    @Max(300)
    public String getIadeNedeni() {
		return iadeNedeni;
	}
    
    public void setIadeNedeni(String iadeNedeni) {
		this.iadeNedeni = iadeNedeni;
	}
}
