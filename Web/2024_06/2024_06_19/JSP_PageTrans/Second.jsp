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
	<%
	/*
	현재 대부분의 값을 parameter로 받아오고 있음
	parameter
	-html에서 만들어낸 값 
	-request 객체에 저장한 후 사용
	-String or String[] 형태임
	
	이제 비교할 것이 attribute
	
	attritube
	-Java 에서 만들어낸 값
	-request 에 저장됨
	-자료형은 Object - 자바 최상위 객체
	
	페이지 이동
	First => Second : 사용자가 무언가 액션을 취해서 넘어왔음
	
	Second => Third : 그냥 넘어가도록 (자동) 구현하려 함
	
	How?
	-redirect	: 단순하게 페이지를 자동 이동
	response.sendRedirect("Third.jsp");
	
	-forward	: 자동 이동(값까지 같이 전달됨), 실습 예제에서는 보이지는 않지만 Second도 거쳐감
	RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
	rd.forward(request,response);
	
	-include	: 포함(Second.jsp에 Third.jsp를 포함하는 형태)
	단점 : 포함 할 파일이 무조건 해당 페이지 상단으로 오게됨... (비추)
	Q. Second 실행 전 Third를 먼저 들고오는건가?	
	
	RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
	rd.include(request,response);
	*/
	%>

	<%
	/*
	RequestDispatcher : 클라이언트로부터 들어온 요청을 원하는 쪽으로 넘기는 기능
	호출된 페이지에서는 request.setAttribute(key,value)를 통해서
	넘겨받은 데이터를 처리할 수 있음
	why?
	Redirect 와는 다르게 호출될 때 (request, response) 두 객체를 같이 받아가기 때문에
	Redirect는 데이터 처리를 못함
	*/
	//자동 이동할 경로 지정
	request.setCharacterEncoding("UTF-8");
	
	RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
	
	
	int a=Integer.parseInt(request.getParameter("a"));
	int b=Integer.parseInt(request.getParameter("b"));
	
	int c = a+b;
	request.setAttribute("c", c);
	//변수 c를 attribute "c"로 설정
	
	String d = "ㅋ";
	request.setAttribute("d", d);
	//변수 d를 attribute "d"로 설정
	
	Random e = new Random();
	request.setAttribute("e", e);
	//객체 e를 attritube "e"로 설정
	
	
	//rd.forward(request, response);
	rd.include(request, response);
	//변수 겹쳐도 상관없나 확인
	int f = a-b;
	
	%>
	<h1>Second</h1>
	<table>
		<tr>
			<td>a = <%=a %></td>
		</tr>
		<tr>
		<td>b = <%=b %></td>
		</tr>
		<tr>
		<td>f = <%=f %></td>
		</tr>
	
	</table>
	
</body>
</html>