package com.kim.jun201.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
Controller : Servlet
상황을 판단해서 M/V 중 하나를 소환
=>어떤 요청이 들어왔을 때, 판단해서 M/V를 호출
이 사이트의 진입점이 될 예정(실행은 여기부터 시작)

Back-end, 웹개발자 A - 컨트롤러는 PL(Project Leader)가 관리함

*/
@WebServlet("/C")
public class C extends HttpServlet {
	//어떤 사이트에 접속을 하려함
	//1. 주소를 직접 입력
	//2. 검색 => <a> 눌러서 접속
	// 1,2 모두 GET 방식
	// 어떤 사이트에 처음 접근할 때, POST로 바로 접근하는 방법은 없다.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("V1.html");
		rd.forward(request, response);
		
		//길이 좀 줄인 버전?
//		request.getRequestDispatcher("V1.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		M.add(request);
		//계산을 먼저 하고 결과를 봐야함
		RequestDispatcher rd = request.getRequestDispatcher("V2.jsp");
		rd.forward(request, response);
	}

}
