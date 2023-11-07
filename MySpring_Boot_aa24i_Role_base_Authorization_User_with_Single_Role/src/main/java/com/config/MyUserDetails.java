package com.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.model.User;


public class MyUserDetails implements UserDetails{

	private User user;
	private String rolestr;
	
	
	public MyUserDetails(User user,String rolestr)
	{
		this.user = user;
		this.rolestr = rolestr;
	}
	
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
	
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	
			authorities.add(new SimpleGrantedAuthority(rolestr));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return user.isEnabled();
	}

}
