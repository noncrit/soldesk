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
	<form action="student.reg">
		이름 : <input name="s_name"><p>
		별명 : <input name="s_nickname"><p>
		<button>등록</button>
	</form>
	<hr>
	${r }
	<hr>
	<c:forEach var="s" items='${students }'>
		${s.s_name } - ${s.s_nickname }<p>
	</c:forEach>
	<hr>
	<!--나중에 지우기
		시험 - 과목명, 시험 날짜(연,월,일 각각 select option으로 가져오기)
		버튼 누르면 DB에 들어가고, 그 내용도 출력
	 -->
	 
	 <form action="exam.reg">
	 	과목명 : <input name="e_name"><p>
	 	시험 날짜 : <select name="e_date_year">
	 			 <c:forEach var="x" begin="2024" end="2026">
	 			 	<option value="${x }">${x }년</option>
	 			 </c:forEach>
	 			 </select>
	
	 			<select name="e_date_month">
	 			 <c:forEach var="y" begin="1" end="12">
	 			 	<option value="${y }">${y }월</option>
	 			 </c:forEach>
	 			 </select>
	 			 
	 			 <select name="e_date_day">
	 			 <c:forEach var="z" begin="1" end="31">
	 			 	<option value="${z }">${z }일</option>
	 			 </c:forEach>
	 			 </select>
	 <button>입력</button>
	 </form>
	<hr>
		<h4>날짜 Date로 받은 버전</h4>
		 <form action="exam_test.reg">
	 	과목명 : <input name="e_name_test"><p>
	 	시험 날짜 : <select name="e_date_year_test">
	 			 <c:forEach var="x" begin="2024" end="2026">
	 			 	<option value="${x }">${x }년</option>
	 			 </c:forEach>
	 			 </select>
	
	 			<select name="e_date_month_test">
	 			 <c:forEach var="y" begin="1" end="12">
	 			 	<option value="${y }">${y }월</option>
	 			 </c:forEach>
	 			 </select>
	 			 
	 			 <select name="e_date_day_test">
	 			 <c:forEach var="z" begin="1" end="31">
	 			 	<option value="${z }">${z }일</option>
	 			 </c:forEach>
	 			 </select>
	 <button>입력</button>
	 </form>
	<hr>
	${re }
	<hr>
	
	<c:forEach var="v" items='${exams }'>
		과목명 : ${v.e_name }<p>
		
		시험 날짜 : ${v.e_date_year }년 ${v.e_date_month }월 ${v.e_date_day }일<p>
	</c:forEach>
	<hr>
	
	<hr>
	<h4>Date 버전 출력 결과</h4>
	<c:forEach var="t" items='${exams_test }'>
		과목명 : ${t.e_name_test }<p>
		시험 날짜 : <fmt:formatDate value="${t.e_date_test }" type="date" dateStyle="long"></fmt:formatDate><p>
	</c:forEach>
	<hr>
	
</body>
</html>