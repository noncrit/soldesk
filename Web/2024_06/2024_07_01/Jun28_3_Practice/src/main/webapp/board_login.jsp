<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/login_register.js"></script>
<script type="text/javascript" src="valid/KimValidChecker.js"></script>
<script type="text/javascript" src="valid/LoginValid.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form id="BoardWriteForm" name="BoardWriteForm" method="post" action="BoardWriteController">
	<table>
		<tr>
			<td>
				<textarea name="BoardWriteText"  cols="50" rows="5"></textarea>
			</td>
			
			<td>
				<button class="btn">게시</button>
				<input name="BoardWriteUserID" type="hidden" value="${LoginedUser_id }">
				<input name="BoardWriteUserIMG" type="hidden" value="${LoginedUser_img }">
			</td>
		</tr>
	
	</table>
	</form>
	
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
	<table class="BoardContentTbl_Login" border=1>
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
				<textarea cols="50" rows="5" name="BoardTextArea_Login" >${post.content}</textarea>
			</td>
		</tr>
		
		<tr>
				
				<td align="center">
				<input name="PostUserID" type="hidden" value="${post.j_ID}">
				<input name="PostUpdaterUserID" type="hidden" value="${LoginedUser_id }">
				<button onclick="goUpdatePost('${post.j_ID}','${LoginedUser_id }','${post.postNum }');">수정</button>
				</td>
			
			
				<td><button>삭제</button></td>
			</form>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>