package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.User;
import com.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	
	public UserService()
	{
		
	}
	
	// get all users
	public List<User> getAllUsers()
	{
		return userRepo.findAll();
	}
	
	//get single user
	public User getUser(String username)
	{
		return userRepo.getUserByUsername(username);
	}
	
	public User addUser(User user)
	{
	
		return userRepo.save(user);
	}
	

}
