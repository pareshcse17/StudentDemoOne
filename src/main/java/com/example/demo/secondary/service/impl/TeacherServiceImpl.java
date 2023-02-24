package com.example.demo.secondary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.secondary.pojo.Teacher;
import com.example.demo.secondary.repo.TeacherRepository;
import com.example.demo.secondary.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	public TeacherServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Teacher> findAllTeachers() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}

	@Override
	public List<Teacher> findTeachersByName(String name) {
		// TODO Auto-generated method stub
		return teacherRepository.findTeachersByName(name);
	}

	@Override
	public List<Teacher> findTeacherByTeacherId(String teacherId) {
		// TODO Auto-generated method stub
		return teacherRepository.findTeachersByTeacherId(teacherId);
		
	}
	
	

}
