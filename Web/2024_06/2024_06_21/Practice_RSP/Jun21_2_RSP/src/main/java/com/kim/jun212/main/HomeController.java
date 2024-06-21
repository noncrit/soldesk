package com.kim.jun212.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */

//전적 카운팅 문제 : GET 방식 요청을 할 때마다 전적이 안 쌓임
//해결책 : 유일한 게임 엔진 : Singleton pattern

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	// Java + JSP + CSS + Servlet 활용
	// 가위 바위 보 게임 페이지
	// 디자인은 알아서
	// 가위 바위 보 이미지 중 하나를 누를 때마다 게임 1판이 진행됨
	// WAS를 종료할 때 까지 전적은 계속 쌓이게 => 매 게임마다 전적이 보이도록
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("V_rsp.jsp").forward(request, response);
		}
		else {
			M_rsp.getM_rsp().rsp_main(request);
			request.getRequestDispatcher("V_rsp.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Player p = Player.getPlayer();
		p.reset();
		request.getRequestDispatcher("V_rsp.jsp").forward(request, response);
	}

}
