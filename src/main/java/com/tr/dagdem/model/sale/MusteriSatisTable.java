package com.tr.dagdem.model.sale;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "MUSTERI_SATIS_TABLE")
@AssociationOverrides({
		@AssociationOverride(name = "pk.urun",joinColumns = @JoinColumn(name = "URUN_KODU")),
		@AssociationOverride(name = "pk.musteri",joinColumns = @JoinColumn(name = "MUSTERI_ID"))})
public class MusteriSatisTable implements Serializable{

	private long adet;
	private double satisFiyati;
	private Date satisTarihi;
	private BigDecimal tutar;
	private boolean etkin = true;
	
	@EmbeddedId
	private MusteriSatisTableId pk = new MusteriSatisTableId();
	
	public MusteriSatisTableId getPk() {
		return pk;
	}

	public void setPk(MusteriSatisTableId pk) {
		this.pk = pk;
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
    
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MusteriSatisTable that = (MusteriSatisTable) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	} 
    
}
