package com.kim.jul032.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//새로운 패키지를 만들 때는 top-level-package 뒤에 주제 or 키워드를 추가하는 식으로
//com.kim.jun032.calc - O
//com.kim.calc - X
//com.calc - X
//calc - X
//why? servlet-context.xml에 base-package 파라미터로 탑 레벨 패키지가 들어가있기 때문

@Controller
public class CalcController {
	
	//input에서 넘어오는 값을 받으려함
	//1. JSP 스타일 : 요청파라미터로 넘어온 String 을 파싱해서 사용
	// 파일 업로드, 날짜 ... => Spring을 사용한다고 간과하면 안될 부분들

/*	
	@RequestMapping(value = "calculate.do", method=RequestMethod.GET)
	public String calcXY(HttpServletRequest req) {
		
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		System.out.println(x);
		System.out.println(y);
		return "index";
	}
*/	
	//GET 방식 요청 파라미터 한글 처리
	//:Tomcat 설정(server.xml)
	//자동으로 인코딩 할 때 어떤 방식을 쓸 지 server.xml 63번줄에 선언했었음
	//URIEncoding="UTF-8"
	
	//POST 방식 요청 파라미터 한글 처리
	//프로젝트 내부적으로 설정해줘야했음
	//JSP : 파라미터를 읽기 전에 request.setCharacterEncoding("UTF-8");로 설정
	
	
	// 2. Spring 스타일
	//자동 인코딩 방식은 web.xml에 따로 설정
	//annotaion기반의 접근법
/*
	@RequestMapping(value = "calculate.do", method=RequestMethod.POST)
	public String calcXY(
			@RequestParam(value="name") String n,
			@RequestParam(value="x") int x,
			@RequestParam(value="y") int y) {
			
		System.out.println(n);
		System.out.println(x);
		System.out.println(y);
		
		return "index";
	}
*/
	//3. Spring 스타일 ver2
	@Autowired
	private CalcDAO cDAO;
	
	@RequestMapping(value = "calculate.do", method=RequestMethod.POST)
	public String calcXY(CalcResult cr, HttpServletRequest req) {
		
		//CalcDAO cDAO = new CalcDAO();
		
		cDAO.calculate(cr, req);
		
		return "index";
	}
	

	
	
}
