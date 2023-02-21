package com.example.demo.dto;

import java.util.List;

public class StudentBasicDetailDTO {

	public StudentBasicDetailDTO() {
		// TODO Auto-generated constructor stub
	}

	private String Id;
	private String rollNo;
	private String name;
	private String address;
	private long rank;
	private List<String> subjects;

	public StudentBasicDetailDTO(String id, String rollNo, String name, String address, long rank,
			List<String> subjects) {
		super();
		Id = id;
		this.rollNo = rollNo;
		this.name = name;
		this.address = address;
		this.rank = rank;
		this.subjects = subjects;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
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

}
