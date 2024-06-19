<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		public String guguTitle(int num){
			return num+"단";
		}
	
		public String gugudan_row(int leftnum){
			String result="";
			String tmp;
			StringBuilder sb = new StringBuilder();
			
			for(int i=1;i<10;i++){
				tmp = leftnum+"x"+i+"="+leftnum*i+"\r\n<br>";
				result += tmp;
			}
			return result;
		}
	%>
	
	<table>
		<tr>
			<td>2단<br>
				<%result=gugudan_row(2); %>
				<%=result%>
			</td>
			
			<td>3단<br>
				<%result=gugudan_row(3); %>
				<%=result%>
			</td>
			
			<td>4단<br>
				<%result=gugudan_row(4); %>
				<%=result%>
			</td>
			
			<td>5단<br>
				<%result=gugudan_row(5); %>
				<%=result%>
			</td>
			
			<td>6단<br>
				<%result=gugudan_row(6); %>
				<%=result%>
			</td>
			
			<td>7단<br>
				<%result=gugudan_row(7); %>
				<%=result%>
			</td>
			
			<td>8단<br>
				<%result=gugudan_row(8); %>
				<%=result%>
			</td>
			
			<td>9단<br>
				<%result=gugudan_row(9); %>
				<%=result%>
			</td>
			
		</tr>
	
	</table>

</body>
</html>