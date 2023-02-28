package com.example.demo.primary.service;

import java.util.List;

import com.example.demo.primary.pojo.StudentBasicDetails;

public interface StudentBasicDetailsService {
	
	StudentBasicDetails findStudentByRollNoService(String roll_no);
	
	List<StudentBasicDetails> findStudentByNameService(String name);
	
	List<StudentBasicDetails> findStudentByTeacherIdService(String teacherId);
	
	List<StudentBasicDetails> findAllStudentsService();
	

}
