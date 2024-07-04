package com.kim.jul042.exam;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.jul042.student.StudentDAO;

@Controller
public class ExamController {
	
	@Autowired
	private ExamDAO eDAO;
	
	@Autowired
	private StudentDAO sDAO;
	
	@RequestMapping(value="/exam.reg", method=RequestMethod.GET)
	public String regExam(Exam exam, HttpServletRequest req) {
		
		eDAO.regExam(exam, req);
		eDAO.getAllExam(req);
		sDAO.getAllStudent(req);
		return "input";
	}
	
	@RequestMapping(value="/exam_test.reg", method=RequestMethod.GET)
	public String regExam_teset(Exam_test exam_test, HttpServletRequest req) {
		
		eDAO.regExam_test(exam_test, req);
		eDAO.getAllExam_test(req);
		sDAO.getAllStudent(req);
		return "input";
	}
}
