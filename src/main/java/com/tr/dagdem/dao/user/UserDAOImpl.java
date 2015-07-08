package com.tr.dagdem.dao.user;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tr.dagdem.dao.GenericDAOImpl;
import com.tr.dagdem.model.user.KullaniciTable;

@Repository
@Qualifier("userDAO")
public class UserDAOImpl extends GenericDAOImpl implements UserDAO{

	public KullaniciTable kullaniciSorgula(String kullanici, String password) 
	{
		return (KullaniciTable)getSession().createCriteria(KullaniciTable.class)
					.add(Restrictions.eq("kullanici", kullanici))
					.add(Restrictions.eq("password",password))
					.uniqueResult();
	}

	
}
