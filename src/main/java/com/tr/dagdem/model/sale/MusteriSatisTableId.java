package com.tr.dagdem.model.sale;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.tr.dagdem.model.customer.MusteriTanimTable;
import com.tr.dagdem.model.product.UrunTanimTable;

@Embeddable
public class MusteriSatisTableId implements java.io.Serializable {
	
	@ManyToOne(cascade=CascadeType.ALL,fetch= FetchType.LAZY)
	private MusteriTanimTable musteri;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch= FetchType.LAZY)
	private UrunTanimTable urun;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	private KullaniciTable kullanici;

	public MusteriTanimTable getMusteri() {
		return musteri;
	}

	public void setMusteri(MusteriTanimTable musteri) {
		this.musteri = musteri;
	}

	public UrunTanimTable getUrun() {
		return urun;
	}

	public void setUrun(UrunTanimTable urun) {
		this.urun = urun;
	}
	
//	public KullaniciTable getKullanici() {
//		return kullanici;
//	}
//	
//	public void setKullanici(KullaniciTable kullanici) {
//		this.kullanici = kullanici;
//	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusteriSatisTableId that = (MusteriSatisTableId) o;

        if (musteri != null ? !musteri.equals(that.musteri) : that.musteri != null) return false;
        if (urun != null ? !urun.equals(that.urun) : that.urun != null) return false;
//        if (kullanici != null ? !kullanici.equals(that.kullanici) : that.kullanici != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (musteri != null ? musteri.hashCode() : 0);
        result = 31 * result + (urun != null ? urun.hashCode() : 0);
//        result = 31 * result + (kullanici != null ? kullanici.hashCode() : 0);
        return result;
    }
}