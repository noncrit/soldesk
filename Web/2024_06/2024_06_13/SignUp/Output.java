package com.kim.jun133.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Output
 */
@WebServlet("/Output")
public class Output extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		//Post는 톰캣 내부를 거쳐가기에, response에도 파싱이 필요함
		request.setCharacterEncoding("UTF-8");
		
		String ID = request.getParameter("ID");
		String PW = request.getParameter("PW");
		String Sex = request.getParameter("Sex");
		String Legion = request.getParameter("legion");
		String[] Habit = request.getParameterValues("habit");
		String IND = request.getParameter("IND");
		//textarea 에서 엔터 : \r\n
		//HTML에서의 엔터 : <br>
		IND = IND.replace("\r\n","<br>");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		//HTML 인코딩 주의!!! 빼먹지말기
		out.print("<head><title>출력</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<table border='1' >");
			out.print("<tr> 입력받은 값들 :");
				out.print("<br>");
				out.print("<tb> ");
				out.print("ID : "+ID);
				out.print("<br>");
				
				out.print("PW : "+PW);
				out.print("<br>");
				
				out.print("Sex : "+Sex);
				out.print("<br>");
				
				out.print("Legion : "+Legion);
				out.print("<br>");
				
				if(Habit!=null) {
				out.print("Habit : ");
					for(String s : Habit) {
						out.print(s+" ");
					}
				}
				out.print("<br>");
				out.print(" </tb>");
				out.print("자기소개 : "+IND);
				out.print("<br>");
				out.print(" </tb>");
			out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
			
	}

}
