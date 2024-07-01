<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h6 id="board_no_login_head">게시글 작성은 로그인 후 사용 할 수 있습니다.</h6>
	
	<!-- 검색 칸  -->
	<form id="BoardSearchForm"name="BoardSearchForm" action="BoardSearchController">
	<table id="SearchTbl" border=1>
		
		<tr>
		
			<td>
				
				<input type="text" name="board_serach_input" >
				
			</td>
			
			<td>
				<button class="btn">검색</button>
			</td>
		
		</tr>
	</table>
	</form>
	<!-- 페이징 처리는 DAO 단에서 해주기 -->
	<table id="BoardPaigingTbl">
		<tr>
			<td>
			<form id="BoardPagingForm" name="BoardPagingForm" method="get" action="BoardPagingController" >
			<!--allPostNum is attribute set by DAO.getAllPostNum(request)  -->
			<c:forEach var="i" begin="1" end="${(allPostNum/4) + 1}" step="1">
			<button name="BoardPagingUserIn" type="submit" value="${i }">${i }P</button>
			</c:forEach>
			</form>	
			</td>	
		</tr>
	</table>
	
	
	<!-- 게시글 내용  -->
	<table class="BoardContentTbl_noLogin" border=1>
		<c:forEach var="post" items="${posts }">
		<tr>
			<!--작성자 이미지를 board 어트리뷰트에 넣어주기  -->
			<td align="left" id="image_area">
				<img src="img/${post.j_IMG}" alt="오류">
			</td>
			
			<!--작성자 ID 표시  -->
			<td>
				<h6>-${post.j_ID}-</h6>
			</td>
			
			<!--작성 년 월 일 시간 표시  -->
			<td>
				<input readonly="readonly" name="DateOfIssue" value="${post.doi }">
			</td>
		</tr>
		
		<!--게시글 내용 부분  -->
		<tr>
			<td colspan="3">
				<textarea cols="50" rows="5" readonly="readonly" name="BoardTextArea_no_Login" >${post.content}</textarea>
			</td>
		</tr>
		</c:forEach>
	
	</table>
	
</body>
</html>