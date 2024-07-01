<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 게시글 내용  -->
	<form name="PostUpdateContentForm" method="post" action="BoardUpdateController">
	<table class="PostUpdateTbl_Login" border=1>
		
		<tr>
			<!--작성자 이미지를 board 어트리뷰트에 넣어주기  -->
			<td align="left" id="image_area">
				<img name="" src="img/${UpdatePost.j_IMG}" alt="오류">
			</td>
			
			<!--작성자 ID 표시  -->
			<td>
				<h6>-${UpdatePost.j_ID}-</h6>
			</td>
			
			<!--작성 년 월 일 시간 표시  -->
			<td>
				<input readonly="readonly" name="DateOfIssue_update" value="${UpdatePost.doi }">
			</td>
		</tr>
		
		<!--게시글 내용 부분  -->
		
		<tr>
			<td colspan="3">
				<textarea cols="50" rows="5" name="BoardTextArea_Login_update" >${UpdatePost.content}</textarea>
			</td>
		</tr>
		
		<tr>	
				<td align="center">
				<input name="PostUserID" type="hidden" value="${post.j_ID}">
				<input name="PostUpdaterUserID" type="hidden" value="${LoginedUser_id }">
				<input name="UpdateTargetPostNum" type="hidden" value="${UpdatePost.postNum }">
				<button onclick="">수정</button>
				</td>
				</form>
				
				<td><button onclick="">뒤로</button></td>
			
		</tr>
	</table>

</body>
</html>