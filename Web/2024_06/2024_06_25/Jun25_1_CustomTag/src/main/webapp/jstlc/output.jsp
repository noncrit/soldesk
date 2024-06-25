<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- core => 조건문/반복문이 들어있는 라이브러리-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%/*
		조건문 반복문 실습
		라이브러리 jstl  1.2 메이븐에서 다운로드
		web-inf/lib
	*/%>
	
	<h1>${param.n}</h1>
			
	<!-- 조건문 test 부분이 조건 -->
	<c:if test="${param.n%2==0}">짝수</c:if>
	<hr>
	
	<!-- if-else + switch-case 합쳐놓은듯한 조건문
	switch와는 다르게 조건 들어갈 수 있는 범위가 넓음  -->
	<!--otherwise 부분이 default  -->
	<!--주의점 : choose 태그 사이에는 주석 넣을 수 없음!!!  -->
	
	<c:choose>
		<c:when test="${param.n >10}">
			10보다 크다
		</c:when>
		
		<c:when test="${param.n >= 5}">
			5~10 사이
		</c:when>
		
		<c:otherwise>
			나머지....
		</c:otherwise>
	</c:choose>
	<hr>
	
	<!--  반복문  -->
	<%
		/*
		for (int i=0;i<=5;i++){
			System.out.println(i);		
		} 
		*/
	%>
	<!--for문과 유사한 형태 step=> 단계를 2개씩  -->
	<c:forEach var="v" begin="1" end="${param.n}" step="2">
		<marquee>${v}</marquee>
	</c:forEach>
	<hr>
	
	<!--for each 와 유사한 형태  -->
	<%
	//for(int i :ar){
		//System.out.println(i);
	//}
	%>
	<c:forEach var="i" items="${ar}}">
		<marquee>${i}</marquee>
	</c:forEach>
	<hr>
	<!--여기 오류났음-->
	<c:forEach var="Kim" items="${al}">
		<marquee>${Kim.name} - ${Kim.age}</marquee>
	</c:forEach>
	<hr>
	
	<!--try-catch문 : 코드의 성공/실패 여부를 myExcept에 담는 형태-->
	<c:catch var="myExcept">
		<% int result= 100/2;%>
		계산 결과 : <%=result %>
	</c:catch>
	<hr>
	
	<c:catch var="myExcept">
		<% int result= 100/0;%>
		계산 결과 : <%=result %>
	</c:catch>
	
	<!--myExcept를 이용한 catch 작업  -->
	
	<c:if test="${myExcept != null }">
		에러 발생 : ${myExcept.message}
	</c:if>
	<hr>
	
	<!--Out 기능 (요청 파라미터 출력 기능)  -->
	<c:out value="${param.n} ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ"></c:out>
	
	<!-- 변수 생성 가능 var=변수명 value=변수값-->
	<c:set var="name" value="김김김"></c:set>
	<c:out value="${name}"></c:out>
	<hr>
	
	<!--StringTokenizer 사용 가능 var로 선언한곳(item)에 구분자(delims)로 자른 문자열을 담음-->
	<!--이거 자동반복인가?  -->
	<c:forTokens var="item" items="서울,대전,대구,부산,찍고,아하" delims=",">
		지역 : ${item}<br>
	</c:forTokens>
	
	
	
</body>
</html>
