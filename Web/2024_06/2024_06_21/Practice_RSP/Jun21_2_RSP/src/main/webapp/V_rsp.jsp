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
<h1>a 태그로 구현</h1>
<table>

<tr>
	<td>
		<a href = "HomeController?input=주먹"><img src="img/ro.PNG"></a>
	</td>
	<td>
		<a href = "HomeController?input=가위"><img src="img/sc.PNG"></a>
	</td>	
	<td>
		<a href = "HomeController?input=보"><img src="img/pa.PNG"></a>
	</td>
</tr>
</table>
	
	<h1>form으로 구현</h1>
	<form action="HomeController">
		<input type="submit" name="input" id="ro"  value="주먹">
		<input type="submit" name="input" id="sc" value="가위">
		<input type="submit" name="input" id="pa" value="보">
	</form>
	<table border=1>
	<tr>
		<td>승</td>
		<td width="50px"> ${Player.win}</td>
	</tr>
	<tr>
		<td>패</td>
		<td>${Player.lose}</td>
	</tr>
	<tr>
		<td>무</td>
		<td>${Player.tie}<br></td>
	</tr>
	</table>
	
	<form action="HomeController" method="post">
		<button>다시하기</button>
	</form>
	
	
</body>
</html>