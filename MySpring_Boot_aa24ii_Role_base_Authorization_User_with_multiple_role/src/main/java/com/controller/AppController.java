package com.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Role;
import com.model.Student;
import com.model.User;

import com.service.RoleService;
import com.service.StudentService;
import com.service.UserService;


@Controller
public class AppController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Student> list = studentService.getAllStudents();
		m.addAttribute("student",list);
		
		return "home";
	}
	
	@RequestMapping("/addstudent")
	public String addstudent(Model m)
	{
		Student student = new Student();
		m.addAttribute(student);
		return "addstudent";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savestudent(@ModelAttribute ("student") Student student)
	{
		studentService.addStudent(student);
		return "redirect:/";
	}
	
	@RequestMapping("edit/{sid}")
	public ModelAndView showeditstudentpage(@PathVariable (name ="sid") Long sid)
	{
		ModelAndView mav = new ModelAndView("editstudent");
		Student student = studentService.getStudent(sid);
		mav.addObject("student",student);
		return mav;
	}
	
	@RequestMapping("delete/{sid}")
	public String deletestudent(@PathVariable (name ="sid") Long sid)
	{
		studentService.delete(sid);
		
		return "redirect:/";
	}
	

	@RequestMapping("/adduser")
	public String adduser()
	{
	
	
		return "adduser";
	}
	
	@RequestMapping(value="/saveuser",method=RequestMethod.POST)
	public String saveuser(@ModelAttribute ("user") User user,
			@RequestParam(value ="role1",defaultValue = "empty") String role1,
			@RequestParam(value = "role2",defaultValue = "empty") String role2,
			@RequestParam(value = "role3",defaultValue = "empty") String role3,
			@RequestParam(value ="role4",defaultValue = "empty") String role4,
			Model m,HttpSession session)
	{
		
		if(userService.getUserByUsername(user.getUsername()) != null)
		{
			session.setAttribute("message","User already exists. try different username");
			return "redirect:/adduser";
		}
		
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		List<Role> role = new ArrayList<>();
		
		if(!role1.equals("empty"))
			role.add(roleService.getRoleByName(role1));
		if(!role2.equals("empty"))
			role.add(roleService.getRoleByName(role2));
		if(!role3.equals("empty"))
			role.add(roleService.getRoleByName(role3));
		if(!role4.equals("empty"))
			role.add(roleService.getRoleByName(role4));
		
		user.setRoles(role);
		
		userService.addUser(user);
		
		

		
		session.setAttribute("message","User successfully added");
		return "redirect:/adduser";
	}
	
	
	@RequestMapping("/signin")
	public String signin()
	{
		return "signin";
	}
	
	
	
	

}
