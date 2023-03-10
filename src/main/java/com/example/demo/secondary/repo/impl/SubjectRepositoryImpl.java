package com.example.demo.secondary.repo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.primary.controller.StudentBasicDetailsJPA;
import com.example.demo.secondary.pojo.Subjects;
import com.example.demo.secondary.repo.SubjectRepository;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

	final Logger log = LoggerFactory.getLogger(SubjectRepository.class);

	@Autowired
	MongoTemplate mongoTemplate;

	public SubjectRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Subjects> findAllSubjects() {
		// TODO Auto-generated method stub
		log.info("inside findAllSubjects");
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("resolved").is(false));
			return mongoTemplate.find(query, Subjects.class);
		} catch (Exception e) {
			log.info("Exception caught ...");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Subjects findSubjectBySubjectId(String subjectId) {
		// TODO Auto-generated method stub
		log.info("inside findSubjectBySubjectId");
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("subjectId").is(subjectId));
			return mongoTemplate.findOne(query, Subjects.class);
		} catch (Exception e) {
			log.info("Exception caught ...");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Subjects> findSubjectByTeacherId(String teacherId) {
		// TODO Auto-generated method stub
		log.info("inside findSubjectByTeacherId");
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("teacherId").in(teacherId));
			return mongoTemplate.find(query, Subjects.class);
		} catch (Exception e) {
			log.info("Exception caught ...");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Subjects saveOrUpdateSubject(Subjects subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSubject(String subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

}
