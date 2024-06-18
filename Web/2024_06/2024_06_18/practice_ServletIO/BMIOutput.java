package com.kim.jun181.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Output
 */
@WebServlet("/BMIOutput")
public class BMIOutput extends HttpServlet {
          
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String path=request.getServletContext().getRealPath("img");
		
		System.out.println(path); // 절대 경로의 위치
		
		MultipartRequest mr = new MultipartRequest(
				request, path,
				//파일 업로드시 허용할 최대크기(byte단위)(10 MB)
				30 * 1024 * 1024,
				//request 파라미터의 인코딩 방식
				"UTF-8",
				//업로드한 파일 이름 중복시 파일이름 변경 루틴 지정
				//중복시에 파일명 뒤에 숫자를 붙이는 방식
				new DefaultFileRenamePolicy()
				);
		
		String fileName = mr.getFilesystemName("image");
		
		fileName = URLEncoder.encode(fileName,"UTF-8");
		fileName = fileName.replace("+", " ");
		
		//실수한 부분 String name = request.getParameter("name");
		//mr 객체로 request 덮어 씌웠는데 request 쓰겠다고 요청하면 될 리가 있나...
		String name = mr.getParameter("name");
		double weight = Double.parseDouble(mr.getParameter("weight"));
		double height = Double.parseDouble(mr.getParameter("height"));
		System.out.println(name);
		System.out.println(weight);
		System.out.println(height);
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		//HTML 인코딩 주의!!! 빼먹지말기
		out.print("<head><title>출력</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<table border='1' >");
			out.print("<tr> 입력받은 값들 :");
				out.print("<br>");
				out.print("<tb> ");
					out.print("이름 : "+name);
					out.print("<br>");
				
					out.print("몸무게 : "+weight);
					out.print("<br>");
				
					out.print("키(cm) : "+height);
					out.print("<br>");
					
					out.printf("<img src='img/%s' style='max-width:400px;'>", fileName);
					out.print("<br>");
					
					double bmi=calc_bmi(weight,height);
					out.print("계산한 BMI 수치 : "+bmi);
					out.print("<br>");	
					
					out.print("판정 결과 "+bmi_result(bmi)+"입니다.");
					
					out.print(" </tb>");
			out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
			
	}
	
	public double calc_bmi(double weight, double height) {
		double height_meter=height/100;
		double bmi= weight / (height_meter*height_meter);
		bmi=Math.round(bmi);
		return bmi;
	}
	
	public String bmi_result(double BMI) {
		
		String result = null;
		
		if(BMI<18.5) {
			result="저체중";
		}
		else if(BMI<25) {
			result="정상";
		}
		else if(BMI<30) {
			result="과체중";
		}
		else if(BMI<35) {
			result="경도비만";
		}
		else if(BMI<40) {
			result="중증도 비만";
		}
		else if(BMI>=40) {
			result="고도비만";
		}
		
		return result;
	}

}
