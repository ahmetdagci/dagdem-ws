package com.tr.dagdem.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.stat.SecondLevelCacheStatistics;

public abstract class GenericDAOImpl {
   
	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	protected DetachedCriteria createDetachedCriteria(Class clazz) {
		return DetachedCriteria.forClass(clazz);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class clazz) {
		DetachedCriteria criteria = createDetachedCriteria(clazz);
		return criteria.getExecutableCriteria(getSession()).list();
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findByExample(T example, Class clazz){
		Example _example = Example.create(example);		
		return getSession().createCriteria(clazz).add(_example).list();				
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAllByProperty(Class clazz, String propertyName, Object value) {
		DetachedCriteria criteria = createDetachedCriteria(clazz);
		criteria.add(Restrictions.eq(propertyName, value));
		return criteria.getExecutableCriteria(getSession()).list();
	}

	@SuppressWarnings("unchecked")
	public <T,PK extends Serializable> T findById(Class type, PK id) {
		return (T) getSession().get(type, id);
	}

	@SuppressWarnings("unchecked")
	public <T,PK> PK save(T newInstance) {	
		return (PK) getSession().save(newInstance);
	}

	public <T> void saveOrUpdate(T transientObject) {
		getSession().saveOrUpdate(transientObject);		
	}

	public <T> void update(T transientObject) {		
		getSession().update(transientObject);
	}
	
	public <T> void reattachUsingLock(T transientObject) {
		getSession().lock(transientObject, LockMode.NONE);		
	}
	
	public void flushSessionChanges(){
		getSession().flush();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T merge(T transientObject){
		transientObject = (T)getSession().merge(transientObject);
		return transientObject;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findByProperty(Class clazz, String propertyName, Object value) {
		DetachedCriteria criteria = createDetachedCriteria(clazz);
		criteria.add(Restrictions.eq(propertyName, value));
		return (T) criteria.getExecutableCriteria(getSession()).uniqueResult();
	}
	
}
