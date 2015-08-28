package com.tr.dagdem.service.sale;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.tr.dagdem.model.customer.MusteriTanimTable;
import com.tr.dagdem.model.dealer.SaticiTanimTable;
import com.tr.dagdem.model.product.UrunIadeTable;
import com.tr.dagdem.model.product.UrunTanimTable;
import com.tr.dagdem.model.sale.MusteriSatisTable;
import com.tr.dagdem.model.sale.SatisTable;
import com.tr.dagdem.service.util.SatisTakipException;

@Component
@Qualifier("saleCreationHelper")
public class SaleCreationHelper {
	
	public Set<SatisTable> musteriSepetindenSatisOlustur(SaticiTanimTable satici,Date satisTarihi)
	{
		Set<SatisTable> satisTableSeti = new HashSet<SatisTable>(0);
		for(UrunTanimTable urun:satici.getSaticininUrunleri())
		{
			if(urun.getAdet()>0)
			{
				SatisTable satisTable = new SatisTable();
				satisTable.setSaticiKodu(satici.getId());
				satisTable.setUrunKodu(urun.getUrunKodu());
				satisTable.setAdet(urun.getAdet());
				satisTable.setSatisTarihi(satisTarihi);
				satisTableSeti.add(satisTable);
			}
		}
		return satisTableSeti;
	}
	
	public Set<MusteriSatisTable> musteriSepetindenSatisOlustur(SaticiTanimTable satici,MusteriTanimTable musteri,Date satisTarihi)
	{
		Set<MusteriSatisTable> musteriSatisTableSeti = new HashSet<MusteriSatisTable>(0);
		for(UrunTanimTable urun:satici.getSaticininUrunleri())
		{	
			if(urun.getTutar()==null)
			{
				throw new SatisTakipException(urun.getUrunAdi()+ ", isimli ürün için lütfen tutar giriniz");
			}
			
			if(urun.getAdet()>0)
			{	
//				MusteriSatisTable musteriSatisTable = new MusteriSatisTable();
//				musteriSatisTable.setMusteriKodu(musteri.getId());
//				musteriSatisTable.setSaticiKodu(satici.getId());
//				musteriSatisTable.setUrunKodu(urun.getUrunKodu());
//				musteriSatisTable.setAdet(urun.getAdet());
//				musteriSatisTable.setTutar(new BigDecimal(urun.getTutar()));
//				musteriSatisTable.setSatisTarihi(satisTarihi);
//				musteriSatisTableSeti.add(musteriSatisTable);
			}
		}
		return musteriSatisTableSeti;
	}
	
	
	public Set<UrunIadeTable> saticiIadeSepetindenIadeEdilecekUrunleriOlustur(SaticiTanimTable satici,MusteriTanimTable musteri,Date satisTarihi)
	{
		Set<UrunIadeTable> urunIadeTableSet = new HashSet<UrunIadeTable>(0);
		for(UrunTanimTable urun:satici.getSaticininIadeUrunleri())
		{	
			if(urun.getAdet()>0)
			{	
				UrunIadeTable urunIadeTable = new UrunIadeTable();
				urunIadeTable.setMusteriKodu(musteri.getId());
				urunIadeTable.setSaticiKodu(satici.getId());
				urunIadeTable.setUrunKodu(urun.getUrunKodu());
				urunIadeTable.setAdet(urun.getAdet());
				urunIadeTable.setIadeTarihi(satisTarihi);
				urunIadeTableSet.add(urunIadeTable);
			}
		}
		return urunIadeTableSet;
	}
}
