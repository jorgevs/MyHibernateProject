package com.jvs.hibernate.dao;

import java.io.Serializable;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jvs.hibernate.entity.BaseEntityImpl;

public abstract class BaseDaoImpl<T extends BaseEntityImpl, I extends Serializable> implements BaseDao<T, I> {

	private static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);
	
	protected Class<T> entityClass;

	public BaseDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	
	@Autowired
	private SessionFactory sessionFactory; 
		
	protected Session session(){
		try{
			return this.sessionFactory.getCurrentSession();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	
	
	@Override
	@SuppressWarnings(value = { "unchecked" })
	public List<T> findAll() {
		logger.info("entityClass: " + this.entityClass);
		Query query = session().createQuery("FROM " + this.entityClass.getName());
        return query.list();       
	}
	
	@Override
	@SuppressWarnings(value = { "unchecked" })
	public List<T> findMany(Query query) {
		return (List<T>)query.list();
	}

	@Override
	@SuppressWarnings(value = { "unchecked" })
	public T findOne(Query query) {		
		return (T)query.uniqueResult();
	}	
	
	@Override
	@SuppressWarnings(value = { "unchecked" })
	public T findById(I id) {
        return (T)session().get(this.entityClass, id);
	}
	
	@Override
	public void save(T entity) {
		session().saveOrUpdate(entity);
	}

	@Override
	@SuppressWarnings(value = { "unchecked" })
	public T update(T entity) {
		return (T)session().merge(entity);
	}

	@Override
	public void delete(I id) {
		if (id == null) {
			return;
		}

		T entity = this.findById(id);
		if (entity == null) {
			return;
		}
		session().delete(entity);
	}

}
