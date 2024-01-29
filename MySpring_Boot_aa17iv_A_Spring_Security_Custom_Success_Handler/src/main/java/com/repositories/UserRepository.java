package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select v from User v where v.username = :username")
	public User getUserByUsername(@Param("username")String username);
	
	
	
}
