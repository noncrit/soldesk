package com.kim.jun141.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Output
 */
@WebServlet("/Output")
public class Output extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String fileName = request.getParameter("image_input");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		//HTML 인코딩 주의!!! 빼먹지말기
		out.print("<head><title>출력</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<table border='1' >");
			out.print("<tr> <h1>사진 제목 :");
				out.print("<tb> ");
				out.printf("%s",title);
				out.print(" </h1></tb>");
				
				out.print("<tb> ");
				out.printf("<h1>파일명 : %s</h1>",fileName);
				out.printf("<img src=%s>", fileName);
				
				
				out.print(" </tb>");
			out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//기존(주황색) 파일을 제외한 나머지 텍스트 방식들 인코딩 처리 지정
//		request.setCharacterEncoding("UTF-8");
//		
//		//기존 방식으로 전송된 파라미터 읽어오던 방식
//		String title = request.getParameter("title");
		
		//위 부분은 cos.jar에 선언되어있음
		
		//Servlet측 응답 형식 인코딩 방식 지정
		response.setCharacterEncoding("UTF-8");
		
		
		
		//파일이 업로드가 될 서버상의 폴더의 절대경로값 필요
		//Q. 이거 디렉토리 가까운 순서대로 파일 이름 찾는건가? - 
		//맞음, Output.java 위치한 디렉토리부터 위로 올라감, 하위경로로 더 들어가야되면 tmp/img 이런식으로 추가
		String path=request.getServletContext().getRealPath("img");
		System.out.println(path); // 절대 경로의 위치
		
		//파일 업로드(원래의 request 객체를 덮어씀 + 저장 경로 지정)
		MultipartRequest mr = new MultipartRequest(
									request, path,
									//파일 업로드시 허용할 최대크기(byte단위)(10 MB)
									10 * 1024 * 1024,
									//request 파라미터의 인코딩 방식
									"UTF-8",
									//업로드한 파일 이름 중복시 파일이름 변경 루틴 지정
									//중복시에 파일명 뒤에 숫자를 붙이는 방식
									new DefaultFileRenamePolicy()
									);
		
		String title = mr.getParameter("title");
		
		//업로드한 파일명
		
		String fileName = mr.getFilesystemName("image_input");
		//DB에 파일명 저장 할 때=>해당 컬럼의 용량을 굉장히 여유있게 만들기
		//	ex) f_name varchar2(200 char) 200보다 더 위로도 가능
		//why? :Tomcat이 한글로 된 파일 이름을 인식하지 못함
		//		그래서 한글을 URL 인코딩해줘야해서 요구하는 공간이 커짐...
		fileName = URLEncoder.encode(fileName,"UTF-8");
		
		String fileName2 = mr.getFilesystemName("etc");
		fileName2 = URLEncoder.encode(fileName2,"UTF-8");
		//URL 인코딩시 띄어쓰기 처리
		fileName2 = fileName2.replace("+", " ");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		//HTML 인코딩 주의!!! 빼먹지말기
		out.print("<head><title>출력</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<table border='1' >");
			out.print("<tr><h1> 사진 제목 :");
				out.print("<tb> ");
				out.print(title);
				out.print("<br>");
				out.printf("파일명 : %s",fileName);
				out.print(" </tb>");
				
				out.print("<tb> ");
				out.printf("<img src='img/%s'>", fileName); //상대경로도 가능
				out.print("<br>");
				out.printf("<a href = img/%s'>다운</a>",fileName2);
				
				out.print(" </tb>");
			out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");	
	}

}
