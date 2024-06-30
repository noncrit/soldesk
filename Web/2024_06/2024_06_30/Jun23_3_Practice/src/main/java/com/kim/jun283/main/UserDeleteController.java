package com.kim.jun283.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/UserDeleteController")
public class UserDeleteController extends HttpServlet {
	
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("contentPage", "userDelete.jsp");
		request.setAttribute("contentPage_r", "userInfo.jsp");
		request.getRequestDispatcher("bone.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		DAO dao = new DAO();
		
		
		
		if(dao.deleteUser(request)) {
			dao.sessionClose(request);
			request.setAttribute("contentPage", "home.jsp");
			request.setAttribute("contentPage_r", "login.jsp");
		}
		else {
			System.out.println("UserDeleteController : dao.deleteUser(request) 실패");
			boolean i =dao.getUserDetail(request);
			System.out.println("UserDeleteController : daogetUserDetail result : "+i);
			request.setAttribute("contentPage", "userDetail.jsp");
			request.setAttribute("contentPage_r", "userInfo.jsp");
		}

		request.getRequestDispatcher("bone.jsp").forward(request, response);
	}

}
