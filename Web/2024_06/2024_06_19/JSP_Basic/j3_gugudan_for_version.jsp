<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
<style type="text/css">
	table{
		float:left;
		margin-right:10px;
	}
</style>
 -->
</head>
<body>
	<%--
		JSP를 실행했을 때, 2단 3단 4단 ... 9단
		가로로 구구단 출력
	--%>
	<%--
		실행 이 코드대로 돌아가는거 보면 위부터 아래로 그냥 실행블록 훑는 방식인듯?
		Q. Scriptlet 분리되어있으면 이거를 그냥 같은 main으로 보는건가?
	--%>
	<%
	String result;
	%>

	<%!
		public String gugudan_row(int leftnum){
			String result="";
			String tmp;
			
			for(int i=1;i<10;i++){
				tmp = leftnum+"x"+i+"="+leftnum*i+"\r\n<br>";
				result += tmp;
			}
			return result;
		}
	%>
	
	<table border="1">
	<tr>
		<% 
		for(int i=2;i<10;i++){
		%>
 		<td><%=i%>단<hr>
 			<%result=gugudan_row(i);%>
 			<%=result%>
 		</td>
 		<%}%>
 	</tr>
	</table>

</body>
</html>