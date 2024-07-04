package com.kim.jul042.exam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void regExam(Exam exam, HttpServletRequest req) {
		
		try {
			
			ExamMapper em = ss.getMapper(ExamMapper.class);
			
			if(em.regExam(exam)==1) {
				req.setAttribute("re", "시험 등록 성공");
			}
			else {
				req.setAttribute("re", "시험 등록 실패");
			}
			
		} catch (Exception e) {
			req.setAttribute("re", "시험 등록 실패");
			e.printStackTrace();
		}
		
	}
	
	public void regExam_test(Exam_test exam_test, HttpServletRequest req) {
		
		try {
			//따로 받아온 파라미터 날짜 3개를 합쳐줘야함
			String year=req.getParameter("e_date_year_test");
			//일, 월은 무조건 두 자리 표기를 위해 정수로 바꿔서 표현
			int month=Integer.parseInt(req.getParameter("e_date_month_test"));
			int day=Integer.parseInt(req.getParameter("e_date_day_test"));
			System.out.println(month);
			String e_date_convert=String.format("%s%02d%02d", year,month,day);
			System.out.println(e_date_convert);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			
			Date e_date_test=sdf.parse(e_date_convert);
			exam_test.setE_date_test(e_date_test);
			
			ExamMapper em = ss.getMapper(ExamMapper.class);
			
			if(em.regExam_test(exam_test)==1) {
				req.setAttribute("re", "시험 등록 성공");
			}
			else {
				req.setAttribute("re", "시험 등록 실패");
			}
			
		} catch (Exception e) {
			req.setAttribute("re", "시험 등록 실패");
			e.printStackTrace();
		}
		
	}
	
	public void getAllExam(HttpServletRequest req) {
		
		try {
			
			List<Exam> exams = ss.getMapper(ExamMapper.class).getAllExam();
			req.setAttribute("exams", exams);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void getAllExam_test(HttpServletRequest req) {
		
		try {
			
			List<Exam_test> exams_test = ss.getMapper(ExamMapper.class).getAllExam_test();
			req.setAttribute("exams_test", exams_test);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
