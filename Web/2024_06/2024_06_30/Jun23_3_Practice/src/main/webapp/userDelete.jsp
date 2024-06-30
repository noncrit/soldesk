<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="userDeleteForm" method="post" action="UserDeleteController" onsubmit="return checkDelete();">
	<table>
		<tr>
			<td>비밀번호를 입력해주세요</td>
			
			<input type="hidden" name="j_ID" value="${LoginedUser_id }">
		</tr>
		
		<tr>
			<td><input name="j_PW" type="password" maxlength="20"></input></td>
		</tr>
		
		<tr>
			<td align="center" colspan="2">
				<button class="btn" type="submit">탈퇴</button>
			</form>
				<button onclick="UserDetail('${LoginedUser_id }');">뒤로</button>
				
			</td>
			
		</tr>
		
	</table>
	</form>

</body>
</html>