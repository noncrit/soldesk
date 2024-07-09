<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		실수한거
		servlet-context.xml 패키지 명시 1개만해서 나머지 1개 기본으로 들어감
		매퍼에 sql 입력할 때 세미콜론 넣음
		컨트롤러에 또 index.jsp 라고 확장자 넣어서 index.jsp.jsp 찾음
		MyBatis 활용해서
		전체 과일 데이터를 가격순으로
		이름 - 가격 형태로 출력
		(ex 귤 - 원2,800)
	-->
	
		<c:forEach var="s" items="${fruits }">
			
				${s.f_name } - <fmt:formatNumber type="currency">${s.f_price }</fmt:formatNumber><br>
			
		</c:forEach>
		
	
</body>
</html>