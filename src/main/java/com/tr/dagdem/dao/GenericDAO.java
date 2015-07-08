package com.tr.dagdem.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

/** 
 * bütün daolar için ortak olan işlemler
 * 
 * @author adagci
 * */
public interface GenericDAO {

	public <T, PK> PK save(T newInstance);
	
	public <T> void update(T transientObject);
	
	public <T> void saveOrUpdate(T transientObject);
	
	@SuppressWarnings("unchecked")
	public <T, PK extends Serializable> T findById(Class type, PK id);
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class clazz);
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findByExample(T example, Class clazz);
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAllByProperty(Class clazz, String propertyName, Object value);
	
	@SuppressWarnings("unchecked")
	public <T> T findByProperty(Class clazz, String propertyName, Object value);
	
	public <T> void reattachUsingLock(T transientObject);
	
	public void flushSessionChanges();
	
	public <T> T merge(T transientObject);
	
	public Session getSession();
	
}
