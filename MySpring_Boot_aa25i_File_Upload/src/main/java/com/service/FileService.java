package com.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface FileService {
	
	// method for uploading file 
	String uploadImage(String path,MultipartFile file) throws IOException;
	
	
	// method from reading or viewing file
	InputStream getResource(String path,String fileName) throws FileNotFoundException;
	

}
