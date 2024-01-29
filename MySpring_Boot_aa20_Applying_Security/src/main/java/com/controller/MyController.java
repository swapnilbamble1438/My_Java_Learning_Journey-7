package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MyController {
	
	
	
	

	@GetMapping("/")
	public String home(Model m)
	{
		
		m.addAttribute("title","Home");
		return "home";
	}
	
	
//	@PreAuthorize("hasRole('USER')")
	@GetMapping("/userhome")
	public String userhome(Model m)
	{
		
		m.addAttribute("title","User Home");

	
		return "userhome";
		
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/adminhome")
	public String adminhome(Model m)
	{
		
		m.addAttribute("title","Admin Home");

	
		return "adminhome";
		
	}
	
	@GetMapping("/about")
	public String about(Model m)
	{
		
		m.addAttribute("title","About");

	
		return "about";
		
	}
	
	@PostMapping("/loginfail")
	public String loginfail(Model m)
	{
		m.addAttribute("msg","Login Fail");
		return "home";
	}
	


}
