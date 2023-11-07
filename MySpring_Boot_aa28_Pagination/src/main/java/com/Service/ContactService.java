package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Repository.ContactRepository;
import com.model.Contact;


@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contRepo;

	public Page<Contact> getAllContacts(Pageable pageable)
	{
		return contRepo.getAllContacts(pageable);
	}
	
}
