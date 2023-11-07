package com.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

	
	// pagination
	@Query("select c from Contact c") 
	public Page<Contact> getAllContacts(Pageable pageable);
	// Pageable object contains
	// two values
	//currentPage - page
	//contact per page - 3
	
	
}
