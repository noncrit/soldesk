package com.kim.jun283.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardController")
public class BoardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		DAO dao =DAO.getDAO();
		
		dao.getAllPostNum(request);
		//처음 게시글 표시
		//여기서 버튼 갯수 원하는 대로 나와야하는데...
		dao.showPostBy4(request,1);
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
	
	}

}
