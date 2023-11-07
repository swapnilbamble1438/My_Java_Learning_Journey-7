package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Admin;
import com.model.Candidates;
import com.model.Voters;
import com.service.CandidatesService;
import com.service.VotersService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class VotersController {

	@Autowired
	private VotersService vtrserv;

	@Autowired
	private CandidatesService cndserv;

	// handler for inserting
	@PostMapping("/addvoters")
	public String addvoters(@ModelAttribute Voters vtr, Model model, HttpSession session) {

		String email = vtr.getEmail();
		System.out.println(email);

		int i = 0;
		List<Voters> listv = vtrserv.getAllVoters();
		for (Voters v : listv) {
			if (v.getEmail().equals(email)) {
				i++;
			}
		}
		if (i >= 1) {
			session.setAttribute("msg", "Registration Failed,Please try different email id");
			return "voterregistration";
		}

		vtrserv.addVoters(vtr);

		session.setAttribute("msg", "Registration Successful...");

		return "voterregistration";

	}

	@PostMapping("/voterhome")
	public String checkvlogin(@ModelAttribute Voters vt, Model m, HttpSession session) {
		String status = "Not Voted";
		if (session.getAttribute("present").equals("yes")) {

			session.setAttribute("present", "no");
			String email = vt.getEmail();
			String password = vt.getPassword();

			if (vtrserv.getVotersByEmail(email) == null) {

				session.setAttribute("msg", "Login failed! Please enter correct EmailId or Password...");

				return "redirect:/voterlogin";

			} else if (vtrserv.getVotersByEmail(email) != null) {
				Voters v = vtrserv.getVotersByEmail(email);
				if (!v.getPassword().equals(password)) {
					session.setAttribute("msg", "Login failed! Please enter correct EmailId or Password...");

					return "redirect:/voterlogin";

				} else {
					Voters vtr = vtrserv.getVotersByEmail(email);

					List<Candidates> list = cndserv.getAllCandidates();
					for (Candidates c : list) {
						if ((c.getCandidate1() != null && c.getCandidate1().equals(email))
								|| (c.getCandidate2() != null && c.getCandidate2().equals(email))
								|| (c.getCandidate3() != null && c.getCandidate3().equals(email))
								|| (c.getCandidate4() != null && c.getCandidate4().equals(email))) {
							status = "Voted";
						}

					}
					m.addAttribute("status", status);
					m.addAttribute("vtr", vtr);
					session.setAttribute("msg", "Welcome");
					session.setAttribute("voter", "voter");
					m.addAttribute("title", "Voter Home");
					return "voterhome";
				}

			}

		}

		else if (session.getAttribute("present").equals("no") && session.getAttribute("voter").equals("voter")) {
			String email = vt.getEmail();

			Voters vtr = vtrserv.getVotersByEmail(email);

			List<Candidates> list = cndserv.getAllCandidates();
			for (Candidates c : list) {
				if ((c.getCandidate1() != null && c.getCandidate1().equals(email))
						|| (c.getCandidate2() != null && c.getCandidate2().equals(email))
						|| (c.getCandidate3() != null && c.getCandidate3().equals(email))
						|| (c.getCandidate4() != null && c.getCandidate4().equals(email))) {
					status = "Voted";
				}

			}
			m.addAttribute("status", status);
			m.addAttribute("vtr", vtr);
			session.setAttribute("msg", "Welcome");
			m.addAttribute("title", "Voter Home");
			return "voterhome";

		} else if (session.getAttribute("present").equals("no") && session.getAttribute("voter").equals("nvoter")) {
			session.setAttribute("msg", "Login first");
			return "redirect:/voterlogin";

		}

		return "redirect:/voterlogin";

	}
	
	
	//=======================================================================
	
	// View Voters Page

	@GetMapping("/viewvoters")
	public String viewvoters(Model m,HttpSession session,HttpServletRequest request) {
		
		if (session != null) 
		{

			if (session.getAttribute("admin") != null) 
			{
				if (session.getAttribute("admin").equals("admin"))
				{
						
						List<Voters> vtr = vtrserv.getAllVoters();
						m.addAttribute("vtr", vtr);
				
						return "viewvoters";
						
				}
				else
				{
					session.setAttribute("msg", "Login first");
					return "adminlogin";
				}
				
				
			}
			
		}
		
		return "adminlogin";

	}

	// Edit Voter Page
	@GetMapping("/editvoter/{id}")
	public String editvoter(@PathVariable int id, Model m,HttpSession session,HttpServletRequest request) {
	
		if (session != null) 
		{

			if (session.getAttribute("admin") != null) 
			{
				if (session.getAttribute("admin").equals("admin"))
				{
		
		
					Voters vtr = vtrserv.getVotersById(id);
					m.addAttribute("vtr", vtr);
			
					return "editvoter";
					
				}
				else
				{
					session.setAttribute("msg", "Login first");
					return "adminlogin";
				}
				
				
			}
			
		}
		
		return "adminlogin";		
					
					
	}

	@PostMapping("/updatevoter")
	public String updatevoter(@ModelAttribute Voters vtr, HttpSession session) {
		vtrserv.addVoters(vtr);

		session.setAttribute("msg", "Voter Data updated successfully...");

		return "redirect:/viewvoters";
	}

	@GetMapping("/deletevoter/{id}")
	public String deleteemp(@PathVariable int id, HttpSession session) {
		vtrserv.deleteVoters(id);

		session.setAttribute("msg", "Voters deleted successfully...");

		return "redirect:/viewvoters";
	}

	
	
	
	

}
