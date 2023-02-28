package com.example.demo.secondary.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.primary.pojo.StudentBasicDetails;
import com.example.demo.primary.repo.StudentBasicDetailsRepo;
import com.example.demo.secondary.pojo.Teacher;
import com.example.demo.secondary.repo.TeacherRepository;
import com.example.demo.secondary.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	final Logger log = LoggerFactory.getLogger(TeacherServiceImpl.class);
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private StudentBasicDetailsRepo studentBasicDetailsRepo;

	public TeacherServiceImpl() {
		// TODO Auto-generated constructor stub
		log.info("inside TeacherServiceImpl ... ");
	}

	@Override
	public List<Teacher> findAllTeachersService() {
		// TODO Auto-generated method stub

		log.debug("inside findAllTeachersService ...");
		try {
			List<Teacher> teachers = teacherRepository.findAll();
			teachers.stream().forEach(t -> {
				t.setStudents(studentBasicDetailsRepo.findStudentByTeacherId(t.getteacherID()));
			});
			return teachers;
		} catch (Exception e) {
			log.debug("exception caught" + e.toString());
		}
		return null;
	}

	@Override
	public List<Teacher> findTeachersByNameService(String name) {
		// TODO Auto-generated method stub
		log.info("inside findTeachersByNameService ...");
		try {
			List<Teacher> teachers = teacherRepository.findTeachersByName(name);
			teachers.stream().forEach(t -> {
				t.setStudents(studentBasicDetailsRepo.findStudentByTeacherId(t.getteacherID()));
			});
			return teachers;
		} catch (Exception e) {
			log.debug("exception caught" + e.toString());
		}
		return null;
	}

	@Override
	public Teacher findTeacherByTeacherIDService(String teacherID) {
		// TODO Auto-generated method stub
		log.debug("inside findTeacherByTeacherIDService...");
		try {
			Teacher teacher = teacherRepository.findTeachersByTeacherID(teacherID);
			teacher.setStudents(studentBasicDetailsRepo.findStudentByTeacherId(teacher.getteacherID()));
			return teacher;
		} catch (Exception e) {
			log.debug("exception caught" + e.toString());
		}
		return null;

	}

}
