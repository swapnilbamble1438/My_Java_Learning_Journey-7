package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;
import com.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/")
	public String dashboard(Model m,Principal p)
	{
		String userName = p.getName(); // it will give the username(email) of person who is login		

		User user = userRepo.getUserByEmail(userName);
		
		m.addAttribute("user",user);
		
		return "user/dashboard";
	}

}
