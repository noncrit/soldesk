package com.kim.jun283.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardWriteController")
public class BoardWriteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		DAO dao=DAO.getDAO();
		dao.getAllPostNum(request);
		
		if(dao.loginCheck(request)) {
			dao.writeBoard(request);
			dao.showPostBy4(request,1);
			request.setAttribute("contentPage", "board_login.jsp");
			request.setAttribute("contentPage_r", "userInfo.jsp");
		}
		else {
			System.out.println("로그인 정보 만료로 인해 writeBoard 실패");
			dao.getAllPostNum(request);
			dao.showPostBy4(request,1);
			request.setAttribute("contentPage", "board_no_login.jsp");
			request.setAttribute("contentPage_r", "login.jsp");
		}
		request.getRequestDispatcher("bone.jsp").forward(request, response);
		

	}

}
