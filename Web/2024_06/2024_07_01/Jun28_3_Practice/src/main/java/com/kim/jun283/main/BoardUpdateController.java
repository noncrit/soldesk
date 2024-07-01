package com.kim.jun283.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/BoardUpdateController")
public class BoardUpdateController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		DAO dao = DAO.getDAO();
		
		if(dao.loginCheck(request)) {
			dao.updatePost_getPost(request);
			request.setAttribute("contentPage", "boardUpdate.jsp");
			request.setAttribute("contentPage_r", "userInfo.jsp");
		}
		else {
			System.out.println("로그인 세션 만료 : BoardUpdateController");
			request.setAttribute("contentPage", "board_no_login.jsp");
			request.setAttribute("contentPage_r", "login.jsp");
		}
		request.getRequestDispatcher("bone.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		DAO dao = DAO.getDAO();
		
		if(dao.loginCheck(request)) {
			dao.updatePost(request);
			dao.showPostBy4(request, 1);
			request.setAttribute("contentPage", "board_login.jsp");
			request.setAttribute("contentPage_r", "userInfo.jsp");
		}
		else {
			System.out.println("로그인 세션 만료 : BoardUpdateController at post");
			request.setAttribute("contentPage", "board_no_login.jsp");
			request.setAttribute("contentPage_r", "login.jsp");
		}
		request.getRequestDispatcher("bone.jsp").forward(request, response);

	}

}
