package com.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.model.Student;
import com.demo.repo.StudentRepository;

@Service
public class StudentDetailsService implements UserDetailsService{
	@Autowired
	private StudentRepository sr;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Student student = sr.findByEmail(email);
		if(student == null) {
			throw new UsernameNotFoundException("Student not found");
		}
		return new User(student.getEmail(), student.getPassword(), new ArrayList());
	}

}
