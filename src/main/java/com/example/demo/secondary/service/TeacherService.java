package com.example.demo.secondary.service;

import java.util.List;

import com.example.demo.secondary.pojo.Teacher;

public interface TeacherService {

	public List<Teacher> findAllTeachers();
	public List<Teacher> findTeachersByName(String name);
	public List<Teacher> findTeacherByTeacherId(String teacherId);
	
}
