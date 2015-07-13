package com.tr.dagdem.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tr.dagdem.dao.GenericDAO;
import com.tr.dagdem.dao.user.UserDAO;
import com.tr.dagdem.model.user.KullaniciTable;
import com.tr.dagdem.service.BaseServisImpl;

@Service
@Qualifier("userService")
public class UserServiceImpl extends BaseServisImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public KullaniciTable kullaniciSorgula(String kullanici, String password) 
	{
		return userDAO.kullaniciSorgula(kullanici, password);
	}
	
	@Override
	protected GenericDAO getDAO() 
	{
		return userDAO;
	}
	
}
