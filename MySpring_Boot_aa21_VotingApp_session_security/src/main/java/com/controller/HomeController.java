package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String home(Model m,HttpSession session,HttpServletRequest request)
	{
		session = request.getSession(false);
		if(session != null)
		{
			if(session.getAttribute("voter") != null)
			{
				
				if(session.getAttribute("voter").equals("voter"))
				{
					session.setAttribute("msg", "Logout Successfully");	

				}
				session.setAttribute("voter","nvoter");
				session.setAttribute("present", "no");
			}	
			if(session.getAttribute("admin")!= null)
			{
				
				if( session.getAttribute("admin").equals("admin"))
				{
					session.setAttribute("msg", "Logout Successfully");	

				}
				session.setAttribute("admin","nadmin");
				session.setAttribute("present", "no");
			}
			m.addAttribute("title","Home");
			return "home";
		
		}
		else {
		
		m.addAttribute("title","Home");
		return "home";
		}
		
	}
	
	
	@GetMapping("/voterregistration")
	public String voterregistration(Model m)
	{
		
		m.addAttribute("title","Voter Registration");
		return "voterregistration";
	}
	
	
	
	@GetMapping("/voterlogin")
	public String voterlogin(Model m,HttpSession session)
	{
		
		
			session.setAttribute("voter","nvoter");
	
		
		session.setAttribute("present", "yes");
		m.addAttribute("title","Voter Login");
		
		System.out.println(session.getAttribute("voter"));
	
		return "voterlogin";
		
	}
	
	

	@GetMapping("/adminlogin")
	public String adminlogin(Model m,HttpSession session)
	{
		
		
		
			session.setAttribute("admin","nadmin");
		
		
		
		session.setAttribute("present", "yes");
		m.addAttribute("title","Admin Login");
		
		
		return "adminlogin";
		
	}
	
	
	
	
	
	
	

}
