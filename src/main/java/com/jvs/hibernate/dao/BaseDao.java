package com.jvs.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.jvs.hibernate.entity.BaseEntityImpl;

public interface BaseDao<T extends BaseEntityImpl, I extends Serializable> {

	public List<T> findAll();
	
	public List<T> findMany(Query query);
	
	public T findOne(Query query);
	
	public T findById(I id);	
		
	public void save(T entity);
	
	public T update(T entity);

	public void delete(I id);

}
