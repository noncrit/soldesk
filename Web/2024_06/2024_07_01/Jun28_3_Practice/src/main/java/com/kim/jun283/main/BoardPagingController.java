package com.kim.jun283.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardPagingController")
public class BoardPagingController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		DAO dao=DAO.getDAO();
		dao.getAllPostNum(request);
		//페이징 처리 가능한 메소드 호출
		dao.showPostBy4(request);	
		
		if(dao.loginCheck(request)) {
			request.setAttribute("contentPage", "board_login.jsp");
			request.setAttribute("contentPage_r", "userInfo.jsp");
		}
		else {
			request.setAttribute("contentPage", "board_no_login.jsp");
			request.setAttribute("contentPage_r", "login.jsp");
		}
		request.getRequestDispatcher("bone.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
	}

}
