package com.example.demo.primary.pojo;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.secondary.pojo.Teacher;
import com.example.demo.secondary.service.TeacherService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "basicDet")
public class StudentBasicDetails {

	@Id
	private String id;
	@BsonProperty(value = "roll_no")
	private String rollNo;
	private String name;
	private String address;
	private long rank;
	private List<String> subjects;
	private String teacherId;
	private Teacher teacher;

	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public StudentBasicDetails() {
		super();
	}

	public StudentBasicDetails(String id, String rollNo, String name, String address, long rank, List<String> subjects,
			String teacherId) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
		this.address = address;
		this.rank = rank;
		this.subjects = subjects;
		this.teacherId = teacherId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		System.out.print("getName " + name);
		return name;
	}

	public void setName(String name) {
		System.out.print("setName " + name);
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getRank() {
		return rank;
	}

	public void setRank(long rank) {
		this.rank = rank;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "StudentBasicDetails [id=" + id + ", rollNo=" + rollNo + ", name=" + name + ", address=" + address
				+ ", rank=" + rank + ", subjects=" + subjects + ", teacherId=" + teacherId + "]";
	}

}
