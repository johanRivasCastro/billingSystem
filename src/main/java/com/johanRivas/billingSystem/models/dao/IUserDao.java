package com.johanRivas.billingSystem.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johanRivas.billingSystem.models.entity.User;

@Repository
public interface IUserDao extends CrudRepository<User, Long> {

	@Query("select u from User u where u.username = ?1")
	public User findByUsername(String name);
}
