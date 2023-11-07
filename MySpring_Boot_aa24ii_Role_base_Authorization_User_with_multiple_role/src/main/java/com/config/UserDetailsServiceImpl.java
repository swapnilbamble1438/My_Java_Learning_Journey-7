package com.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.model.User;
import com.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	
	
	@Autowired
	private UserRepository userRepository;
		
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.getUserByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("Could not found User");
		}
		
		
		
		return new  MyUserDetails(user);
	}

}
