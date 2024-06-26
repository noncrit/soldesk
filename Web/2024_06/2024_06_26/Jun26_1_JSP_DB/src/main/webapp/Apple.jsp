<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Apple.css">
</head>
<body>
	
	<div id="Tbldiv">
	<table id="AppleTblTitle" border=1>
	<tr>
		<th>Apple</th>
	</tr>
	</table>
	
	<table id="AppleTbl" border=1>
	<tr>
		<td align="right"><a href="AppleRegController">등록</a></td>
		<td>${regResult }</td>
	</tr>
	
	<tr>
		<th>지역</th>
		<th>가격</th>
	</tr>
	
	<c:forEach var="apple" items="${apples }">
	<tr class="dataTR">
		<td>${apple.a_ORIGIN }</td>
		<td><fmt:formatNumber value="${apple.a_PRICE }" type="number"/></td>
	</tr>
	</c:forEach>
	
	
	</table>
	</div>
	

	<div id="imgdiv">
	<img class="img" src="img/apple.jpg" align="left"></img>
	</div>
	
	<div id="imgdiv2">
	<img class="img" src="img/apple.jpg" align="right"></img>
	</div>
</body>
</html>