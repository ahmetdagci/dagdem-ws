package com.tr.dagdem.service.user;

import com.tr.dagdem.model.user.KullaniciTable;

public interface UserService {

	public KullaniciTable kullaniciSorgula(String kullanici, String password);
	
}
