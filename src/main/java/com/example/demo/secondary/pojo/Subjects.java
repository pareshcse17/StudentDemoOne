package com.example.demo.secondary.pojo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "subjects")
public class Subjects {

	@Id
	private String Id;
	private String subjectId;
	private String subjectName;
	private int credits;
	private List<String> teacherID;

	public Subjects(String id, String subjectId, String subjectName, int credits, List<String> teacherID) {
		super();
		Id = id;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.credits = credits;
		this.teacherID = teacherID;
	}

	public Subjects() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public List<String> getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(List<String> teacherID) {
		this.teacherID = teacherID;
	}

	@Override
	public String toString() {
		return "Subjects [Id=" + Id + ", subjectId=" + subjectId + ", subjectName=" + subjectName + ", credits="
				+ credits + ", teacherID=" + teacherID + "]";
	}

}
