package com.jvs.hibernate.service;

import java.util.List;

import com.jvs.hibernate.entity.User;

public interface UserService {

	public User findByUserName(String userName);

	public List<User> loadAllUsers();

	public void saveUser(User user);

	public User findUserById(Long id);

	public void deleteUser(User user);
}
