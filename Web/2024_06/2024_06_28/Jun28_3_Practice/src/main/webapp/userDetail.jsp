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
	
	<table>
	<form name="userUpdateForm" method="post" action="UserDetailController">
		<tr>
			<td>ID : </td>
			<td class="td2"><input readonly="readonly" name="j_id" class="inputt" value=""></td>
		</tr>
		
		<tr>
			<td>Pw : </td>
			<td class="td2"><input  name="j_pw" class="inputt" value=""></td>
		</tr>
		
		<tr>
			<td>PwCheck : </td>
			<td class="td2"><input  name="j_pwc" class="inputt" value=""></td>
		</tr>
		
		<tr>
			<td>이름 : </td>
			<td class="td2"><input  name="j_name" class="inputt" value=""></td>
		</tr>
		
		<tr>
			<td>핸드폰 번호 : </td>
			<td class="td2"><input  name="j_pn" class="inputt" value=""></td>
		</tr>
		
		<tr>
			<td>생년월일 : </td>
			<td class="td2"><input  name="j_birth" class="inputt" value=""></td>
		</tr>
		
		<tr>
			<td>사진 : </td>
			<td class="td2"><input  name="j_img" ></td>
		</tr>
		
		<tr>
			<td align="center" colspan="2">
				<button type="submit">수정</button>
		</form>
			<button class="btn" onclick="history.back();">뒤로</button>
				<!--js 자체 라이브러리 history 사용  -->
			</td>
		</tr>
	</table>

</body>
</html>