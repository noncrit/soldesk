<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		랜덤한 숫자(1~100)를 넣었을 때, 짝인지 홀인지 알려주는 기능
		뽑은 숫자와 홀 짝 여부를 웹페이지에 출력
	 --%>
	 <%-- Q. 이러면 % 영역이 main으로 설정되는건가? --%>
	 <%	
	 	int num=0;
	 	Random r = new Random();
	 	
	 	num=r.nextInt(100)+1;
	 	
	 	String result=oddeven(num);
	 %>
	 <%--메소드 활용 --%>
	 <%!
	 	public String oddeven(int num){
		 
		 	return (num%2==0)?"짝수":"홀수";
	 	}
	 %>
	 
	 뽑은 숫자 : <%= num %><br>
	 홀 / 짝	: <%= result %><br>
</body>
</html>