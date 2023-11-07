package com.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.model.Fileupload;
import com.service.FileuploadService;


@Controller
public class MyController {
	
	@Autowired
	private FileuploadService fuserv;
	
	@GetMapping("/")
	public String addcontact(Model m,Principal p)
	{
		
		
		return "/uploadfile";
	}
	
	// processing addcontact
	@PostMapping("/processuplodfile")
	public String processcontact(@ModelAttribute("fu") Fileupload fu,
			BindingResult br,Principal p,
			HttpSession session,
			@RequestParam("image") MultipartFile file) // after adding BindingResult we will get the String from cimage field														// always put BindingResult next to @ModelAttribute  
	{	
		
		try 
		{
		
		
		if(file.isEmpty())
		{
			//if the file is empty then try our message
			System.out.println("File is empty");
		}
		else {
			// upload the file to folder and save the name to contact table
			fu.setImage(file.getOriginalFilename());
			
			 File saveFile = new ClassPathResource("static/image").getFile();
		
			Path path = Paths.get(saveFile.getAbsolutePath()+ File.separator+file.getOriginalFilename());
			 
			 Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			 
			 System.out.println("Image is uploaded successfully");
		}
		
		
		fuserv.addFiledata(fu);
		
		session.setAttribute("message","File uploaded successfully");
		
		
		}catch(Exception e){
			
			System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
			
			session.setAttribute("message","Something went wrong");

		}
		
		
		return "redirect:/";
	}
		
		
		

}
