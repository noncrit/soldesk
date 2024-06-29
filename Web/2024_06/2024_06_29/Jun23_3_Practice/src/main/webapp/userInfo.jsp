<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/UserDetail.js"></script>
</head>
<body>
	<table id="userInfoTbl" border=1>
	
	<tr>
		<td align="center" rowspan="2"><img src="img/${LoginedUser_img}" alt="???"></td>
		<td align="center">${LoginedUser_id }님 어서오세요</td>
	</tr>
	
	<tr>
		<td rowspan="2" >
		<form name="userInfo_UserDetailForm" method="post" enctype="multipart/form-data" action="UserDetailController" >
			<input name="j_ID" type="hidden" value="${LoginedUser_id }" >
			<button onclick="">회원정보</button>
		</form>
		<button onclick="logOut();">로그아웃</button>
		</td>
	</tr>
	</table>

</body>
</html>