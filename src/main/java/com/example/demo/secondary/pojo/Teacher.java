package com.example.demo.secondary.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.primary.pojo.StudentBasicDetails;

import java.util.List;

import org.springframework.data.annotation.Id;

@Document(collection = "teachers")
public class Teacher {

	@Id
	private String Id;
	private String teacherID;
	private String name;
	private String address;
	private List<String> subjects;
	private long age;
	private long salary;
	private List<StudentBasicDetails> students;

	public Teacher() {
		super();
	}

	public Teacher(String id, String teacherID, String name, String address, List<String> subjects, long age,
			long salary) {
		super();
		Id = id;
		this.teacherID = teacherID;
		this.name = name;
		this.address = address;
		this.subjects = subjects;
		this.age = age;
		this.salary = salary;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getteacherID() {
		return teacherID;
	}

	public void setteacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public List<StudentBasicDetails> getStudents() {
		return students;
	}

	public void setStudents(List<StudentBasicDetails> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [Id=" + Id + ", teacherID=" + teacherID + ", name=" + name + ", address=" + address
				+ ", subjects=" + subjects + ", age=" + age + ", salary=" + salary + "]";
	}


}
