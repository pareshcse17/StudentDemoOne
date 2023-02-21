package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojo.StudentBasicDetails;
import com.example.demo.repo.StudentBasicDetailsRepo;

@Service
public class StudentBasicDetailsServiceIMPL implements StudentBasicDetailsService {

	@Autowired
	private StudentBasicDetailsRepo studentBasicDetailsRepo;
	
	
	@Override
	@Transactional
	public StudentBasicDetails findStudentByRollNoService(String rollNo) {
		// TODO Auto-generated method stub
		return studentBasicDetailsRepo.findStudentByRollNo(rollNo);
	}

	@Override
	@Transactional
	public List<StudentBasicDetails> findStudentByNameService(String name) {
		// TODO Auto-generated method stub
		return studentBasicDetailsRepo.findStudentByName(name);
	}

	@Override
	@Transactional
	public List<StudentBasicDetails> findAllStudentsService() {
		// TODO Auto-generated method stub
		return studentBasicDetailsRepo.findAll();
	}

}
