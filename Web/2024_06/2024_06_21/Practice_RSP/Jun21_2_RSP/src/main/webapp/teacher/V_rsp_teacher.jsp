<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="V_rsp.css">
</head>
<body>
<table>
<tr>
	<td>
		<a href = "HomeController?input=주먹"></a>
	</td>
	<td>
		<a href = "HomeController?input=가위"></a>
	</td>
	<td>
		<a href = "HomeController?input=보"></a>
	</td>
</tr>
</table>

	<form action="HomeController">
		<input type="submit" name="input" id="ro"  value="주먹">
		<input type="submit" name="input" id="sc" value="가위">
		<input type="submit" name="input" id="pa" value="보">
	</form>
	<table border=1>
	<tr>
		<td>승</td>
		<td width="50px"> ${Player.win}</td>
	<tr>
		<td>패</td>
		<td>${Player.lose}</td>
	<tr>
		<td>무</td>
		<td>${Player.tie}<br></td>
	</table>
</body>
</html>