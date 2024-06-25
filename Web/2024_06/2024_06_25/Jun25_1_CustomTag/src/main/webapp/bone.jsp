<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--어차피 불러오는 내용들은 이 페이지에 표시되니 유효성 검사도 여기서 수행  -->
<link rel="stylesheet" href="bone.css">
<script type="text/javascript" src="calcCheck/KimValidChecker.js"></script>
<script type="text/javascript"src="calcCheck/CalcValid.js"></script>
</head>
<body>
	<h1></h1>
<div id="table_div">
<table id="menu_table">
<tr>
	<th id="siteTitle" align="left">2024년 6월 25일</th>
</tr>

<tr>
	<td>
		<a href="HomeController">Home</a>
	</td>
	<td>
		<a href="CalcController">사칙연산</a>
	</td>
	<td>
		<a href="JSTLCController">JSTL-C</a>
		
	</td>
	<td>
		<a href="JSTLFController">JSTL-F</a>
	</td>
	
</tr>
</table>
</div>
	<table>
	<tr id="siteContent">
		<td><!--contentPage 어트리뷰트 없으면 무한루프 돌게됨!!! 주의!!!  -->
			<jsp:include page="${contentPage}"></jsp:include>
		</td>
	</tr>
	</table>


	
</body>
</html>