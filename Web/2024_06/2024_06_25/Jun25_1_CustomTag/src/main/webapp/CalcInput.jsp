<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CalcInput.css">
</head>
<body>
	<!--숫자 2개 입력받아서 사칙연산한 결과를 또 다른 페이지에 출력  -->
<div id="A_table_div" align="center">
<table id="A_table" border=1 style="margin-left: auto; margin-right: auto;">
<tr>
	<td>
		<form action="CalcController" name="Calcform" onsubmit="return check();">
		<input name="x" placeholder="x" autocomplete="off"><p>
		<input name="y" placeholder="y" autocomplete="off"><p>
		<button>확인</button>
		</form>
	</td>
	
</tr>
	
</table>
</div>
	
</body>
</html>