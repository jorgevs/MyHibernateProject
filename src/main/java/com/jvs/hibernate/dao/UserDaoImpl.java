package com.jvs.hibernate.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jvs.hibernate.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {
	
	public UserDaoImpl() {
		super(User.class);
	}	
	
	@Override
	public User findByName(String userName)  {        
        Query query = session().createQuery("FROM User U WHERE U.userName =:userName");
        query.setParameter("userName", userName);
        return findOne(query);        
    }
	
}
