package com.jvs.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

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
	public void save(T entity) {
		session().saveOrUpdate(entity);
	}

	@Override
	public void merge(T entity) {
		session().merge(entity);
	}

	@Override
	public void delete(T entity) {
		session().delete(entity);
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
	public List<T> findAll(Class<T> clazz) {
		Query query = session().createQuery("FROM " + clazz.getName());
        return query.list();       
	}

	@Override
	@SuppressWarnings(value = { "unchecked" })
	public T findByID(Class<T> clazz, Long id) {		
        return (T) session().get(clazz, id);
	}

}
