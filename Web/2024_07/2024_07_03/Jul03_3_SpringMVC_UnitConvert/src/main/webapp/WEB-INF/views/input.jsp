<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="convert.do" method="post">
		<input name="num" placeholder="number"><p>
		<select name="option">
			<option value="1">cm -> inch</option>
			<option value="2">m*m -> pyeong</option>
			<option value="3">Celsius -> Fahrenheit</option>
			<option value="4">mi/hour -> km/hour</option>
		</select>
		<button>Submit</button>
	</form>
	
	<hr>
	check for string type
	<form action="convert.do" method="post">
		<input name="num" placeholder="number"><p>
		<select name="option">
			<option value="length">cm -> inch</option>
			<option value="area">m*m -> pyeong</option>
			<option value="temp">Celsius -> Fahrenheit</option>
			<option value="speed">mi/hour -> km/hour</option>
		</select>
		<button>Submit</button>
	</form>

</body>
</html>