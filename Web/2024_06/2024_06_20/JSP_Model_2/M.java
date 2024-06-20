package com.kim.jun201.main;

import javax.servlet.http.HttpServletRequest;

/*
Model : 일반 Java의 클래스 활용
	실제 업무(계산, DB, 등등)
	
	Back-end 개발자 B가 제작
 */

public class M {
	
	public static void add(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x+y;
		request.setAttribute("z", z);
	}
}
