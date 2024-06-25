<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--core와 formatting 둘 다 자주 쓰는 기능이라 그냥 같이 선언함  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--문자열/ 날짜 형태 포맷팅  -->
	
	<!--type=number 3자리마다 콤마 찍어줌  -->
	<fmt:formatNumber value="${a }" type="number"></fmt:formatNumber>
	<hr>
	
	<!--type=currency 3자리마다 콤마, 지역 따라 화폐단위 넘어줌 currencySymbol로 변환 가능  -->
	<fmt:formatNumber value="${a }" type="currency" currencySymbol="$"></fmt:formatNumber>
	<hr>
	
	<!-- 소수점이 자동 반올림됨(정수 부분만 출력됨) -->
	<fmt:formatNumber value="${b }" type="percent"></fmt:formatNumber>
	<hr>
	
	<!-- 소수점 두번째 자리까지만 표기 선언 (반올림)  -->
	<fmt:formatNumber value="${c }" pattern="#.00"></fmt:formatNumber>
	<hr>
	
	<!--
		Date 속성
		: type="date / time / both"
		
		1. date
		datestyle = "short", "long"
		
		2. time
		timestyle = "short", "long"
		
		3. both
		datestyle = "short", "long"
		timestyle = "short", "long"
	-->
	
	<fmt:formatDate value="${d }" type="both" dateStyle="long" timeStyle="short"/>
	<hr>
	
	<fmt:formatDate value="${d }" type="both" dateStyle="short" timeStyle="long"/>
	<hr>
	
	<fmt:formatDate value="${d }" type="both" dateStyle="long" timeStyle="long"/>
	<hr>
	
	<fmt:formatDate value="${d }" type="date" dateStyle="long"/>
	<hr>
	
	<fmt:formatDate value="${d }" type="time" dateStyle="long"/>
	<hr>
	
	<!-- 출력 패턴 지정 가능  -->
	<fmt:formatDate value="${d }" pattern="yyyy-MM-dd E a hh"/>
	<hr>
	
	<fmt:formatDate value="${d }" pattern="yyyy-MM-dd E a hh:mm:ss"/>
	<hr>
	
	
</body>
</html>