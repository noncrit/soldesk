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
	
	<table id="loginTbl">
	
	<tr>
		<th>로그인</th>
	</tr>
	
	<form name="loginForm" method="post" action="LoginController">
	<tr>
		<td align="center">ID : <input name="j_ID"></td>
	</tr>
	<tr>
		<td align="center">PW : <input name="j_PW"></td>
	</tr>
	<tr>
		<td align="center"><button>로그인</button></form>
		</form>
		<form name="registerForm" method="get" action="RegisterController">
		<button type="submit">회원가입</button>
		</form>
		</td>
		
	</tr>
	
	</table>

</body>
</html>