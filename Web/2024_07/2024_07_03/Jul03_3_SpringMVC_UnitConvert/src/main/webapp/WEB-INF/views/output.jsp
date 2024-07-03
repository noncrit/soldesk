<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test='${option=="length"}'><h1 style="color:red;">변환 결과</h1></c:if>
	<c:if test='${option=="area"}'><h1 style="color:green;">변환 결과</h1></c:if>
	<c:if test='${option=="temp"}'><h1 style="color:blue;">변환 결과</h1></c:if>
	<c:if test='${option=="speed"}'><h1 style="color:pink;">변환 결과</h1></c:if>
	<hr>
	<table>
		<tr>
			<c:if test='${option=="length"}'><td>${input } cm -></td> <td>${result } inch</td></c:if>
			<c:if test='${option=="area"}'><td>${input } m^2 -></td> <td>${result } Pyeong</td></c:if>
			<c:if test='${option=="temp"}'><td>${input } Celcius -></td> <td>${result } Fahrenheit</td></c:if>
			<c:if test='${option=="speed"}'><td>${input } mi/h -></td> <td>${result } km/h</td></c:if>
		</tr>
	</table>
</body>
</html>