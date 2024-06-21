<%@page import="com.kim.jun211.main.Kim"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	/*
	EL(Expression Language)
	값을 받을 때 Java(<%= % >)대신 사용할 수 있는 기능
	JSP 파일에서만 사용 가능
	.jsp를 톰캣에서 Servlet으로 바꿀 때 EL을 Java 코드로 바꿔줌
	문법 : ${X}
	X : 연산자 사용 가능, 자동 형 변환, NULL 입력이 들어오면 그냥 넘어감
	
	파라미터 값 읽기 : ${param.파라미터명}
	어트리뷰트 값(int,double String ...포함) 읽기 : ${어트리뷰트명}
	
	어트리뷰트 값 읽기(객체)
	주소값 - ${어트리뷰트명}
	속성값 - ${어트리뷰트명.멤버변수명}
	
	어트리뷰트 값 읽기(List, [])
	AL, [] 자체에 접근 : ${어트리뷰트명}
	인덱스 위치의 객체 : ${어트리뷰트명[인덱스]}
	특정 인덱스 위치의 객체 속성 - ${어트리뷰트명[인덱스].멤버변수명}
	
	애석하게도, EL에는 반복문, 조건문에 해당하는 문법이 없음
	나중에 customTag로 대체해서 사용
	
	*/	
	%>


	<%
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int z = (Integer) request.getAttribute("z");
		
		Kim k =(Kim)request.getAttribute("k");
		
		ArrayList<Kim> arkim= (ArrayList<Kim>) request.getAttribute("arkim");
		
	%>
	
	<h1>이전방식 결과 출력</h1>
	<%=x %> X <%=y %> = <%=z %><br>
	<%=k.getName() %> :  <%=k.getAge() %> : <%=k.getHeight() %> : <%=k.getWeight() %><p>
	<%=arkim %>
	
	<%=arkim %><p>
	<%=arkim.get(1) %><p>
	<%=arkim.get(2).getName() %>, <%=arkim.get(3).getAge() %>
	
	<%
		for(int i=0;i<arkim.size();i++){
	%>
			<%=arkim.get(i).getName() %> : <%=arkim.get(i).getAge() %> 살 <br>
	<%
		}
	%>
	
	<hr>
	
	${param.x}<p>
	${param.y}<p>
	${param.x * param.y}<p>
	${z}<p> <!--Attribute -->
	${b.name } : ${b.age } : ${b.height } : ${b.weight}<p>
	<hr>
	${param.asdfadcadc} <!-- 값이 없을 때 확인 -->
	<hr>
	${kim}<p>
	${kim[1]}<p>
	${kim[2].name}<p> ${kim[3].age}<p>
	
	
</body>
</html>