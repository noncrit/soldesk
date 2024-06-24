<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bone.css">
</head>
<body>
	<h1>제목</h1>
<div id="table_div">
<table id="menu_table">
<tr>
	<td>
		<a href="HomeController">Home</a>
	</td>
	<td>
		<a href="AController" >A</a>
	</td>
	<td>
		<a href="BController" >B</a>
		
	</td>
	<td>
		<a href="">C</a>
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