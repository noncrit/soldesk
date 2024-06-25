package com.kim.jun251.jstlf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSTLFController
 */
@WebServlet("/JSTLFController")
public class JSTLFController extends HttpServlet {

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
	
			JSTLFDataMaker jsf = new JSTLFDataMaker();
			jsf.make(request);
			request.setAttribute("contentPage", "jstlf/output.jsp");
			request.getRequestDispatcher("bone.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
	}

}
