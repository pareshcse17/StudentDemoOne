package com.example.demo.secondary.service;

import java.util.List;

import com.example.demo.secondary.pojo.Subjects;

public interface SubjectService {
	
	public List<Subjects> findAllSubjectsService();
	public Subjects findSubjectBySubjectIdService(String subjectId);
	public List<Subjects> findSubjectByTeacherIdService(String teacherId);
	public Subjects saveOrUpdateSubjectService(Subjects subject);
	public String deleteSubjectService(String subjectId);

}
