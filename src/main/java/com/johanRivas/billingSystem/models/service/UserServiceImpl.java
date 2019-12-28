package com.johanRivas.billingSystem.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johanRivas.billingSystem.models.dao.IUserDao;
import com.johanRivas.billingSystem.models.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> getUsers() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public User getUserById(Long id) {
		return userDao.findById(id).orElse(null);
	}

}
