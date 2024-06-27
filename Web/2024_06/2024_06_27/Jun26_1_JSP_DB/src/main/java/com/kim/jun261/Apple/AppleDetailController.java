package com.kim.jun261.Apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppleDetailController
 */
@WebServlet("/AppleDetailController")
public class AppleDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		if(AppleDAO.getApple().getAppleDetail(request)) {
			request.setAttribute("contentPage", "detail.jsp");
		}
		else {
			AppleDAO.getApple().showAppleBy4(request);
			request.setAttribute("contentPage", "Apple.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		/*
		 * AppleDAO.getApple().getAppleCount(request);
		 * AppleDAO.getApple().getAppleDetail_teacher(request);
		 * request.setAttribute("contentPage", "detail.jsp");
		 */
		
		
	}

	//AppleDelete 기능 구현을 위한 포워딩
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		if(AppleDAO.getApple().UpdateAppleDetail(request)) {
			AppleDAO.getApple().getAppleCount(request);
			AppleDAO.getApple().showAppleBy4(request,1);
			
		}
		else {
			AppleDAO.getApple().getAppleCount(request);
			AppleDAO.getApple().showAppleBy4(request,1);
		}
	
		request.setAttribute("contentPage", "Apple.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
