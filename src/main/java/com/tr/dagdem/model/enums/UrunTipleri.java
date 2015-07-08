package com.tr.dagdem.model.enums;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

public enum UrunTipleri {

	CAY("CAY","Çay"),
	KAHVE("KAHVE","Kahve"),
	ORALET("ORALET","Oralet"),
	OYUN_KAGIDI("OYUNKAGIDI","Oyun Kağıdı"),
	SEKER("SEKER","Şeker"),
	SUTTOZU("SUTDOZU","Süt Tozu"),
	KOLA("KOLA","Kola"),
	MEYVESUYU("MEYVESUYU","Meyve Suyu"),
	SODA("SODA","Soda"),
	DIGER("DIGER","Diğer");
	
	private static final Map<String, UrunTipleri> map = Maps.newHashMap();
	
	static{
		for(UrunTipleri urunTipi :  UrunTipleri.values()){
			map.put(urunTipi.getUrunTipi(), urunTipi);
		}
	}
	
	private final String urunTipi;
	private final String aciklama;
	
	private UrunTipleri(String urunTipi,String aciklama) 
	{
		this.urunTipi = urunTipi;
		this.aciklama = aciklama;
	}
	
	public static UrunTipleri urunAdiylaUrunBul(String isim){
		return map.get(isim);
	}
	
	public static List<UrunTipleri> urunTipleri(){
		return ImmutableList.of(
				UrunTipleri.CAY,
				UrunTipleri.KAHVE,
				UrunTipleri.SEKER,
				UrunTipleri.KOLA,
				UrunTipleri.ORALET,
				UrunTipleri.SODA,
				UrunTipleri.MEYVESUYU,
				UrunTipleri.SUTTOZU,
				UrunTipleri.OYUN_KAGIDI,
				UrunTipleri.DIGER);
	}

	public String getUrunTipi() {
		return urunTipi;
	}
	public String getAciklama() {
		return aciklama;
	}
}