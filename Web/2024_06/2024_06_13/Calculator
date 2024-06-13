package com.seok.jun132.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Encoding이 제일 처음에 나와야 인코딩이 제대로 진행됨!!!
		response.setCharacterEncoding("UTF-8");
		
		String input1 = request.getParameter("x");
		String input2 = request.getParameter("y");
		
		int input1_c = Integer.parseInt(input1);
		int input2_c = Integer.parseInt(input2);
		
		
//		response.setContentType("text/html");
		
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		//HTML 인코딩 주의!!! 빼먹지말기
		out.print("<head><title>결과</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<table border='1'>");
			out.print("<tr>값<br>"+" x = "+input1+",  y= "+input2);
				out.print("<td>더하기 : ");
				out.print(input1_c + input2_c);
				out.print("</td>");
					
				out.print("<td>빼기 : ");
				out.print(input1_c - input2_c);
				out.print("</td>");
					
				out.print("<td>곱하기 : ");
				out.print(input1_c * input2_c);
				out.print("</td>");
					
				out.print("<td>나누기 : ");
				out.printf("%d / %d = %.2f",input1_c,input2_c,(double)input1_c/input2_c);
				out.print("</td>");
			out.print("</tr>");	
		out.print("</table>");
		
		
		out.print("</body>");
		out.print("</html>");
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
