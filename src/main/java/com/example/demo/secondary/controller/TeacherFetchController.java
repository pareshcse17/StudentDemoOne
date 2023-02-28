package com.example.demo.secondary.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.demo.primary.service.impl.StudentBasicDetailsServiceIMPL;
import com.example.demo.secondary.pojo.Teacher;
import com.example.demo.secondary.service.TeacherService;

@CrossOrigin
@Controller
@RequestMapping(value = "/teacherMap/")
public class TeacherFetchController {

	final Logger log = LoggerFactory.getLogger(TeacherFetchController.class);

	public TeacherFetchController() {
		// TODO Auto-generated constructor stub
		log.info("TeacherFetchController controller ...");
	}

	@Autowired
	public TeacherService teacherService;

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "greet")
	public String greetTeacher() {
		try {
			return "welcome teacher TeacherFetchController";
		} catch (Exception e) {
			log.error("message " + e.toString());
		}
		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllTeachers")
	public List<Teacher> getAllTeachersController() {
		log.debug("inside getAllTeachersController ...");
		try {
			return teacherService.findAllTeachersService();
		} catch (Exception e) {
			log.error("message " + e.toString());
		}
		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getTeachersByName/{name}")
	public List<Teacher> getTeachersByNameController(@PathVariable String name) {
		log.debug("inside getTeachersByNameController ...");
		try {
			return teacherService.findTeachersByNameService(name);
		} catch (Exception e) {
			log.error("message " + e.toString());
		}
		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getTeachersByTeacherID/{teacherID}")
	public Teacher getTeachersByTeacherIDController(@PathVariable String teacherID) {
		
		log.debug("inside getTeachersByTeacherIDController ...");
		try {
			return teacherService.findTeacherByTeacherIDService(teacherID);
		} catch (Exception e) {
			log.error("message " + e.toString());
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
		} catch (Exception e) {
			System.out.println("exception occured" + e);
		}
		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllStudents")
	public List<StudentBasicDetails> getAllStudentController() {

		log.debug("inside getAllStudentsController ...");
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
	public List<StudentBasicDetails> getStudentsByNameController(@PathVariable String name) {

		log.debug("inside getStudentsByNameController ...");
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
	public StudentBasicDetails getStudentByRollNoController(@PathVariable String rollNo) {

		log.debug("inside getTeachersByRollNoController ...");
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
