package com.springboot.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.studentmanagement.exception.InvalidEmailException;
import com.springboot.studentmanagement.pojo.StudentPOJO;
import com.springboot.studentmanagement.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public StudentPOJO addStudent(StudentPOJO pojo) throws InvalidEmailException {
		if (pojo.getEmail().contains("@")) {
			StudentPOJO student = repository.save(pojo);
			return student;
		}
		throw new InvalidEmailException(true, "Invalid email. ");
		
	}

	public StudentPOJO searchById(int id) {
		StudentPOJO pojo = repository.findById(id).orElse(null);
		return pojo;
	}
	
	public List<StudentPOJO> searchAll() {
		List<StudentPOJO> students = repository.findAll();
		return students;
	}

	public List<StudentPOJO> searchByName(String name) {
		List<StudentPOJO> students = repository.findByName(name);
		return students;
	}

	public List<StudentPOJO> searchByEmail(String email) {
		List<StudentPOJO> students = repository.findByEmail(email);
		return students;
	}

	public List<StudentPOJO> searchByAddress(String address) {
		List<StudentPOJO> students = repository.findByAddress(address);
		return students;
	}
	

}
