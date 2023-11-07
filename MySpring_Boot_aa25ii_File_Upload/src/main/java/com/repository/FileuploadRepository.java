package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Fileupload;

public interface FileuploadRepository extends JpaRepository<Fileupload,Integer> {

//	@Query("select u from Fileupload u where u.email = :email")
//	public Fileupload getByEmail(@Param("email")String email);
	
	
	
}


