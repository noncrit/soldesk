<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	
	<form name="registerForm" method="post"  action="registerController">
	<table id="registerTbl" border=1>
	
	<tr >
		<th colspan="2">회원가입</th>
	</tr>

	<tr>
		<td align="center">ID : </td>
		<td><input name="j_id"></td>
	</tr>
	
	<tr>
		<td align="center">PW : </td>
		<td><input type="password" maxlength="20" name="j_pw"></td>
	</tr>
	
	<tr>
		<td align="center">PW Check : </td>
		<td><input type="password" maxlength="20"  name="j_pwc"></td>
	</tr>
	
	<tr>
		<td align="center">name : </td>
		<td><input name="j_name"></td>
	</tr>
	
	<tr>
		<td align="center">PhoneNumber : </td>
		<td><input name="j_pn" maxlength="11"></td>
	</tr>
	
	<tr>
		<td align="center">Birth : </td>
		<td><input name="j_birth" maxlength="8"></td>
	</tr>
	
	<tr>
		<td align="center">picture : </td>
		<td><input type="file" name="j_img" ></td>
	</tr>
	
	<tr>
		<td>
		</td>
		<td align="center">
			<button class="btn">제출</button>
		</td>
	</tr>
	
	</table>
	</form>
</body>
</html>