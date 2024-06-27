<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="AppleValid/KimValidChecker.js"></script>
<script type="text/javascript"src="AppleValid/AppleValid.js"></script>
<script type="text/javascript"src="AppleDetail.js"></script>
</head>
<body>
	<!--
		제목
		내용
		
		메뉴
	-->
	
	<table id="siteTbl">
		<tr>
			<th id="siteTitleArea">Title</th>
		</tr>
		<tr>
			<td id="siteContentArea" align="center"> 
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
	<table id="siteMenuTbl">
		<tr>
			<td align="center"><a href="AppleController">Apple</a></td>
			<td align="center">Banana<a href=""></a></td>
			<td align="center">Cherry<a href=""></a></td>
			<td align="center"><a href="DBCController">DB연결</a></td>
		</tr>
	</table>
</body>
</html>