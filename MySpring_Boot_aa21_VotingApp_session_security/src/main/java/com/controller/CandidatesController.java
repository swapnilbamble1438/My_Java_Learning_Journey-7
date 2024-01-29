package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Admin;
import com.model.Candidates;
import com.model.Voters;
import com.service.AdminService;
import com.service.CandidatesService;
import com.service.VotersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CandidatesController {
	
	
	@Autowired
	private CandidatesService cndserv;

	
	@Autowired
	private VotersService vtrserv;
	
	
	
	// handler for inserting
				@PostMapping("/addcandidates")
				public String addvoters(@RequestParam("candidate") String candidate,@RequestParam
						("email")String email,Model model,HttpSession session)
				{
					
					if(session.getAttribute("voter").equals("voter"))
					{
					System.out.println(email + " " + candidate);
					
					int i = 0;
					List<Candidates> list = cndserv.getAllCandidates();
					for(Candidates c : list)
					{
						if(c.getCandidate1() != null && c.getCandidate1().equals(email))
							i++;
						if(c.getCandidate2() != null && c.getCandidate2().equals(email))
							i++;
						if(c.getCandidate3() != null && c.getCandidate3().equals(email))
							i++;		
						if(c.getCandidate4() != null && c.getCandidate4().equals(email))
							i++;
						
						
					}
					if( i >= 1)
						{
						session.setAttribute("msg", "Already Voted");
						Voters vtr = vtrserv.getVotersByEmail(email);
						model.addAttribute("vtr",vtr);
						return "voterhome";
						}
					else {
					String candidate1 = null;
					String candidate2 = null;
					String candidate3 = null;
					String candidate4 = null;
					

					if(candidate.equals("candidate1"))
						 candidate1 = email;
					else if(candidate.equals("candidate2"))
					   candidate2 = email;
					else if(candidate.equals("candidate3"))
						candidate3 = email;
					else if(candidate.equals("candidate4"))
						candidate4 = email;
					
					Candidates cnd = new Candidates();
					cnd.setCandidate1(candidate1);
					cnd.setCandidate2(candidate2);
					cnd.setCandidate3(candidate3);
					cnd.setCandidate4(candidate4);
					
					cndserv.addCandidates(cnd);
					
						
						session.setAttribute("msg","Successfully Voted...");
						Voters vtr =	vtrserv.getVotersByEmail(email);
						model.addAttribute("vtr",vtr);
						return "voterhome";
					}	
					}
					else
					{
						session.setAttribute("msg", "Login first");
						return "redirect:/voterlogin";
					}
					
				}
				
	
	

}
