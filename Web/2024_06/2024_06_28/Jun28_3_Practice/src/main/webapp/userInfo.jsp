<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="login_register.js"></script>
</head>
<body>
	<table id="userInfoTbl" border=1>
	
	<tr>
		<td align="center" rowspan="2">이미지 자리</td>
		<td align="center">${LoginedUser_id }님 어서오세요</td>
	</tr>
	
	<tr>
		<td rowspan="2" onclick="UserDetail('${LoginedUser_id }');">
		<button>회원정보</button>
		<button type="submit" onclick="logOut();">로그아웃</button>
		</td>
	</tr>
	</table>

</body>
</html>