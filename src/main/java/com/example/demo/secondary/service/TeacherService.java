package com.example.demo.secondary.service;

import java.util.List;

import com.example.demo.secondary.pojo.Teacher;

public interface TeacherService {

	public List<Teacher> findAllTeachersService();
	public List<Teacher> findTeachersByNameService(String name);
	public Teacher findTeacherByTeacherIDService(String teacherID);
	
}
