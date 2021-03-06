package com.jvs.hibernate.dao;

import com.jvs.hibernate.entity.User;

public interface UserDao extends BaseDao<User, Long> {

	public User findByName(String userName);

}
