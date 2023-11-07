package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Users_roles;

public interface Users_rolesRepository extends JpaRepository<Users_roles, Integer> {


//	@Query("select u from Users_roles u where u.user_id = :user_id")
//	public Users_roles getUsers_rolesByUid(@Param("user_id") int user_id);
//	
//	
	
}


