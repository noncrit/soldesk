package com.kim.jun251.calc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("contentPage","CalcInput.jsp" );
		}
		else {
			Calculator c = new Calculator();
			c.calculate(request);
			request.setAttribute("contentPage","CalcResult.jsp" );
		}
		request.getRequestDispatcher("bone.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}
}
