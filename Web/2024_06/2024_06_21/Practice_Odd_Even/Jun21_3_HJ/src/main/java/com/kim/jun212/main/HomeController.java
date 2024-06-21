package com.kim.jun212.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
       
    //동전 10개로 하는 홀 짝 게임
	//동전 앞면의 갯수 기준 홀/짝 맞추기
	//RSP 예제랑 비슷하게
 
	 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if(!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("V_oe.jsp").forward(request, response);
		}
		else {
			M_oddeven.getOe().odd_even_game(request);
			request.getRequestDispatcher("V_oe.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		M_oddeven a =M_oddeven.getOe();
		a.reset();
		request.getRequestDispatcher("V_oe.jsp").forward(request, response);
	}

}
