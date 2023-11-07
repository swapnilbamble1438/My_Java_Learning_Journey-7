package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void addUser(User user)
	{
		userRepository.save(user);
	}
	
	public List<User> getAllUsers()
	{
		return (List<User>) userRepository.findAll();
		
		
	}
	
	public User getUser(int id)
	{
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		return null;
	}
	
	public void delete(Integer id)
	{
		userRepository.deleteById(id);
	}
	
	public User getUserByUsername(String username)
	{
		return userRepository.getUserByUsername(username);
		
	}

}
