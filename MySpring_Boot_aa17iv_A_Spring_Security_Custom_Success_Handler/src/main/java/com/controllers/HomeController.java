package com.controllers;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/public")
public class HomeController {
	
	@GetMapping("/home")
	public String home()
	{
		return "This is Home Page";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "This is Login Page";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "This is Register Page";
	}
	

}
