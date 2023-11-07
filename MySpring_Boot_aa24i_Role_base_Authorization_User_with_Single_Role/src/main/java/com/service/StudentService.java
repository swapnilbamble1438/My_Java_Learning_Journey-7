package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Student;
import com.repository.StudentRepository;

@Service
public class StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public void addStudent(Student student)
	{
		studentRepository.save(student);
	}
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public Student getStudent(Long id)
	{
		return studentRepository.getById(id);
	}
	
	public void delete(Long id)
	{
		studentRepository.deleteById(id);
	}

}
