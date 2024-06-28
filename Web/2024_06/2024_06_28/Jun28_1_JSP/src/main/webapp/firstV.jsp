<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function gogogo(){
		location.href="SecondC?a=20&b=200";
	}
</script>
</head>
<body>
<%/*
사용자가 어떠한 액션을 했을 때 이동 : 요청
요청 방식의 종류
-<a> 태그 : 클릭하면 GET 방식으로 요청
-JS 활용 : 이벤트에 JS 함수 호출을 포함시켜서 href를 통해 GET 방식 요청
(JS로 HTML 만드는게 가능함 => JS로 <form>을 생성하면 POST 요청도 가능함)
-<form>+<button> : 버튼을 클릭했을 때 GET/POST 둘 중 어느 방식을 사용 할 지 결정 가능
*/
%>
	
	<h1>First</h1>
	d : ${sessionScope.d }<br>
	e : ${cookie.e.value }<br>
	
	<a href="SecondC?a=100&b=1200">SecondC로</a>
	<hr>
	<div onclick="gogogo();">SecondC로</div>
	<hr>
	<form action="SecondC">
		<input name="a">
		<input name="b">
		<button>SecondC로</button>
	</form>
	
</body>
</html>