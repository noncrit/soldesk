package com.kim.jun202.main;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class M_patient {
	
	public static void add(HttpServletRequest request) throws IOException {
			
		request.setCharacterEncoding("UTF-8");
		
		try {
			
			String path=request.getServletContext().getRealPath("img");
			System.out.println(path); // 절대 경로의 위치
			
			MultipartRequest mr = new MultipartRequest(
					request, path,
					//파일 업로드시 허용할 최대크기(byte단위)(30 MB)
					30 * 1024 * 1024,
					//request 파라미터의 인코딩 방식
					"UTF-8",
					//업로드한 파일 이름 중복시 파일이름 변경 루틴 지정
					//중복시에 파일명 뒤에 숫자를 붙이는 방식
					new DefaultFileRenamePolicy()
					);
			
			String name = mr.getParameter("name");
			String raw_weight = mr.getParameter("weight");
			String raw_height = mr.getParameter("height");
			//Double.parseDouble(request.getParameter("weight"));
			//Double.parseDouble(request.getParameter("height"));
			
			System.out.println(raw_weight);
			System.out.println(raw_height);
			double weight=Double.parseDouble(raw_weight);
			double height=Double.parseDouble(raw_height);
			M_doctor doc = new M_doctor();
			
			request.setAttribute("name", name);
			
			double bmi=doc.calcBMI(weight, height);
			request.setAttribute("bmi", bmi);
			
			String bmi_result=doc.bmi_result(bmi);
			request.setAttribute("bmi_result", bmi_result);
			
			String fileName = mr.getFilesystemName("image");
			
			fileName = URLEncoder.encode(fileName,"UTF-8");
			fileName = fileName.replace("+", " ");
			
			request.setAttribute("fileName", fileName);
			
			//Or 객체를 만들어서 Attribute 한번에 보내기
			Patient p = new Patient(name, weight, height, bmi, bmi_result, fileName);
			//MultipartRequest는 단순히 form의 내용과 파일 등을 받아오기 위한 용도
			//Attribute 설정은 request로 수행해야함
			request.setAttribute("p", p);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
