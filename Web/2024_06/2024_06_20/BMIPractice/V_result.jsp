<%@page import="com.kim.jun202.main.Patient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="result.css">
</head>
<body>
<div id="wrap">
	<%
	request.setCharacterEncoding("UTF-8");
	
	//단일 어트리뷰트로 받아온 경우
	String name=(String)request.getAttribute("name");
	double bmi=(double)request.getAttribute("bmi");
	String bmi_result=(String)request.getAttribute("bmi_result");
	String fileName = (String)request.getAttribute("fileName");
	
	//객체를 선언해 통째로 받아온 경우
	Patient p = (Patient) request.getAttribute("p");
	
	%>
	
	<h1>BMI 검사 결과</h1><br>
	
	<table id = "result_table" border="1">
		<tr>
			<td>환자 이름 : <%=name%></td>
		</tr>
		<tr>
			<td>BMI  수치 : <%=bmi%></td>
		</tr>
		<tr>
			<td>판정 결과 : <%=bmi_result%>입니다.</td>
		</tr>
		<tr>
			<td align="center"><img src='img/<%=fileName%>' style='max-width:400px;'></td>
		</tr>

	</table>
	
	<table id = "result_table2" border="1">
		<tr>
			<td>(객체로 받은)환자 이름 : <%=p.getName()%></td>
		</tr>
		<tr>
			<td>(객체로 받은)BMI  수치 : <%=p.getBmi()%></td>
		</tr>
		<tr>
			<td>(객체로 받은)판정 결과 : <%=p.getBmi_result()%>입니다.</td>
		</tr>
		<tr>
			<td align="center"><img src='img/<%=p.getImage()%>' style='max-width:400px;'></td>
		</tr>

	</table>
</div>
</body>
</html>