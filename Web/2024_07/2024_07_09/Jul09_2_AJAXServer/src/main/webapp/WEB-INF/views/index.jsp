<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
	MyBatis + Spring MVC 활용
	e_what = e_where 의 형태로 출력
	  -->
	 <c:forEach var="i" items="${errors }">
	 	${i.e_what } - ${i.e_where }<br>	
	 </c:forEach>
</body>
</html>