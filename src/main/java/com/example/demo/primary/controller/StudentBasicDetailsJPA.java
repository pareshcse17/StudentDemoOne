package com.example.demo.primary.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.primary.pojo.StudentBasicDetails;
import com.example.demo.primary.service.StudentBasicDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/studFetch/")
public class StudentBasicDetailsJPA {
	
	final Logger log = LoggerFactory.getLogger(StudentBasicDetailsJPA.class);

	@Autowired
	private StudentBasicDetailsService studentBasicDetailsService;

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "welcome")
	String welcomeStudent() {
		return "Welcome Student fetch";
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getStudByRoll/{rollNo}")
	public StudentBasicDetails getStudByRollController(@PathVariable String rollNo) {
		log.info("inside getStudByRollController method");
		try {
			return studentBasicDetailsService.findStudentByRollNoService(rollNo);
		} catch (Exception e) {
			log.error("Exception caught" + e.toString());
		}

		return null;

	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getStudByName/{name}")
	public List<StudentBasicDetails> getStudByNameController(@PathVariable String name) {
		log.info("inside getStudByNameController method");
		try {
			return studentBasicDetailsService.findStudentByNameService(name);
		} catch (Exception e) {
			log.error("Exception caught" + e.toString());
		}

		return null;

	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getStudByTeacherId/{teacherId}")
	public List<StudentBasicDetails> getStudByteacherIdController(@PathVariable String teacherId) {
		log.info("inside getStudByteacherIdController method");
		try {
			return studentBasicDetailsService.findStudentByTeacherIdService(teacherId);
		} catch (Exception e) {
			log.error(e.toString());
		}

		return null;

	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllStud")
	public List<StudentBasicDetails> getAllStudentController() {
		log.info("inside getAllStudentController method");

		try {
			return studentBasicDetailsService.findAllStudentsService();
		} catch (Exception e) {
			log.error("Exception caught" + e.toString());
		}

		return null;

	}
}
