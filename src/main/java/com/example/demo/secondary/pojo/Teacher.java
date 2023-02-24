package com.example.demo.secondary.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import org.springframework.data.annotation.Id;

@Document
public class Teacher {

	@Id
	private String Id;
	private String teacherId;
	private String name;
	private String address;
	private List<String> subjects;
	private long age;
	private long salary;

	public Teacher() {
		super();
	}

	public Teacher(String id, String teacherId, String name, String address, List<String> subjects, long age,
			long salary) {
		super();
		Id = id;
		this.teacherId = teacherId;
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

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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

	@Override
	public String toString() {
		return "Teacher [Id=" + Id + ", teacherId=" + teacherId + ", name=" + name + ", address=" + address
				+ ", subjects=" + subjects + ", age=" + age + ", salary=" + salary + "]";
	}

}
