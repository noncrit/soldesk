package com.kim.jun282.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		//로그인 x - index , 로그인  o - success
		if(MemberDAO.loginCheck(request)) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		

		
	}

}
