package com.example.demo.secondary.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.secondary.pojo.Subjects;
import com.example.demo.secondary.repo.SubjectRepository;
import com.example.demo.secondary.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	final Logger log = LoggerFactory.getLogger(SubjectServiceImpl.class);
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public SubjectServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Subjects> findAllSubjectsService() {
		// TODO Auto-generated method stub
		log.info("inside findAllSubjectsService");
		try {
			return subjectRepository.findAllSubjects();
		}catch(Exception e) {
			log.info("Exception caught...");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Subjects findSubjectBySubjectIdService(String subjectId) {
		// TODO Auto-generated method stub
		log.info("inside findSubjectBySubjectIdService");
		try {
			return subjectRepository.findSubjectBySubjectId(subjectId);
		}catch(Exception e) {
			log.info("Exception caught...");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Subjects> findSubjectByTeacherIdService(String teacherId) {
		// TODO Auto-generated method stub
		log.info("inside findSubjectByTeacherIdService");
		try {
			return subjectRepository.findSubjectByTeacherId(teacherId);
		}catch(Exception e) {
			log.info("Exception caught...");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Subjects saveOrUpdateSubjectService(Subjects subject) {
		// TODO Auto-generated method stub
		log.info("inside saveOrUpdateSubjectService");
		try {
			return subjectRepository.saveOrUpdateSubject(subject);
		}catch(Exception e) {
			log.info("Exception caught...");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteSubjectService(String subjectId) {
		// TODO Auto-generated method stub
		log.info("inside deleteSubjectService");
		try {
			return subjectRepository.deleteSubject(subjectId);
		}catch(Exception e) {
			log.info("Exception caught...");
			e.printStackTrace();
		}
		return null;
	}

}
