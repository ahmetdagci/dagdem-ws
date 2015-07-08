package com.tr.dagdem.model.sale;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "MUSTERI_SATIS_TABLE",catalog = "satistakip")
public class MusteriSatisTable implements Serializable{

	private long id;
	private long saticiKodu;
	private long musteriKodu;
	private long urunKodu;
	private long adet;
	private double satisFiyati;
	private Date satisTarihi;
	private BigDecimal tutar;
	private boolean etkin = true;
	
	@Id
    @Column(name = "SATIS_ID", unique = true, nullable = false, precision = 23, scale = 0)
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
    
    @Column(name = "SATIS_FIYATI", precision = 10, scale = 2)
    public double getSatisFiyati() {
		return satisFiyati;
	}
    
    public void setSatisFiyati(double satisFiyati) {
		this.satisFiyati = satisFiyati;
	}
    
    @Column(name = "TUTAR", precision = 23, scale = 2)
    public BigDecimal getTutar() {
		return tutar;
	}
    
    public void setTutar(BigDecimal tutar) {
		this.tutar = tutar;
	}
    
	@Column(name = "ETKIN", precision = 1, scale = 0)
    public void setEtkin(boolean etkin) {
		this.etkin = etkin;
	}
    
    public boolean isEtkin() {
		return etkin;
	}
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SATIS_TARIHI")
    public Date getSatisTarihi() {
		return satisTarihi;
	}
    
    public void setSatisTarihi(Date satisTarihi) {
		this.satisTarihi = satisTarihi;
	}
    
}
