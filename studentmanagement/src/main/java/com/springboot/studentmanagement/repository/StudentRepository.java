package com.springboot.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.studentmanagement.pojo.StudentPOJO;

public interface StudentRepository extends JpaRepository<StudentPOJO, Integer>{

	
	List<StudentPOJO> findByName(String name);

	List<StudentPOJO> findByEmail(String email);

	List<StudentPOJO> findByAddress(String address);

}
