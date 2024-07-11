<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--resources 붙이는거 맨날 까먹냐!!  -->
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
$(function(){
	//alert('111');
	//시간 기온 날씨 정도만 테이블로 표현
	
	$.ajax({
		url:"k.weather.get",
		success: function(asd){
			let hour_th = $("<th></th>").text("시간");
			let temp_th = $("<th></th>").text("기온");
			let wfEn_th = $("<th></th>").text("날씨");
			let ar = [];
			
			let trr= $("<tr></tr>").append(hour_th, temp_th, wfEn_th);
			$("table").append(trr);
			
			$(asd).find("data").each(function(i,f){
				
				let hour = $(f).find("hour").text();
				let temp = $(f).find("temp").text();
				let wfKor = $(f).find("wfKor").text();
				
				let hour_td = $("<td></td>").text(hour);
				let temp_td = $("<td></td>").text(temp);
				let wfKor_td = $("<td></td>").text(wfKor);
				
				let tr = $("<tr></tr>").append(hour_td, temp_td, wfKor_td);
				$("table").append(tr);
				//temp는 문자일 거라 숫자 형태로 바꾸기
				ar[i] = {label: hour, y: temp * 1 , lineColor: "orange",
					markerColor:"1E09FF"}
			});
			
			
			var chart = new CanvasJS.Chart("chartContainer", {
				animationEnabled: true,
				theme: "light2",
				title:{
					text: "Simple Line Chart"
				},
				data: [{        
					type: "line",
			      	indexLabelFontSize: 16,
					dataPoints: ar
				}]
			});
			chart.render();
		}
		
		
		
	});
	
});


</script>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<table border="1"></table>
</body>
</html>