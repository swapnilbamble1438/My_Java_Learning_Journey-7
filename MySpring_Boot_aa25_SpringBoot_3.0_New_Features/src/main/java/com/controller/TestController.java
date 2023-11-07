package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtos.Student;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/just")
	public ResponseEntity<Student> testing()
	{
		
		
		
		var address="""
				Sadidham Building, Room No.1, 
				Thakurpada, Mumbra, District: Thane, 
				Pincode: 400612
				""";
		
		System.out.println(address);
		
		var student = new Student(1,"Swapnil",address);
		
		
		return ResponseEntity.ok(student);
	}

}
