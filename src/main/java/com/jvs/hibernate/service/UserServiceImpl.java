package com.jvs.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvs.hibernate.dao.UserDao;
import com.jvs.hibernate.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public User findByUserName(String userName) {		
		return userDao.findByName(userName);
	}

	@Override
	@Transactional
	public List<User> loadAllUsers() {
		return userDao.findAll(User.class);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public User findUserById(Long id) {
		return userDao.findByID(User.class, id);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		userDao.delete(user);
	}

}
