package com.tr.dagdem.model.customer;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Sets;
import com.tr.dagdem.model.sale.MusteriSatisTable;

@SuppressWarnings("serial")
@Entity
@Table(name="MUSTERI_TANIM_TABLE")
public class MusteriTanimTable implements Serializable{
	
	private long id;
	private String musteriAdi;
	private String musteriSoyadi;
	private String musteriAdres;
	private String email;
	private boolean aktif;
	private Long gsm;
	private Date tarih;
	private Date guncellemeTarihi;
	private boolean yeniMusteri = false;
	private String musteriNo;
	
	
	private Set<MusteriSatisTable> musteriyeYapilanSatislar = Sets.newHashSet();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="pk.musteri")
	public Set<MusteriSatisTable> getMusteriyeYapilanSatislar() {
		return musteriyeYapilanSatislar;
	}

	public void setMusteriyeYapilanSatislar(Set<MusteriSatisTable> musteriyeYapilanSatislar) {
		this.musteriyeYapilanSatislar = musteriyeYapilanSatislar;
	}

	@Id
    @Column(name = "MUSTERI_ID", unique = true, nullable = false, precision = 23, scale = 0)
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
    
	@Column(name = "MUSTERI_ADI", length = 100)
	@Length(max=100)
	public String getMusteriAdi() {
		return this.musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}
	
    @Column(name = "MUSTERI_SOYADI", length = 100)
    @Length(max=100)
    public String getMusteriSoyadi()
    {
        return this.musteriSoyadi;
    }

    public void setMusteriSoyadi(String musteriSoyadi)
    {
        this.musteriSoyadi = musteriSoyadi;
    }

	@Column(name = "EMAIL", length = 50)
	@Length(max=50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "GSM", precision = 10, scale = 0)
	public Long getGsm() {
		return this.gsm;
	}

	public void setGsm(Long gsm) {
		this.gsm = gsm;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TARIH", length = 7)
	public Date getTarih() {
		return this.tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "GUNCELLEME_TARIHI", length = 7)
	public Date getGuncellemeTarihi() {
		return this.guncellemeTarihi;
	}

	public void setGuncellemeTarihi(Date guncellemeTarihi) {
		this.guncellemeTarihi = guncellemeTarihi;
	}
	
	@Column(name="AKTIF")
	public boolean isAktif() {
		return aktif;
	}
	
	public void setAktif(boolean aktif) {
		this.aktif = aktif;
	}
	
	@Column(name = "MUSTERI_ADRES", length = 250)
	@Length(max=250)
	public String getMusteriAdres() {
		return musteriAdres;
	}
	
	public void setMusteriAdres(String musteriAdres) {
		this.musteriAdres = musteriAdres;
	}
	
	@Transient
	public String getMusteriAdiSoyadi()
	{
		return StringUtils.join(new Object[]{this.getMusteriAdi()," ",this.getMusteriSoyadi()}).toUpperCase();
	}
	
	@Transient
	public String getMusteriNo() {
		return musteriNo;
	}
	
	public void setMusteriNo(String musteriNo) {
		this.musteriNo = musteriNo;
	}
	
	@Transient
	public boolean isYeniMusteri() {
		return yeniMusteri;
	}
	
	public void setYeniMusteri(boolean yeniMusteri) {
		this.yeniMusteri = yeniMusteri;
	}
	
}
