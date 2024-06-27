package com.kim.jun261.Apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplePaingController
 */
@WebServlet("/ApplePagingController")
public class ApplePagingController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AppleDAO ad = new AppleDAO();
		ad.getAppleCount(request);
		ad.showAppleBy4(request);
		request.setAttribute("contentPage", "Apple.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
