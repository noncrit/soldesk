<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CalcResult.css">
</head>
<body>
	
	<div id="Output">
	<table id="calcOutput" border=1>
		<tr>
			<td align=center>${param.x} + ${param.y}</td>
			<td align=center>=${add}</td>
		</tr>
		
		<tr>
			<td align=center>${param.x} - ${param.y}</td>
			<td align=center>=${sub}</td>
		</tr>
		
		<tr>
			<td align=center>${param.x} * ${param.y}</td>
			<td align=center>=${mul}</td>
		</tr>
		
		<tr>
			<td align=center>${param.x} / ${param.y}</td>
			<td align=center>=${divide}</td>
		</tr>
	</table>
	</div>

</body>
</html>