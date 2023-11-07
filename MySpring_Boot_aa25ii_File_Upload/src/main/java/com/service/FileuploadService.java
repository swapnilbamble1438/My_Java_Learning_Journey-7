package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Fileupload;
import com.repository.FileuploadRepository;

@Service
public class FileuploadService {
	
	@Autowired
	private FileuploadRepository repo;
	
	public void addFiledata(Fileupload fu)
	{
		repo.save(fu);
	}
	

}
