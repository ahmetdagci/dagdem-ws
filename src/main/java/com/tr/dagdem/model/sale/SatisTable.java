package com.tr.dagdem.model.sale;

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

@Entity
@Table(name = "SATIS_TABLE",catalog = "satistakip")
public class SatisTable {

	private long id;
	private long saticiKodu;
	private long urunKodu;
	private long adet;
	private Date satisTarihi;
	
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
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SATIS_TARIH")
    public Date getSatisTarihi() {
		return satisTarihi;
	}
    
    public void setSatisTarihi(Date satisTarihi) {
		this.satisTarihi = satisTarihi;
	}
    
}
