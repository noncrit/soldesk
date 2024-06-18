<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- HTML에서 자바를 사용하게 해줌 -->
<!-- servlet보다는 훨씬 편할듯?  -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
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
	//BMI 수치 부분 손봐야함 (HTML에서는 반올림 안됨)
	//원래 코드에서 함수로 선언했어서 따로 구해야됨
	//String bmi2 = String.format("%.2f,bmi")

	%>
	
	<%-- <%=name %><p>
	<%=height %>cm<p>
	<%=weight %>kg<p>
	당신은 <%=result%> 입니다.<p>
	<img src='img/<%=image%>"" %>
 --%>
</body>
</html>