package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{


	@Query("select a from Admin a where a.name = :name")
	public Admin getAdminByName(@Param("name")String name);
	
	
	
	
}
