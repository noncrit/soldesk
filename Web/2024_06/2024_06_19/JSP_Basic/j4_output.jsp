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
	// GET/POST
	// 원래는 한글이 넘어오면 인코딩 처리 해줘야함(지금은 톰캣 서버파일 63번줄에 처리해놨음)
	// 그래서 GET 은 처리 생략해도 지금은 가능함	
	// POST는 인코딩 처리 해줘야함
	// 그러니까 그냥 인코딩 처리 해주자...
	request.setCharacterEncoding("UTF-8");
	// 응답 부분은 get / post 둘다 원래 처리 해줬음
	// 근데 jsp 최상단에 인코딩 방식 지정해놔서 여기선 안해도 상관없음
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	int sum=x+y;
	String name=request.getParameter("name");
	%>
	<br>
	이름 : <%=name%><p>
	더한값: <%=x%>+<%=y%> = <%=sum%>
	
	
</body>
</html>