package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Voters;
import com.service.VotersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class VotersController {
	
	@Autowired
	private VotersService vtrserv;
	
	

	// handler for inserting
			@PostMapping("/addvoters")
			public String addvoters(@ModelAttribute Voters vtr,Model model,HttpSession session)
			{
				
				String email = vtr.getEmail();
				System.out.println(email);
				
				int i= 0;
				List<Voters> listv = vtrserv.getAllVoters();
				for(Voters v : listv)
				{
					if(v.getEmail().equals(email))
					{
						i++;
					}
				}
				if(i >= 1)
				{
					session.setAttribute("msg","Registration Failed,Please try different email id");
					return "voterregistration";
				}
				
					 vtrserv.addVoters(vtr);
					
					session.setAttribute("msg","Registration Successful...");
					
					return "voterregistration";
						
			}
			
			@PostMapping("/voterhome")
			public String checkvlogin(@ModelAttribute Voters vt,Model m,HttpSession session)
			{
				if(session.getAttribute("present").equals("yes"))
				{
					
					session.setAttribute("present","no");	
				String email = vt.getEmail();
				String password = vt.getPassword();
				
				
				if(vtrserv.getVotersByEmail(email) == null)
				{

					session.setAttribute("msg","Login failed! Please enter correct EmailId or Password...");
					
					return "redirect:/voterlogin";

				}
				else if(vtrserv.getVotersByEmail(email) != null)
				{
					Voters v = vtrserv.getVotersByEmail(email);
					if(!v.getPassword().equals(password))
					{
						session.setAttribute("msg","Login failed! Please enter correct EmailId or Password...");
						
						return "redirect:/voterlogin";

					}
					else
					{
						Voters vtr = vtrserv.getVotersByEmail(email);
					
					m.addAttribute("vtr",vtr);
					session.setAttribute("msg","Welcome");
					session.setAttribute("voter", "voter");
					m.addAttribute("title","Voter Home");
					return "voterhome";
					}
				
				}
				
				}
				
				else if(session.getAttribute("present").equals("no") && session.getAttribute("voter").equals("voter"))
				{
					String email = vt.getEmail();
		
							Voters vtr = vtrserv.getVotersByEmail(email);
							System.out.println(vtr);
						
						m.addAttribute("vtr",vtr);
						session.setAttribute("msg","Welcome");
						m.addAttribute("title","Voter Home");
						return "voterhome";
					
					
					
				}
				else if(session.getAttribute("present").equals("no") && session.getAttribute("voter").equals("nvoter"))
				{
					System.out.println("ccc");
					session.setAttribute("msg", "Login first");
					return "redirect:/voterlogin";

				}
				
				
				
				return "redirect:/voterlogin";
						
			
			}
			
			
			
			
			
			
			
}
