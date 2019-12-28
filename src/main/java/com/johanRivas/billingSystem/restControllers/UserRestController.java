package com.johanRivas.billingSystem.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.johanRivas.billingSystem.models.entity.User;
import com.johanRivas.billingSystem.models.service.IUserService;

@Secured({ "ROLE_ADMIN" })
@RestController
public class UserRestController {

	@Autowired
	private IUserService userService;

	@GetMapping("/rest/users")
	public List<User> users() {
		return userService.getUsers();
	}

	@GetMapping("/rest/users/{id}")
	public User user(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}

}
