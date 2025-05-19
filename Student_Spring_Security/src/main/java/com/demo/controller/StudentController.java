package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;
import com.demo.repo.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@PostMapping("/register")
	public String register(@RequestBody Student student) {
		student.setPassword(encoder.encode(student.getPassword()));
		studentRepository.save(student);
		return "Student Added Successfully";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the student dashboard!";
	}
}
