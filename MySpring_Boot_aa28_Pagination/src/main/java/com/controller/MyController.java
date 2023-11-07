package com.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Service.ContactService;
import com.model.Contact;


@Controller
public class MyController {
	
	@Autowired
	private ContactService contServ;
	
	
	@RequestMapping("/")
	public String dashboard(Model m,Principal p)
	{
		
		m.addAttribute("title","home");
		
		return "home";
	}
	
	// show contacts handler
		// per page = 3[n]
		// current page = 0[page]
		@GetMapping("/{page}")
		public String viewcontacts(@PathVariable("page") Integer page,Model m,Principal p,HttpSession session)
		{// here we have use page variable for pagination
			
			Pageable pageable = PageRequest.of(page, 3); // current page and contacts per page-3
			
			Page<Contact> contacts = contServ.getAllContacts(pageable);
			
			m.addAttribute("contacts",contacts);
			
			m.addAttribute("currentPage",page);
			
			m.addAttribute("totalPages",contacts.getTotalPages());
			
			m.addAttribute("title","View Contacts");
			return "viewcontacts";
		}
	

}
