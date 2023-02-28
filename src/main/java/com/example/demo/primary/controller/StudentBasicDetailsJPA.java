package com.example.demo.primary.controller;

import java.util.List;

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
		System.out.println("inside getStudByRollController method");
		try {
			return studentBasicDetailsService.findStudentByRollNoService(rollNo);
		} catch (Exception e) {
			System.out.println("Exception caught" + e);
		}

		return null;

	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getStudByName/{name}")
	public List<StudentBasicDetails> getStudByNameController(@PathVariable String name) {
		System.out.println("inside getStudByNameController method");
		try {
			return studentBasicDetailsService.findStudentByNameService(name);
		} catch (Exception e) {
			System.out.println("Exception caught" + e);
		}

		return null;

	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getStudByTeacherId/{teacherId}")
	public List<StudentBasicDetails> getStudByteacherIdController(@PathVariable String teacherId) {
		System.out.println("inside getStudByteacherIdController method");
		try {
			return studentBasicDetailsService.findStudentByTeacherIdService(teacherId);
		} catch (Exception e) {
			System.out.println("Exception caught" + e);
		}

		return null;

	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllStud")
	public List<StudentBasicDetails> getAllStudentController() {
		System.out.println("inside getAllStudentController method");

		try {
			return studentBasicDetailsService.findAllStudentsService();
		} catch (Exception e) {
			System.out.println("Exception caught" + e);
		}

		return null;

	}
}
