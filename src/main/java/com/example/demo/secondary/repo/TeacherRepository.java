package com.example.demo.secondary.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.secondary.pojo.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher, String>{
	
	public List<Teacher> findTeachersByName(String name);
	public Teacher findTeachersByTeacherID(String teacherID);

}
