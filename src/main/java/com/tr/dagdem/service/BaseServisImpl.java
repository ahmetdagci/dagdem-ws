package com.tr.dagdem.service;

import com.tr.dagdem.dao.GenericDAO;


public abstract class BaseServisImpl {

	protected abstract GenericDAO getDAO();
	
	public <T> void reattachUsingLock(T detachedEntity) {
		getDAO().reattachUsingLock(detachedEntity);	
	}
	
	public <T> void reattachReadOnly(T detachedEntity){
		getDAO().reattachUsingLock(detachedEntity);
		getDAO().getSession().setReadOnly(detachedEntity, true);
	}

    public <T> void reattachUsingSaveOrUpdate(T detachedEntity)
    {
        getDAO().getSession().saveOrUpdate(detachedEntity);
    }
	
}
