package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.User;
import com.services.UserService;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	

	// get all users
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getall")
	public List<User> getAllUsers()
	{
	
		return userService.getAllUsers();
	}
	
	// return single user
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username)
	{
		return userService.getUser(username);
	}
	
	// add user
//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
}