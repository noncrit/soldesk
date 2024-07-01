<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	
	<form name="registerForm" method="post"  action="RegisterController" 
	enctype="multipart/form-data" onsubmit="return checkRegister();">
	<table id="registerTbl" border=1>
	
	<tr >
		<th colspan="2">회원가입</th>
	</tr>

	<tr>
		<td align="center">ID : </td>
		<td><input name="j_ID" maxlength="20" placeholder="Minimum length 3"></td>
	</tr>
	
	<tr>
		<td align="center">PW : </td>
		<td><input type="password" maxlength="20" name="j_PW" placeholder="Minimum length 3"></td>
	</tr>
	
	<tr>
		<td align="center">PW Check : </td>
		<td><input type="password" maxlength="20"  name="j_PWC"></td>
	</tr>
	
	<tr>
		<td align="center">name : </td>
		<td><input name="j_NAME"></td>
	</tr>
	
	<tr>
		<td align="center">PhoneNumber : </td>
		<td><input name="j_PN" maxlength="11" placeholder="number only"></td>
	</tr>
	
	<tr>
		<td align="center">Birth : </td>
		<td><input name="j_BIRTH" maxlength="8" placeholder="YYYYMMDD"></td>
	</tr>
	
	<tr>
		<td align="center">picture : </td>
		<td><input type="file" name="j_IMG" ></td>
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