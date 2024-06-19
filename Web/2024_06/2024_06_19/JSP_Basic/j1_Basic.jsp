<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<marquee><%=1230*877%></marquee>
	
	HTML : 웹사이트의 뼈대 제작 가능
	대신 디자인, 이벤트가 부족했음 => 사이트 디자인이 모자라 보이고, 정적인 이벤트만 디자인 가능
	-------------------------------
	CSS : HTML 세부 디자인을 설정하는 역할
	JavaScript : 이벤트 처리 외 기타 등등
	-------------------------------
	그런데 파라미터 읽기, 계산, 조건문, 반복문
	=> 프로그래밍 언어 영역의 기능이 필요해짐
	-------------------------------
	Servlet : 	클라이언트가 요청하면 HTML+CSS+JavaScript
				모두 사용할 수 있는 'Java' 프로그램
	-상당히 어렵고, HTML 영역은 작업이 까다로움(자동완성 불가, 사전 컴파일 불가)
	-------------------------------
	JSP(Java Servelt(Server) Page)	 [Model 1]
	-기본적인 뼈대는 HTML과 같음
	-작업 형태 : 	HTML + CSS + JavaScript 로 작성 후
				필요한 부분마다 Java 코드를 첨가하자!
	-JSP가 실행, 기능 구현, 사용자 뷰 까지 구현함
	-JSP 의 실행 형태 : Tomcat이 JSP를 Servlet으로 바꿔서 실행함
	
	역할 정리
	
	Servlet :	Java 코드로 HTML,CSS 등을 구현
	JSP		:	HTML 영역 안에서 Java 코드를 추가로 처리함
	
	<%--
		1. 스크립트릿(Scriptlet)
		JSP에서 Java 코드를 실행 할 때 사용하는 블록
		<% Java Code %> 형식으로 작성
		
		2. 지시자(Directive)
		특별한 지시를 내릴 수 있도록 하는 블록
		<%@ page / include / taglib / import ... %>
		
		3. 표현식(Expression)
		Java에서 만들어낸 값을 (웹페이지에) 출력 결과로 포함시키고 싶을 때 사용하는 블록
		<%= 값/변수/ ... %>
		숫자, 문자열, 변수 등의 값 사용 가능
		Servlet의 out.print() 와 같은 기능
		
		4. 선언문(Declaration)
		표현식에서 사용 할 수 있는 Java의 method를 작성할 때 사용하는 블록
		<%!	멤버 변수/method ...%>
		Java의 method와 동일 (이름 규칙도 동일)
		
		5. 주석
		<%-- 형태로 표현 
		
	--%>
	
	
</body>
</html>