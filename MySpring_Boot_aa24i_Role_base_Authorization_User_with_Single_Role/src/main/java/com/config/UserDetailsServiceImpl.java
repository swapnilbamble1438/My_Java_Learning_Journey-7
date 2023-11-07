package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.model.Role;
import com.model.User;
import com.model.Users_roles;
import com.repository.UserRepository;
import com.service.RoleService;
import com.service.Users_rolesService;

public class UserDetailsServiceImpl implements UserDetailsService{

	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService  roleServcie;
	
	@Autowired
	private Users_rolesService users_rolesService;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.getUserByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("Could not found User");
		}
		
		
		Users_roles users_roles = users_rolesService.getUsers_rolesByUid(user.getId());
		Role role = roleServcie.getRoleById(users_roles.getRole_id());
		String rolestr = role.getName();	
		
		
		return new  MyUserDetails(user,rolestr);
	}

}
