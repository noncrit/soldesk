<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

[jsp]+[Servlet] = 서블릿 실행 시 인터넷 주소 : http://IP.port/projectName/FileName
[spring] = http://TopLevelPackage의 마지막 자리/

패키지명이 같으면 프로젝트가 달라도 주소가 같아질 수 있음 -> 에러 발생 확률이 높아짐
TopLevelPackage는 이름이 중복되지 않도록 신경 써주기

Spring 실행 -> 프로젝트 자체를 선택 후 ctrl+F11 -> Run on Server

Spring 이전에
애플리케이션 구현 -> EJB(Enterprise JavaBeans)
EJB의 기술이 점점 발전하면서 그만큼 성능이 느려지게 되고,
기능을 추가할수록 더욱 더 복잡해짐...
개발자들이 이 EJB를 사용하던 시절을 '겨울'이라고 부를 정도...
Spring 등장 후 -> '겨울'이 끝나고 '봄'이 찾아왔다 -> 그래서 Spring

Spring : Java의 문법을 사용해서 기능을 구현 -> 간단해서 진입장벽이 낮다(?)
POJD - Plain Old Java Object : 자바의 기본으로 돌아가자!를 모토로 Spring을 설계
당연히 객체지향 기반으로 설계됨

Spring -> Framework
Spring 없어도 웹 구현은 가능함
하지만 Spring을 쓰는 목적 -> 기능 구현에만 집중할 수 있도록 기본적인 뼈대를 제공해줌

vs Library : 프로그램을 제작할 때 필요한 기능, 우리가 사용하고 싶을 때 찾아서 사용
ex) json-simple.jar, kxml.jar, jstl, cos, ...
Library : 사용자가 필요 할 때 직접 호출해서 쓸 수 있는 도구
Framework : 도구를 틀 안에서 개발자가 이용 할 수 있도록 하는 뼈대

Spring 구조

Java Resources : 2개의 하위 디렉토리로 나눠짐
	자바의 영역(src/main/java) : Java 코드를 작성하기 위한 영역
	자원의 영역(src/main/resources) : MyBatis(XML) 파일, SQL 파일
	
	src - main -webapp - WEB-INF 웹에 중요한 파일들이 노출되지 않도록 만들어낸 영역 / 바깥에서는 WEB-INF 직접호출할 수 없음
	cf) META-INF는 자바에서 설정관련 정보를 저장함
	
	Spring이라는 폴더 안에 root-content.xml
	워크스페이스 전체에 대한 설정을 건드려야 할 때 사용
	
	appServlet폴더 안에 servlet-context.xml
	해당 프로젝트에 대한 설정을 바꿀때 사용
	
	View 폴더 : 눈으로 볼 수 있는 View를 작성하는 공간
	
	web.xml -> 프로그램 실생시 함께 따라가는 설정들을 모아둔 파일
	웹 어플리케이션의 단위설정을 불러오는 [ContextLoadListner]
	
	클라이언트의 요청을 DispatcherServlet으로 보내기 전에 거치는 부분 [Filter]
	
pom.xml : 필요한 라이브러리들을 maven의 중앙 저장소에서 가져와서 관리해주는 파일
</body>
</html>
