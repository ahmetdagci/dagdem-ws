package com.tr.dagdem.model.revenue;

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
@Table(name="TAHSILAT_TABLE")
public class TahsilatTable implements Serializable
{
	private long id;
	private long musteriKodu;
	private BigDecimal tutar;
	private Date tarih;
	private String kullanici;

	@Id
    @Column(name = "TAHSILAT_ID", unique = true, nullable = false, precision = 23, scale = 0)
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
    
    @Column(name = "MUSTERI_ID", nullable = false,precision = 23, scale = 0)
    public long getMusteriKodu() {
		return musteriKodu;
	}
    
    public void setMusteriKodu(long musteriKodu) {
		this.musteriKodu = musteriKodu;
	}
    
    @Column(name = "TUTAR", precision = 23, scale = 2)
    public BigDecimal getTutar() {
		return tutar;
	}
    
    public void setTutar(BigDecimal tutar) {
		this.tutar = tutar;
	}
    
    @Temporal(TemporalType.DATE)
	@Column(name = "TARIH", length = 7)
    public Date getTarih() {
		return tarih;
	}
    
    public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
    
       
    @Column(name = "KULLANICI", nullable = false, length = 12)
    @Max(12)
    public String getKullanici() {
		return kullanici;
	}
    
    public void setKullanici(String kullanici) {
		this.kullanici = kullanici;
	}
 
}
