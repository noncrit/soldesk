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
	//입력 페이지(j5_input.html)에서 버튼을 누르면 => 출력페이지(j5_output.jsp)로 가는게 원칙이지만,
	//서비스 동작중인데 코드 수정이 필요한 경우 test.jsp로 대신 받아오자!
	
	/*
	페이지 이동
	수동(사용자가 뭔가 액션을 취하면 이동) - 요청
	-<a></a> : 클릭하면 이동
	-<form> + <button> : 버튼 클릭 or input에 입력하면 이동
	-JavaScript(location.href) : 이벤트를 지정 할 수 있음
	------------------
	지금 설정한 상황은 자동 이동
	-redirect
	: 주의점) j5_output.jsp <body> 최상단에 작성해놨음
	response.sendRedirect("test.jsp");
	
	*/
	%>
	점검중...(2024.06.19 수요일 PM 02:25 ~ ???)
	
	
</body>
</html>