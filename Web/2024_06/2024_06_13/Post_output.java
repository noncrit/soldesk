package com.seok.jun132.main;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		//사용자가 입력한 값이 주소에 들어가있는 상황
		//원칙적으로, URL에 한글이 들어가서는 안된다.
		// ㅋ =>%2.....인 URL Encoding을 해줄 상태로 넘겨야하는데
		// 사용자가 입력한 ㅋ => ㅋ(UTF)-8 인코딩 => URL Encoding => %2a.xxxxxx => ㅋ(decoding) ㅋ
		
		//get방식 요청파라미터 한글처리
		//UTF-8로 표준 맞추자
		//Tomcat8.xml 63번에 수정파일 있음
		response.setCharacterEncoding("UTF-8");
		
		String input = request.getParameter("input");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		//HTML 인코딩 주의!!! 빼먹지말기
		out.print("<head><title>출력</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<table border='1' >");
			out.print("<tr> Get출력결과 :");
				out.print("<tb> ");
				out.print(input);
				out.print(" </tb>");
			out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}
	
	/*
	  GET VS POST
	  GET :	요청 파라미터가 주소에 있음
	  		대부분 GET 방식을 사용함
	  Post:	요청 파라미터가 주소창에 드러나지 않음, 값이 내부적으로 전달
	  		보안성이 높음
	  		로그인, 회원가입같은  상항헤서 Post 방식이 효율적
	 
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		//Post는 톰캣 내부를 거쳐가기에, response에도 파싱이 필요함
		request.setCharacterEncoding("UTF=8");

		String input = request.getParameter("input");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		//HTML 인코딩 주의!!! 빼먹지말기
		out.print("<head><title>출력</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<table border='1' >");
			out.print("<tr> Post 출력결과 :");
				out.print("<tb> ");
				out.print(input);
				out.print(" </tb>");
			out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

}
