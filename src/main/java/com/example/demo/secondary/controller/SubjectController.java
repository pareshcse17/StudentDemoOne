package com.example.demo.secondary.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.secondary.pojo.Subjects;
import com.example.demo.secondary.service.SubjectService;

@CrossOrigin
@Controller
@RequestMapping(value = "/subjectsFetch/")
public class SubjectController {

	final Logger log = LoggerFactory.getLogger(SubjectController.class);
	
	@Autowired
	private SubjectService subjectService;
	
	public SubjectController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "greet")
	public String greetSubject() {
		try {
			return "welcome teacher SubjectController";
		} catch (Exception e) {
			log.error("message ");
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllSubjects")
	public List<Subjects> getAllSubjectsContrller(){
		log.debug("inside getAllSubjectsContrller ...");
		try {
			return subjectService.findAllSubjectsService();
		} catch (Exception e) {
			log.error("exception caught");
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getSubjectBySubjectId/{subjectId}")
	public Subjects getSubjectBySubjectIdContrller(@PathVariable String subjectId)
	{
		log.debug("inside getSubjectBySubjectIdContrller ...");
		try {
			return subjectService.findSubjectBySubjectIdService(subjectId);
		} catch (Exception e) {
			log.error("exception caught");
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getSubjectByTeacherId/{teacherId}")
	public List<Subjects> getSubjectByTeacherIdContrller(@PathVariable String teacherId)
	{
		log.debug("inside getSubjectBySubjectIdContrller ...");
		try {
			return subjectService.findSubjectByTeacherIdService(teacherId);
		} catch (Exception e) {
			log.error("exception caught");
			e.printStackTrace();
		}
		return null;
	}
}
