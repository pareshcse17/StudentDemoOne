package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.StudentBasicDetails;

public interface StudentBasicDetailsService {
	
	StudentBasicDetails findStudentByRollNoService(String rollNo);
	
	List<StudentBasicDetails> findStudentByNameService(String name);
	
	List<StudentBasicDetails> findAllStudentsService();
	

}
