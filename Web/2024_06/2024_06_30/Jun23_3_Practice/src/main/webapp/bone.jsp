<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bone.css">
<script type="text/javascript" src="js/UserDetail.js"></script>
<script type="text/javascript" src="valid/KimValidChecker.js"></script>
<script type="text/javascript" src="valid/LoginValid.js"></script>
</head>
<body>
	<table id="siteTbl">
		<tr>
			<th id="siteTitleArea">Title</th>
		</tr>
	</table>
	
	<table id="siteMenuTbl">
		<tr>
			<td align="center"><a href="">1</a></td>
			<td align="center"><a href="">2</a></td>
			<td align="center"><a href="">3</a></td>
			<td align="center"><a href="">4</a></td>
		</tr>
	</table>
	
	
	
	<table id="siteContentTbl" border=1	align="center">
		<tr>
			<td id="siteContentArea" > 
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
			
			<td id="siteContentArea_r" > 
				<jsp:include page="${contentPage_r }"></jsp:include>
			</td>
			
		</tr>
	</table>
	
	
	

</body>
</html>