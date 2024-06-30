<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Information</h2>
	<!--form+button post 로 DetailController에 요청 - 수정 기능 구현 해당 primary key 데이터 수정  -->
	
	<table border=1>
	<form name="userUpdateForm" method="post"  action="UserDetailController" enctype="multipart/form-data" onsubmit="return checkUpdate();">
		<tr>
			<td>ID : </td>
			<td class="td2"><input readonly="readonly" name="j_ID" class="inputt" value="${user.j_ID}"></td>
		</tr>
		
		<tr>
			<td>PW : </td>
			<td class="td2"><input  name="j_PW" class="inputt" value="${user.j_PW}" maxlength="20"></td>
		</tr>
		
		<tr>
			<td>PWCheck</td>
			<td class="td2"><input  name="j_PWC" class="inputt"></td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td class="td2"><input  name="j_NAME" class="inputt" value="${user.j_NAME}"></td>
		</tr>
		
		<tr>
			<td>핸드폰 번호</td>
			<td class="td2"><input  name="j_PN" class="inputt" value="${user.j_PN}"></td>
		</tr>
		
		<tr>
			<td>생년월일</td>
			<td class="td2"><input  name="j_BIRTH" class="inputt" value="${user.j_BIRTH}"></td>
		</tr>
		
		<tr>
			<td>사진</td>
			<td class="td2"><img src="img/${user.j_IMG}" alt="오류">
			<input type="file" id="fileInput" name="j_IMG" >
			</td>
			
		</tr>
		
		<tr>
			
			<td align="center">
				<button class="btn" type="submit" >수정</button>
			</form>
			</td>
			
			<td align="center">
				<form name="userDeleteForm" method="get" action="UserDeleteController">
				<button class="btn" onclick="return deleteUser('${user.j_ID}');">회원 탈퇴</button>
				</form>
			</td>
		</tr>
		
		<tr>
			<td align="center" colspan="2">
			<button class="btn" onclick="history.back();">뒤로</button>
				<!--js 자체 라이브러리 history 사용  -->
			</td>
		</tr>
	</table>

</body>
</html>