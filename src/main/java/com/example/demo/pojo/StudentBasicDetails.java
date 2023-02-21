package com.example.demo.pojo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "basicDet")
public class StudentBasicDetails {

	@Id
	private String id;
	private String rollNo;
	private String name;
	private String address;
	private long rank;
	private List<String> subjects;

	public StudentBasicDetails() {
		super();
	}

	public StudentBasicDetails(String id, String rollNo, String name, String address, long rank,
			List<String> subjects) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
		this.address = address;
		this.rank = rank;
		this.subjects = subjects;
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

	@Override
	public String toString() {
		return "StudentBasicDetails [rollNo=" + rollNo + ", name=" + name + ", address=" + address + ", rank=" + rank
				+ ", subjects=" + subjects + "]";
	}

}
