package com.kim.jun251.jstlc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JSTLCController")
public class JSTLCController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()){
			request.setAttribute("contentPage","jstlc/input.jsp" );
		}
		else {
			JSTLCDataMaker jstlcDataMaker = new JSTLCDataMaker();
			jstlcDataMaker.make(request);
			request.setAttribute("contentPage","jstlc/output.jsp" );
		}
		
		request.getRequestDispatcher("bone.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
