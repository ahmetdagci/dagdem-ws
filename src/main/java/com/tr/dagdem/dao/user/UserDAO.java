package com.tr.dagdem.dao.user;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.model.user.KullaniciTable;

public interface UserDAO extends GenericDAO{
	
	public KullaniciTable kullaniciSorgula(String kullanici,String password);
	
}
