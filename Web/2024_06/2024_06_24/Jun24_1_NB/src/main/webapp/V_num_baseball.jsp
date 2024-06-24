<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="KimValidChecker.js"></script>
<script type="text/javascript"src="M_valid.js"></script>
<link rel="stylesheet" href="V_num_baseball.css">
</head>
<body>
<table border = 1 id="1st">
<tr>
	<th>숫자 야구</th>
</tr>
<tr>
	<td>
		<form action="HomeController" onsubmit="return check();" name="form">
		<input name="input" id="input" maxlength="3" autocomplete="off" autofocus="autofocus">
	
		<div id="button_div"><button type="submit">제출</button></div>
		</form>
	</td>
		
</tr>
</table>
<br>

<table border=1 id="two">
	<tr>
		<td>유저 입력</td>
		<td width="50px"> <%=request.getParameter("input")%></td>
	</tr>
	<tr>
		<td>스트라이크</td>
		<td width="50px"> ${strike}</td>
	</tr>
	
	<tr>
		<td>볼</td>
		<td width="50px"> ${ball}</td>
	</tr>

	<tr>
		<td>시도 횟수</td>
		<td width="50px"> ${count}</td>
	</tr>
	
	<tr>
		<td>결과</td>
		<td width="50px"> ${result}</td>
	</tr>
		
</table>
${con}
</body>
</html>