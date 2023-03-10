package com.example.demo.secondary.repo;

import java.util.List;

import com.example.demo.secondary.pojo.Subjects;

public interface SubjectRepository {
	
	public List<Subjects> findAllSubjects();
	public Subjects findSubjectBySubjectId(String subjectId );
	public List<Subjects> findSubjectByTeacherId(String teacherId);
	public Subjects saveOrUpdateSubject(Subjects subject);
	public String deleteSubject(String subjectId);

}
