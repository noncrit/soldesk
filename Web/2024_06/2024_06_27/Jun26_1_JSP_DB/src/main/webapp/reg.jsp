<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="appleRegForm" method="post" action="AppleRegController" onsubmit="return applecheck();">
		생산지 : <input name="a_ORIGIN"><p>
		색상 : <input name="a_COLOR"><p>
		맛 : <input name="a_TASTE"><p>
		가격 : <input name="a_PRICE"><p>
		소개문 : <textarea name="a_INTRODUCE"></textarea><p>
		<button type="submit">제출</button>
	</form>

</body>
</html>