package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.User;
import com.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userserv;

	@GetMapping("/")
	public String index()
	{
		return "home";
	}
	
	@GetMapping("/signin")
	public String login()
	{
		return "signin";
	}
	
	@GetMapping("/asignin")
	public String alogin()
	{
		return "asignin";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	
	@GetMapping("/about")
	public String about()
	{
		return "about";
	}

	
	@PostMapping("/createuser")
	public String createuser(@ModelAttribute User user,HttpSession session)
	{		
		
		String email = user.getEmail();
	
		
		int i= 0;
		User u = new User();
			if(userserv.getUserByEmail(email) != null)
			{
				i++;
			}
		
		if(i >= 1)
		{
			session.setAttribute("msg","Registration Failed,Please try different email id");
			return "redirect:/register";
		}
		
			user.setRole("ROLE_USER");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			 userserv.addUser(user);
			
			session.setAttribute("msg","Registration Successful...");
			
			return "redirect:/register";
		
		
	}
	
	
}

