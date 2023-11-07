package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Users_roles;
import com.repository.Users_rolesRepository;

@Service
public class Users_rolesService {

	@Autowired
	private Users_rolesRepository users_rolesRepository;
	
	
	

	public void addUsers_roles(Users_roles users_roles) {
	
		users_rolesRepository.save(users_roles);
	}
	
	
	public Users_roles getUsers_rolesByUid(int user_id)
	{
		return users_rolesRepository.getById(user_id);
	}
	

	
}
