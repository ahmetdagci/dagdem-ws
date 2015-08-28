package com.tr.dagdem.model.company;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


@SuppressWarnings("serial")
@Entity
@Table(name = "FIRMA_TANIM_TABLE")
public class FirmaTanimTable implements Serializable{

	private long id;
	private String firmaAdi;
	private String adres;
	private Long gsm;
	private Date tarih;
	private String email;
	
	@Id
    @Column(name = "FIRMA_ID", unique = true, nullable = false, precision = 23, scale = 0)
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
    
    @Column(name = "FIRMA_ADI", length = 200)
	@Max(200)
    public String getFirmaAdi() {
		return firmaAdi;
	}
    
    public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}
    
    @Column(name = "ADRES", length = 200)
    @Max(200)
    public String getAdres() {
		return adres;
	}
    
    public void setAdres(String adres) {
		this.adres = adres;
	}
    
	@Column(name = "EMAIL", length = 50)
	@Max(50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    @Column(name = "GSM", precision = 10, scale = 0)
    public Long getGsm() {
		return gsm;
	}
    
    public void setGsm(Long gsm) {
		this.gsm = gsm;
	}
    
    @Temporal(TemporalType.DATE)
	@Column(name = "TARIH")
    public Date getTarih() {
		return tarih;
	}

    public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
    
    public static String firmaAdiBul(List<FirmaTanimTable> firmalar,Long firmaId)
    {
    	for (FirmaTanimTable firma : firmalar) 
    	{
    		if(firmaId.equals(firma.getId())){
    			return firma.getFirmaAdi();
    		}
		}
    	return StringUtils.EMPTY;
    }

}
