<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
$(function(){
	
/* 	$.ajax({
		url: "error.getJSON",
		success: function(zxc){
			alert(zxc);
			//JavaScript 객체 -> 문자열 그대로 변환 가능
			alert(JSON.Stringfy(zxc));
		}
	}); */
	
	//JSON으로 AJAX 구현하기 더 간단한 버전
	//$.getJSON("요청주소?파라미터=값& ...", 값을 받아오는데 성공하면 호출 할 콜백함수)
	$.getJSON("error.getJSON", function(zxc){
		/* //alert(JSON.stringfy(zxc));
		let ar = zxc.error;
		//배열에 객체가 들어있음 Why? -JSON에 배열이 선언되어있는데 그걸 그대로 가져왔으니 당연...
		alert(ar[0].e_where); */
		
		//jQuery 반복문
		$.each(zxc.error, function(i,e){
			let td1 = $("<td></td>").text(e.e_what);
			let td2 = $("<td></td>").text(e.e_where);
			
			let tr = $("<tr></tr>").append(td1, td2);
			$("table").append(tr);
			
		});
	});
	
	//버튼 클릭시 -> input에 e_what에 대한 내용이 error 테이블에 있으면(부분 일치) -> 그 데이터를 테이블의 형태로 출력 
	//MyBatis 측에서 문자열 포함 검색  : '%'||문자열||'%' 형태로 사용
	// Oracle : %문자열%
	
	$("button").click(function(){
		let input=$("#input").val();
		
		$.ajax({
			url:"error.searchJSON",
			data:{e_what: input},
			success: function(asd){
				$("table").empty();
				//JSON에서 배열 형태로 객체를 주기 때문에 e.으로 접근
				$.each(asd.error, function(i,e){
					let td1 = $("<td></td>").text(e.e_what);
					let td2 = $("<td></td>").text(e.e_where);
					
					let tr = $("<tr></tr>").append(td1, td2);
					$("table").append(tr);
				});
			}
			
		});
			
	});
	
	$("input").keyup(function(e){
		if(e.keyCode ==13){
			$("button").trigger("click");
		}
	});
});


</script>
<title>Insert title here</title>
</head>
<body>

	<input id="input"> <button>button</button>
	<hr>
	<table border="1"></table>
</body>
</html>