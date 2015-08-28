package com.tr.dagdem.model.company;

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

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "FIRMA_ODEME_TABLE")
public class FirmaOdemeTable implements Serializable{

	private long id;
	private BigDecimal odemeTutari;
	private long firmaKodu;
	private Date odemeTarihi;
	private String odemeYapanKisi;
	
	
	@Id
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
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
    
    @Column(name = "ODEME_TUTARI", precision = 23, scale = 2)
    public BigDecimal getOdemeTutari() {
		return odemeTutari;
	}
    
    public void setOdemeTutari(BigDecimal odemeTutari) {
		this.odemeTutari = odemeTutari;
	}
    
    @Column(name = "FIRMA_KODU", precision = 23, scale = 0)
    public long getFirmaKodu() {
		return firmaKodu;
	}
    
    public void setFirmaKodu(long firmaKodu) {
		this.firmaKodu = firmaKodu;
	}
    
    @Column(name = "ODEME_YAPAN_KISI", length = 100)
	@Max(100)
    public String getOdemeYapanKisi() {
		return odemeYapanKisi;
	}
    
    public void setOdemeYapanKisi(String odemeYapanKisi) {
		this.odemeYapanKisi = odemeYapanKisi;
	}
        
    @Temporal(TemporalType.DATE)
	@Column(name = "ODEME_TARIHI")
    public Date getOdemeTarihi() {
		return odemeTarihi;
	}

    public void setOdemeTarihi(Date odemeTarihi) {
		this.odemeTarihi = odemeTarihi;
	}

}
