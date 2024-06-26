package com.kim.jun261.Apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppleRegController
 */
@WebServlet("/AppleRegController")
public class AppleRegController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		request.setAttribute("contentPage", "reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		AppleReg Areg = new AppleReg();
		Areg.AppleReg(request);
		
		AppleDAO.getApple().getApple(request);
		request.setAttribute("contentPage", "Apple.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
