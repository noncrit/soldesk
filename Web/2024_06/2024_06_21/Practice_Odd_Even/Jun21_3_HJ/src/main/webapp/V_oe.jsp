<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
	<td>
		<a href = "HomeController?input=홀"><img src="img/etc.jpg">홀</a>
	</td>
	<td>
		<a href = "HomeController?input=짝"><img src="img/predator.jpg">짝</a>
	</td>	

</tr>
</table>
	
	<h1>form으로 구현</h1>
	<form action="HomeController">
		<input type="submit" name="input" id="odd"  value="홀">
		<input type="submit" name="input" id="even" value="짝">
	</form>
<table border=1>
	
	<tr>
	
	<td><div style="height:100%"><img src="${coin0}" width="50px" height="50px"></div></td>
	<td><div style="height:100%"><img src="${coin1}" width="50px" height="50px"></div></td>
	<td><div style="height:100%"><img src="${coin2}" width="50px" height="50px"></div></td>
	<td><div style="height:100%"><img src="${coin3}" width="50px" height="50px"></div></td>
	<td><div style="height:100%"><img src="${coin4}" width="50px" height="50px"></div></td>
	<td><div style="height:100%"><img src="${coin5}" width="50px" height="50px"></div></td>
	<td><div style="height:100%"><img src="${coin6}" width="50px" height="50px"></div></td>
	<td><div style="height:100%"><img src="${coin7}" width="50px" height="50px"></div></td>
	<td><div style="height:100%"><img src="${coin8}" width="50px" height="50px"></div></td>
	<td><div style="height:100%"><img src="${coin9}" width="50px" height="50px"></div></td>
	
	</tr>
	
</table>
	
	<table border=1>
	<tr>
		<td>승</td>
		<td width="50px"> ${win}</td>
	</tr>
	<tr>
		<td>패</td>
		<td width="50px">${lose}</td>
	</tr>
	<tr>
		<td>승률</td>
		<td width="50px">${win_rate}%</td>
	</tr>
	</table>
	
	<form action="HomeController" method="post">
		<button>다시하기</button>
	</form>

</body>
</html>