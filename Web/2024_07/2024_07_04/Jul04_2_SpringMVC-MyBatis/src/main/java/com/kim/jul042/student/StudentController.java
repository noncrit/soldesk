package com.kim.jul042.student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.jul042.exam.ExamDAO;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDAO sDAO;
	
	@Autowired
	private ExamDAO eDAO;
	
	@RequestMapping(value = "/student.reg", method = RequestMethod.GET)
	public String regStudent(Student s, HttpServletRequest req) {
		sDAO.regStudent(s, req);
		sDAO.getAllStudent(req);
		eDAO.getAllExam(req);
		return "input";
	}
	
}
