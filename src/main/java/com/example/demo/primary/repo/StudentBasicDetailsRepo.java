package com.example.demo.primary.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.primary.pojo.StudentBasicDetails;

public interface StudentBasicDetailsRepo extends MongoRepository<StudentBasicDetails, String> {
	
	StudentBasicDetails findStudentByRollNo(String rollNo);
	
	List<StudentBasicDetails> findStudentByName(String name);
	
	List<StudentBasicDetails> findStudentByTeacherId(String teacherId);
	
 }

