package com.example.demo.primary.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.primary.pojo.StudentBasicDetails;
import com.example.demo.primary.repo.StudentBasicDetailsRepo;
import com.example.demo.primary.service.StudentBasicDetailsService;
import com.example.demo.secondary.repo.TeacherRepository;

@Service
public class StudentBasicDetailsServiceIMPL implements StudentBasicDetailsService {

	final Logger log = LoggerFactory.getLogger(StudentBasicDetailsServiceIMPL.class);
	@Autowired
	private StudentBasicDetailsRepo studentBasicDetailsRepo;
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	@Transactional
	public StudentBasicDetails findStudentByRollNoService(String rollNo) {
		// TODO Auto-generated method stub
		log.debug("inside findStudentByRollNoService... ");
		try {
			StudentBasicDetails studentBasicDetails = studentBasicDetailsRepo.findStudentByRollNo(rollNo);
			studentBasicDetails.setTeacher(teacherRepository.findTeachersByTeacherID(studentBasicDetails.getTeacherId()));
			return studentBasicDetails;
		} catch (Exception e) {
			log.error("message " +  e.toString());
		}
		return null;
		
	}

	@Override
	@Transactional
	public List<StudentBasicDetails> findStudentByNameService(String name) {
		// TODO Auto-generated method stub
		log.debug("inside findStudentByNameService... ");
		try {
			List<StudentBasicDetails> studentBasicDetails = studentBasicDetailsRepo.findStudentByName(name);
			studentBasicDetails.stream().forEach(s -> {
				s.setTeacher(teacherRepository.findTeachersByTeacherID(s.getTeacherId()));
			});
			return studentBasicDetails;
		} catch (Exception e) {
			log.error("message " + e.toString());
		}
		return null;
	}

	@Override
	@Transactional
	public List<StudentBasicDetails> findAllStudentsService() {
		// TODO Auto-generated method stub
		log.debug("inside findAllStudentsService... ");
		try {
			List<StudentBasicDetails> studentBasicDetails = studentBasicDetailsRepo.findAll();
			studentBasicDetails.stream().forEach(s -> {
				s.setTeacher(teacherRepository.findTeachersByTeacherID(s.getTeacherId()));
			});
			return studentBasicDetails;
		} catch (Exception e) {
			log.error("message " + e.toString());
		}
		return null;
	}

	@Override
	public List<StudentBasicDetails> findStudentByTeacherIdService(String teacherId) {
		// TODO Auto-generated method stub
		log.debug("inside findStudentByTeacherIdService... ");
		try {
			List<StudentBasicDetails> studentBasicDetails = studentBasicDetailsRepo.findStudentByTeacherId(teacherId);
			studentBasicDetails.stream().forEach(s -> {
				s.setTeacher(teacherRepository.findTeachersByTeacherID(s.getTeacherId()));
			});
			return studentBasicDetails;
		} catch (Exception e) {
			log.error("message " + e.toString());
		}
		return null;

	}

}
