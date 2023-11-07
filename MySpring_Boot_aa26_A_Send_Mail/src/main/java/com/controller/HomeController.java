package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Email;
import com.service.EmailService;

@Controller
public class HomeController {
	
	@Autowired
	private EmailService emailService;
	
	
	@GetMapping("/")
	public String home()
	{
		
		return "home";
	}
	
	@PostMapping("/sendemail")
	public String sendEmail(@ModelAttribute Email email,HttpSession session)
	{
		emailService.sendEmail(email);
		session.setAttribute("msg", "Email send successfully");
		
		return "home";
	}
	
	
	
	

}
