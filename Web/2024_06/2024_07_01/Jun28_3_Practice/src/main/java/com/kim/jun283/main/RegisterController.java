package com.kim.jun283.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = DAO.getDAO();
		if(dao.loginCheck(request)) {
			request.setAttribute("contentPage_r", "userInfo.jsp");
			request.setAttribute("contentPage", "home.jsp");
		}
		else {
			request.setAttribute("contentPage_r", "login.jsp");
			request.setAttribute("contentPage", "register.jsp");
		}
		
		request.getRequestDispatcher("bone.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		DAO dao=DAO.getDAO();
		dao.register(request);
		request.setAttribute("contentPage_r", "login.jsp");
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("bone.jsp").forward(request, response);

	}

}
