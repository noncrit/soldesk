package com.kim.jun281.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
Controller
JSP Model 2 환경에서 상황 판단을 하는 역할 - 흐름 제어(flow control) + 실행
요청이 get? post? -> Servlet이 적합함
계산이 필요하면 Model, 내용 출력이 필요하다면 View 쪽으로 실행을 결정했음


 */

@WebServlet("/FirstC")	//annotation - firstC를 tomcat에 인식&등록시키려면 필요함
public class FirstC extends HttpServlet {
	
	//이 프로젝트에는 main 메소드가 없음
	//tomcat이 실행(main 역시 톰캣에 있음) => 알아서 FirstC 객체를 만들고 실행함
	
	
	//프로젝트를 처음 시작 할 때 생성자가 호출됨
    public FirstC() {
        super();
        //처음 실행했을 때, 사과 데이터 총 갯수를 받아오기 위해서 생성자를 건드렸었음
    }
    
	//웹사이트의 페이지를 전환하려면? 
    //C로 요청 => Model에서 기능 작업 수행 => View로 포워딩
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		//FirstC로 요청 파라미터(?x=111y=222 ...) 하나 없이 GET 요청을하면(사이트 처음 접속 시)
		if(!request.getParameterNames().hasMoreElements()) {
			
			// firstV.jsp로 지금 일어난 요청을 제보해주는 객체
			RequestDispatcher rd = request.getRequestDispatcher("firstV.jsp");
			rd.forward(request, response); //firstV.jsp 를 포워딩
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
	
	}

}
