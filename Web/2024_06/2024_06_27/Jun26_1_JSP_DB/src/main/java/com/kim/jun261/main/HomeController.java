package com.kim.jun261.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.jun261.Apple.AppleDAO;
/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	//"AppleDetail('${apple.a_ORIGIN}','${apple.a_COLOR}','${apple.a_TASTE}','${apple.a_PRICE}','${apple.a_INTRODUCE}');"
	/*
	 * public HomeController(HttpServletRequest request) { super();
	 * AppleDAO.getApple().getAppleCount(request); }
	 */
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		request.setAttribute("contentPage", "Home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
	}

}
