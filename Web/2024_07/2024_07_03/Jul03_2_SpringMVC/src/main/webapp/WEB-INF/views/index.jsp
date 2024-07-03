<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript" src="resources/js/index.js"></script>
</head>
<body>
	View (V) - <br>
	JSP : .html or .jsp <br>
	Spring legacy : .jsp <br>
	[View 쪽 화면을 보여줄때는 jsp 만 사용함] - why? servlet-context.xml에 선언이 그렇게 되어있음<br>
	
	Spring boot : .html (thymeleaf)<br> - 일반적으로는 html 사용(강사님 주신 파일은 jsp 끌어오게 선언되어있음)<br>
	
	Spring 내에서 사용하는 자원 파일들(css, js, 그림 ....)
	webapp/resources / ...(추가 경로)
	
	<hr>
	input 3개 - 이름 ,x,y + 버튼을 form 태그 안에 넣기
	<form action="calculate.do" method="post">
		<input name="name"><p>
		<input name="x"><p>
		<input name="y"><p>
		<button>제출</button>
	</form>
	<hr>
	<c:if test='${add !=null }'>계산 결과 : ${add }</c:if>

</body>
</html>