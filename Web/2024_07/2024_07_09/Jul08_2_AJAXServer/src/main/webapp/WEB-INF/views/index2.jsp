<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
$(function(){
	//alert('111');
	
	//JS를 이용한 AJAX 구현
	//자바스크립트를 통해 비동기 방식으로 서버에 데이터를 요청하는 기술
	$("#btn").click(function(){
		//버튼을 클릭하면 AJAX 진행
		$.ajax({
			//$.ajax - 함수가 아니고 객체임!!
			//url : 데이터를 가져 올 주소 ->Controller에 설정한 요청 주소
			url: "fruit.getXML",
			success: function(asd){
				//요청이 성공한 경우 콜백함수 호출 - XML 문서 가져온게 맞는지 확인
				//alert(asd);
				
						
				//DOM 객체 하나 불러올 때마다 나오는 콜백함수 / 과일 데이터 여러개니 반복문
				$(asd).find("fruit").each(function(i,f){
					//alert(i + ")" + f);	//index는 0번 부터, 뒤에 f는 과일 객체(fruit) 데이터 1개)
					//f_name, f_price는 xml문서의 하위 객체
					let f_name=$(f).find("f_name").text();
					let f_price=$(f).find("f_price").text();
					//alert(f_name + "]" + f_price);
					let nameTd=$("<td></td>").text(f_name);
					
					//<fmt:formatNumber type="currency">${s.f_price }</fmt:formatNumber> -못읽음
					let priceTd=$("<td></td>").text("￦ "+f_price.toLocaleString());
					
					let tr=$("<tr></tr>").append(nameTd,priceTd);
					$("#fruitTbl").append(tr);
				});
			}
		});
	});
	
	//fruit.getXML에 요청해서
	//나오는 모든 데이터를 가지고
	//테이블 구성하기
	$.ajax({
		url:"fruit.getXML",
		success: function(asdf){
			$(asdf).find("fruit").each(function(i,f){
				let f_name=$(f).find("f_name").text();
				let f_price=$(f).find("f_price").text();
				
				let nameTd=$("<td></td>").text(f_name);
				
				//<fmt:formatNumber type="currency">${s.f_price }</fmt:formatNumber> -못읽음
				let priceTd=$("<td></td>").text("￦ "+f_price);
				let tr=$("<tr></tr>").append(nameTd,priceTd);
				$("#fruitTbl").append(tr);
			});
		}
	});
	
	//원래 하려던 방식
	//input에 숫자를 하나 입력받아서 검색 버튼을 누르면 입력한 숫자 이하의 가격인 과일들의 이름, 가격, 데이터를 가지고
	//테이블을 구성하기
	$("#fruitSearchBtn1").click(function(){
		let num_in=$("#fruitInput1").val();
		//alert(typeof(num_in));
		$.ajax({
			url:"fruit.getXML",
			success: function(aaa){
				$("#fruitTbl").empty();
				$(aaa).find("fruit").each(function(i,f){
					let f_name2=$(f).find("f_name").text();
					let f_price2=$(f).find("f_price").text();
					
					num_in=Number(num_in);
					f_price2=Number(f_price2);
					
					if(f_price2<=num_in){
						let nameTd2=$("<td style='color:teal'></td>").text(f_name2);
						let priceTd2=$("<td style='color:teal'></td>").text("￦ "+f_price2);
						let tr=$("<tr></tr>").append(nameTd2,priceTd2);
						$("#fruitTbl").append(tr);
					}
				});
			}
		});
	
		
		
	});
	//강사님 버전
	//input에 숫자를 하나 입력받아서 검색 버튼을 누르면 입력한 숫자 이하의 가격인 과일들의 이름, 가격, 데이터를 가지고
	//테이블을 구성하기
	$("#fruitSearchBtn").click(function(){
		//alert('btncheck');
		
		let frVal = $("#fruitInput").val();
		$.ajax({
			//url:"fruit.searchXML?f_price=" + frVal, //요청 주소(GET 방식) 방법 1
			url:"fruit.searchXML",
			data: {f_price: frVal},
			success: function(qwer){
				$("#fruitTbl").empty();
				$(qwer).find("fruit").each(function(i,f){
					let f_name=$(f).find("f_name").text();
					let f_price=$(f).find("f_price").text();
					let nameTd=$("<td style='color:teal'></td>").text(f_name);
					let priceTd=$("<td style='color:teal'></td>").text("￦ "+f_price);
					let tr=$("<tr></tr>").append(nameTd,priceTd);
					$("#fruitTbl").append(tr);
				});
			},//예외처리 success: 내용, error: 내용 구조
			error: function(asd){
				//alert(asd);
				$("#fruitTbl").empty();
				$("#fruitTbl").appned("<tr><td colspan='2'>오류가 났습니다...</td></tr>");
			}
			
		});
	});
	//Enter 키 입력도 버튼 클릭으로 간주하기
	$("#fruitInput").keyup(function(e){
		if(e.keyCode==13){
			$("#fruitSearchBtn").trigger("click");
		}
	});
		
});

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border=1 id="fruitTbl">
	</table>
	<hr>
	<input id="fruitInput" placeholder="teacherCode"><button id="fruitSearchBtn">검색</button><br>
	<input id="fruitInput1" placeholder="myCode"><button id="fruitSearchBtn1">검색</button>
	<hr>
	<button id="btn">버튼</button>
</body>
</html>