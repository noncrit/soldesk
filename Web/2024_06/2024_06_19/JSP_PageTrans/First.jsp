<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function gogo(){
		location.href = "Second.jsp?a=10&b=11"
		
	}
</script>
</head>
<body>
	<h1>First</h1>
	<hr>
	
	<!--
		First.jsp에서 두 숫자를 입력했을 때
		Second.jsp에서 각 숫자들 출력하기
		
		1. <a href="Second.jsp?a=10&b=20">&lt;a&gt; 로 [GET] 방식 요청
		2. <div onclick="gogo()";> JavaScript로 [GET] 방식 요청
		3.
	-->
	<a href="Second.jsp?a=10&b=20">&lt;a&gt; 로 [GET] 방식 요청</a><hr>
	<div onclick="gogo();"> JavaScript로 [GET] 방식 요청</div><hr>
	<form action="Second.jsp">
	

<table>
<tr>
	<td>
		첫번째 숫자 입력 : <input name="a"><br>
		두번째 숫자 입력 : <input name="b"><p>
		<button> form + button 조합으로 [GET/POST] 방식 요청</button>
	</td>
</tr>
</table>
</form>

</body>
</html>