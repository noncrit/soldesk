<%@page import="com.kim.db.manager.KimDBManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%/*
	톰캣이 Connection 객체 보관소 느낌
	
	기존에는 DriverManager.getConnection()을 실행하는 순간
	관련된 모든 작업을 수행해서 Connection 객체를 만들었음 => 비교적 느림
	
	ConnectionPool => Connection 객체를 여러 개 만들어둠
	클라이언트가 Connection 객체를 요청하면 Pool에서 객체를 하나 반환해줌
	=>기존의 방식보다는 빠름
	
	context.xml => ConnectionPool 설계도(?)
	
	Servers 폴더에 context.xml에서 건드려도 되긴 하는데,
	Servers 폴더를 건들면 현재 워크스페이스 전체에 영향을 주게 됨
	
	실제 업무 들어가면 DB 서버가 다를 수도 있음 => 프로젝트마다 따로 META-INF에 넣는게 안전
	*/%>
	
	<%
	String result="실패";
	
	Connection con = null;
	
	try{
		con = KimDBManager.connect("ksjPool");
		result="성공";
	} catch(Exception e){
		e.printStackTrace();
	}
	
	KimDBManager.close(con, null, null);
	%>
	
	<h1>DB연결</h1>
	<h1><%=result %></h1>
</body>
</html>