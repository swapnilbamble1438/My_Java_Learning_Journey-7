package com.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Candidate;
import com.service.CandidateService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CandidateService cndServ;
	
	@RequestMapping("/")
	public String dashboard(Model m,Principal p)
	{
		
		// view total number of votes
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;

		List<Candidate> listc = cndServ.getAllCandidates();
		for (Candidate v : listc) {
			if (!v.getCandidate1().equals(""))
				c1++;
			if (!v.getCandidate2().equals(""))
				c2++;
			if (!v.getCandidate3().equals(""))
				c3++;
			if (!v.getCandidate4().equals(""))
				c4++;
		}

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);

		m.addAttribute("c1", c1);
		m.addAttribute("c2", c2);
		m.addAttribute("c3", c3);
		m.addAttribute("c4", c4);
		
		
		return "admin/dashboard";
	}
}
