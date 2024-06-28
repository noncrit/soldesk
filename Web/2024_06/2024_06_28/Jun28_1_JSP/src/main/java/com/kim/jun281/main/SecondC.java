package com.kim.jun281.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SecondC")
public class SecondC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		M m =new M();
		m.makeSecondDate(request,response); //attribute c 생성하는 메소드
		m.printSecondData(request);
		m.printSecondDataNew(request); //session,cookie 호출 메소드
		request.getRequestDispatcher("secondV.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {

	}

}
