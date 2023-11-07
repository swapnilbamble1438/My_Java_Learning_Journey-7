package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Voters;

public interface VotersRepository extends JpaRepository<Voters, Integer>{

	
	@Query("select v from Voters v where v.email = :email")
	public Voters getVotersByEmail(@Param("email")String email);
	
}
