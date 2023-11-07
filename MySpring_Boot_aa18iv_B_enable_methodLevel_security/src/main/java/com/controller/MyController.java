package com.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
	
	/*
	 Now try to view page
	 Open Postman app 
	 use GET method 
	 use url:  http://localhost:8080/welcome
	 
	 
	 and in Authorization provide username: admin and password: admin
	 other username and password will not work 
	 because we only have given admin to access this handler
	 
	
	
	*/
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/welcome")
	public String welcome() {
		
		
		return "Welcome Admin";
		
		
	}

}
