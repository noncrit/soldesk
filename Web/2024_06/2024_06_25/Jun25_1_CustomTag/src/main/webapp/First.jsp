<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%/*
	JSP Model 2
	값 받기 : EL : ${}
	페이지 이동 : redirect, forward, include 
	조건문, 반복문
	출력 형식(소수점, 날짜 형식 ...)
	
	얘네를 jsp 내부에서 해결하려 함
	
	CustomTag
	생김새가 HTML DOM 객체 처럼 생겼음
	.jsp => Servlet으로 변환될 때 java로 변환됨
	즉, jsp에서만 사용 가능
	<접두어:태그명>
		<xxx:table></xxx:table> => 열고 닫기 한 쌍으로!!
		<xxx:table/> => 가운데 부분에 들어갈 내용 없으면 이렇게 써도 무방
		
	1. JSP 표준 액션 태그
	JSP 환경에서 기본적으로 사용 가능한 태그
	그 접두어가 'jsp'
	forward, include ...
	
	2. 커스텀 태그
	외부 .jar을 넣고 사용
	접두어가 마음대로
	반복문, 조건문, 출력 형식 ... 등등
	
	*/%>
	
	<h1>First</h1>
	<!--  
	Second.jsp의 소스가 아래에 표현됨
	우리가 원하는 자리에 페이지 끼워넣기가 가능함!!
	서블릿 인클루드는 무조건 상단으로 넣어졌음
	-->
	<jsp:include page="Second.jsp"></jsp:include>
	
	<h2>Third</h2>

</body>
</html>