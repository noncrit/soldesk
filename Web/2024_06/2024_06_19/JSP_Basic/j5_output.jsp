<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getRandomColor(){
		
		//Math.random() 0 ~ 0.99999 까지 표현가능
		
		let r=Math.round(Math.random() * 255);
		let g=Math.round(Math.random() * 255);
		let b=Math.round(Math.random() * 255);
		
		return "rgb"("+r+","+g+","+b+");
	}
	
	function init(){
		let cv=document.getElementById("cv");
		let pen = cv.getContext("2d");
		let x = 0;
		let y = 0;
		
		setInterval(() => {
			pen.save();
			pen.style = "rgba(0, 0, 0, 0.2)";	//투명도(a) 0~1
			pen.fillRect(0,0,500,500);
			
			pen.shadowOffsetX=0;
			pen.shadowOffsetY=0;
			pen.shadowBlur=5;
			pen.shadowColor="white";
			
			x=Math.random() * 500;
			y=Math.random() * 500;
			pen.fillStyle = getRandomColor;
			pen.fillRect(x,y,20,20);
			
			pen.restore();
			
		}, 200);
	}
</script>
</head>
<body onload="init();">
	<canvas id="cv" width="300px" height="500px"></canvas>
	<hr>

	<%
	//response.sendRedirect("test.jsp");
	
	String input=request.getParameter("input");
	StringTokenizer st=new StringTokenizer(input);
	
	String s_in = st.nextToken();
	String[] s = new String[s_in.length()+1];
	
	s=s_in.split(",");
	int sum=0;
	//try catch로 numberformatException 걸리는 순서는 그냥 건너뛰는 방식도 있음
	for(int i=0;i<s.length;i++){
		
		if(s[i].matches("[+-]?\\d*(\\.\\d+)?") ){
			sum+=Integer.parseInt(s[i]);
		}
	}
	
	%>
	<table border=1>
	<tr>
		<td>입력 내용 : <%=input%><br></td>
	</tr>
	<tr>
		<td>합 : <%=sum %></td>
	</tr>
	</table>
</body>
</html>