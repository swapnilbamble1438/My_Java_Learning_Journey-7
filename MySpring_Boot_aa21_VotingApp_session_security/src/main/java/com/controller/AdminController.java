package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Admin;
import com.model.Candidates;
import com.service.AdminService;
import com.service.CandidatesService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	private AdminService admserv;

	@Autowired
	private CandidatesService cndserv;

	@GetMapping("/adminhome")
	public String adminhome(@ModelAttribute Admin adm, Model m, HttpSession session, HttpServletRequest request) {
		session = request.getSession(false);

		if (session != null) {

			if (session.getAttribute("present") != null) {

				if (session.getAttribute("present").equals("yes")) {

					session.setAttribute("present", "no");

					String name = adm.getName();
					String password = adm.getPassword();

					if (adm.getName() == null || adm.getPassword() == null) {
						session.setAttribute("msg", "Login first");
						return "redirect:/adminlogin";
					}
					
					if(!name.equals("admin") || !password.equals("admin"))
					{
						
							if (admserv.getAdminByName(name) == null ) {
								session.setAttribute("msg", "Login failed! Please enter correct User Name or Password...");

								return "redirect:/adminlogin";
							} else if (admserv.getAdminByName(name) != null) {
								Admin a = admserv.getAdminByName(name);
								if (!a.getPassword().equals(password)) {
									session.setAttribute("msg", "Login failed! Please enter correct Username or Password...");

									return "redirect:/adminlogin";
								}

						}
					  
					}
					
						

							// view total number of votes
							int c1 = 0;
							int c2 = 0;
							int c3 = 0;
							int c4 = 0;

							List<Candidates> listc = cndserv.getAllCandidates();
							for (Candidates v : listc) {
								if (v.getCandidate1() != null)
									c1++;
								if (v.getCandidate2() != null)
									c2++;
								if (v.getCandidate3() != null)
									c3++;
								if (v.getCandidate4() != null)
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

							m.addAttribute("title", "Admin Home");
							session.setAttribute("admin", "admin");

							return "adminhome";
						
					
				}

				else if (session.getAttribute("present").equals("no")
						&& session.getAttribute("admin").equals("admin")) {

					session.setAttribute("present", "no");

					// view total number of votes
					int c1 = 0;
					int c2 = 0;
					int c3 = 0;
					int c4 = 0;

					List<Candidates> listc = cndserv.getAllCandidates();
					for (Candidates v : listc) {
						if (v.getCandidate1() != null)
							c1++;
						if (v.getCandidate2() != null)
							c2++;
						if (v.getCandidate3() != null)
							c3++;
						if (v.getCandidate4() != null)
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

					m.addAttribute("title", "Admin Home");
					session.setAttribute("admin", "admin");

					return "adminhome";

				}

				else if (session.getAttribute("present").equals("no")
						&& session.getAttribute("admin").equals("nadmin")) {
					session.setAttribute("msg", "Login first");
					return "redirect:/adminlogin";
				}

			

		} else {
			session.setAttribute("msg", "Login first");
			return "redirect:/adminlogin";
		}
		}

		return "redirect:/adminlogin";
	}
	
}
