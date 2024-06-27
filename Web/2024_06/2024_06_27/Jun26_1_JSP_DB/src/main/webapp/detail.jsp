<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="AppleDetail.js"></script>
</head>
<body>
	
	<h2>Apple Information</h2>
	<!--form+button post 로 DetailController에 요청 - 수정 기능 구현 해당 primary key 데이터 수정  -->
	
	<table>
	<form name="AppleUpdateForm" method="post" action="AppleDetailController">
		<tr>
			<td>지역 : </td>
			<td class="td2"><input readonly="readonly" name="a_ORIGIN" class="inputt" value="${apple.a_ORIGIN }"></td>
		</tr>
		
		<tr>
			<td>색깔 : </td>
			<td class="td2"><input  name="a_COLOR" class="inputt" value="${apple.a_COLOR }"></td>
		</tr>
		
		<tr>
			<td>맛 : </td>
			<td class="td2"><input  name="a_TASTE" class="inputt" value="${apple.a_TASTE }"></td>
		</tr>
		
		<tr>
			<td>가격 : </td>
			<td class="td2"><input  name="a_PRICE" class="inputt" value="${apple.a_PRICE}"></td>
		</tr>
		
		<tr>
			<td>소개 : </td>
			<td class="td2"><textarea autocomplete="off" name="a_INTRODUCE" >${apple.a_INTRODUCE}</textarea></td>
		</tr>
		
		<tr>
			<td align="center" colspan="2">
				<button type="submit">수정</button>
		</form>
				<button type="submit" onclick="deleteApple('${apple.a_ORIGIN}');">삭제</button>
				<!--form안에 버튼 2개라 뭘 누르든 post 요청이 가버린다 
				해결 : table 안쪽으로 form을 내려버리기(편법)
				-->
				<button class="btn" onclick="history.back();">뒤로</button>
				<!--js 자체 라이브러리 history 사용  -->
			</td>
		</tr>
	</table>
	
	
	

</body>
</html>