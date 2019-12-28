package com.johanRivas.billingSystem.models.service;

import java.util.List;

import com.johanRivas.billingSystem.models.entity.User;

public interface IUserService {

	public List<User> getUsers();

	public User getUserById(Long id);

	public void addUser(User user);

	public void deleteUser(Long id);
}
