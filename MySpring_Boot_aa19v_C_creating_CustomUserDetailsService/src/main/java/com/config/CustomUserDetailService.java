package com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ArrayList<GrantedAuthority> roles = new ArrayList<>() ;
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		roles.add(new SimpleGrantedAuthority("NORMAL"));

		return new User("swapnil","1234",roles);
		
		
		
	}

}
