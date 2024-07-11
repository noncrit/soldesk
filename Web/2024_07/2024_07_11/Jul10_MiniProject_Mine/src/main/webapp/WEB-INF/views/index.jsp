<%@page import="com.kim.julMini.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/longajax.js"></script>
</head>
<body>
<!--form으로 입력데이터 넘기면서 ajax 실행되야되는데 이거 실행 순서 맞출 수 있나...?  -->
<!-- 어차피 데이터 안넘겨도 여기서 처리되는데 form을 쓸 필요가 없었음...  -->
	<div style="border: 2px solid black; margin: 0 auto; width: 50%">
	<input id="player_user_code" name="player_user_code" placeholder="your user code"><p>
	<select id="selectWD" name="selectWD">
		<option class="WDoption" value="E">East</option>
		<option class="WDoption" value="W">West</option>
		<option class="WDoption" value="S">South</option>
		<option class="WDoption" value="N">North</option>
		<option class="WDoption" value="NW">NorthWest</option>
		<option class="WDoption" value="NE">NorthEast</option>
		<option class="WDoption" value="SE">SouthEast</option>
		<option class="WDoption" value="SW">SouthWest</option>
	</select>
	<button id="wdBtn" name="wdBtn">전송1</button>
	
	<table id="gameResultTbl" border="1" style="text-align: center;">
	</table>
	</div>
	<br>
	
	<div style="border: 2px solid black; margin: 0 auto; width: 50%">
	<input id="user_code"><button id="userResultBtn">전적</button>
	<br>
	<table id="userRecord" border="1">
		<tr>
			<th>승리</th>
			<th>패배</th>
		</tr>
	</table>
	</div>
	<br>
	
	<div style="border: 2px solid black; margin: 0 auto; width: 20%">
	<table id="userRegTbl">
		<tr>
			<th colspan="2">유저 등록</th>
		</tr>
		
		<tr>
			<td>유저 코드 : <input type="number" placeholder="number only" 
			min="1" max="9999" id="user_code_reg" style="width: 90px"></td>
		</tr>
		
		<tr>
			<td>닉네임 : <input id="name_reg" style="width: 100px">
		</tr>
		
		<tr>
			<td>
				<div style="text-align: center;">
				<button id="regBtn">등록</button>
				</div>
			</td>
		</tr>
	</table>
	</div>
	
	<br>
	
	<div style="border: 2px solid black; margin: 0 auto; width: 20%">
	<table id="userRegResultTbl">
	</table>
	</div>
	

</body>
</html>