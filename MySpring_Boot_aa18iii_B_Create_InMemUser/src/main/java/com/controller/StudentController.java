package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;

@RestController
public class StudentController {

	/*
	 In Browser open
	 http://localhost:8080/
	then login screen will popup just put username as user
	and password will be availabe in console
	NOTE: if you have set username and password in
		  application.properties then use that 
		  username and password for loging
	
	then visit
	 http://localhost:8080/students
	 here u will get all students detail
	 
	 then for loging out try
	 http://localhost:8080/logout
	 
	 =====================================================
	 Now try in Postman app
	 
	 use GET method 
	 try url: http://localhost:8080/students
	 
	 Authorization-->Basic Auth ->   username: admin , password : admin
	 
	 and hit send button you will get the result
	
	 Note: Go to header--> hidden--> authorization--> copy all text after basic  
	 and try to decode it online by searching
	 decode from base64 format and after decoding
	 that code you will get your username and password.
	 
	 =====================================================
	 * setting different username and password 
	 * and removing username and password from application.properties
	 
	 Now you can use different username and password
	 for accessing data
	 
	 as we have set in our SecurityConfig our 
	 username and password we can also use that for 
	 accessing our data
	 
	 
	*/
	
	private List<Student> students = new ArrayList<>();
	
	@GetMapping("/students")
	public List<Student> students()
	{		
		Student student1 = new Student();
		student1.setId(1);
		student1.setFirstName("Swapnil");
		student1.setLastName("Bamble");
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setFirstName("Yash");
		student2.setLastName("More");
		
		students.add(student1);
		students.add(student2);
		
		return students;
	
		
	}
	
	@PostMapping("/students")
	public Student createStudent(Student student)
	{
		students.add(student);
		return student;
	}
	
	
	
	
}
