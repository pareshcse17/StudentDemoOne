package com.example.demo.secondary.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.primary.pojo.StudentBasicDetails;
import com.example.demo.secondary.pojo.Teacher;
import com.example.demo.secondary.service.TeacherService;

@CrossOrigin
@Controller
@RequestMapping(value = "/teacherMap/")
public class TeacherFetchController {

	public TeacherFetchController() {
		// TODO Auto-generated constructor stub
		System.out.println("TeacherFetchController controller ...");
	}

	@Autowired
	public TeacherService teacherService;

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "greet")
	public String greetTeacher() {
		return "welcome teacher TeacherFetchController";
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllTeachers")
	public List<Teacher> getAllTeachers() {
		try {
			return teacherService.findAllTeachers();
		} catch (Exception e) {
			System.err.println("exceptin occured " + e);
		}
		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "greetStudent")
	public String greetStudent() {

		try {
			String url = "http://localhost:8081/studFetch/welcome";
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(url, String.class);
		}
		catch(Exception e) {
			System.out.println("exception occured" + e);
		}
		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllStudents")
	public List<StudentBasicDetails> getAllStudent() {

		try {
			String url = "http://localhost:8081/studFetch/getAllStud";
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<List<StudentBasicDetails>> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<StudentBasicDetails>>() {
					});
			List<StudentBasicDetails> students = response.getBody();
			return students;
		} catch (Exception e) {
			System.out.println("exception occured" + e);
		}
		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getStudentByName/{name}")
	public List<StudentBasicDetails> getStudentByName(@PathVariable String name) {

		try {
			String url = "http://localhost:8081/studFetch/getStudByName/{name}";
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<List<StudentBasicDetails>> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<StudentBasicDetails>>() {
					}, name);
			List<StudentBasicDetails> students = response.getBody();
			return students;
		} catch (Exception e) {
			System.out.println("exception occured" + e);
		}
		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getStudentByRollNo/{rollNo}")
	public StudentBasicDetails getStudentByRollNo(@PathVariable String rollNo) {

		System.out.println("inside getStudentByRollNo rest client method ...");
		try {
			String url = "http://localhost:8081/studFetch/getStudByRoll/{rollNo}";
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(url, StudentBasicDetails.class, rollNo);
		} catch (Exception e) {
			System.out.println("exception occured" + e);
		}
		return null;
	}
}
