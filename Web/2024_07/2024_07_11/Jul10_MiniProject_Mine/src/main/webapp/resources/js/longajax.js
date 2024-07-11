$(function(){
	$("#wdBtn").click(function(){
		//$("#gameResultTbl").find(".gameResultTr").empty();
		//이렇게하면 tr 자체는 남음... 내용만 비우는거다...
		$("#gameResultTbl").empty();
		let user_code = $("#player_user_code").val();
		let input = $("#selectWD").val();
		let random_num = Math.floor(Math.random() * 10);
		
		$.ajax({
			url: "game.isUser",
			type:"POST",
			data:{user_code:user_code},
			success:function(y){
				//alert(JSON.stringify(y));
				let ar = y;
				let isUser_user_code = ar[0].user_code;
				alert("유저 맞음?:"+isUser_user_code);
				//alert(typeof(isUser_user_code));
				//유저가 DB 상에 존재하는 유저인지 체크 한 뒤에 나머지 작업 수행
				if(typeof(isUser_user_code)=="number"){
					
					$.ajax({
						url: "game.getData",
						success:function(x){
							
							let data_check=$(x).find('data[seq='+random_num+']').find("wdEn").text();
							//alert('Answer Wind : ' + data_check);
							//alert('your Wind : ' + input);
							//alert('result : ' + (data_check==input));
							
							//<th>유저의 선택</th>
							//<th>기상청 예측 풍향</th>
							let th1 = $("<th></th>").text("유저의 선택");
							let th2 = $("<th></th>").text("기상청 예측 풍향");
							let tr_th = $("<tr></tr>").append(th1, th2);
							$("#gameResultTbl").append(tr_th);
							
							let td_input = $("<td></td>").text(input);
							let td_answer= $("<td></td>").text(data_check);
							let tr = $("<tr class=" +"gameResultTr"+ "></tr>").append(td_input, td_answer);
							$("#gameResultTbl").find(".gameResultTr").empty();
							$("#gameResultTbl").append(tr);
							
							
							let wins=0;
							let loses=0;
							
							if(input==data_check){
								wins++;
								$.ajax({
									url:"game.gameResult",
									data:{win:wins, lose:loses, user_code:user_code}
								});
							} else{
								loses++;
								$.ajax({
									url:"game.gameResult",
									data:{win:wins, lose:loses, user_code:user_code}
								});
							}		
						}
					});
				}
				
				
			}
		});
		
	});
	
	
	$("#userResultBtn").click(function(){
		$("#userRecord").find(".recordTr").empty();
		
		let user_code = $("#user_code").val();
		/* var postData = {
				user_code:user_code
		}; */
		
		$.ajax({
			url:"game.userResult",
			 type:"POST",
			// contentType:"application/json",
			data:{user_code:user_code},
			success:function(sd){
				alert(JSON.stringify(sd));
				var ar = sd;
				//alert(ar);
				var win = ar[0].win;
				//var win = $(ar[0].win);
				//alert(win);
				
				let lose = ar[0].lose;
				
				let win_td = $("<td></td>").text(win);
				let lose_td = $("<td></td>").text(lose);
				let tr = $("<tr class="+ "recordTr" +"></tr>").append(win_td, lose_td);
				$("#userRecord").append(tr);
			}	
		});
		
	});
	
	$("#regBtn").click(function(){
		let user_code_reg = $("#user_code_reg").val();
		let name_reg = $("#name_reg").val();
			
		$.ajax({
			url:"game.regUser",
			type:"POST",
			data:{user_code:user_code_reg, name:name_reg	},
			success:function(asd){
				$("#userRegResultTbl").empty();
				let welcome_td =$("<td></td>").text("가입을 축하합니다.");
				let welcome = $("<tr></tr>").append(welcome_td);
				
				let reg_td_usercode = $("<td></td>").text("유저 코드 : " + user_code_reg);
				let reg_td_name = $("<td></td>").text(name_reg +"님");
				let reg_tr = $("<tr" +"class=regResultTr" +"></tr>").append(reg_td_usercode, reg_td_name);
				
				$("#userRegResultTbl").append(welcome);
				$("#userRegResultTbl").append(reg_tr);
			}
			/*	
			,
		    error: function(xhr, status, error) {
		        // 요청이 실패했을 때 실행할 코드
		        console.error("AJAX 요청 실패:", status, error);
		        $("#userRegResultTbl").empty();
		        alert("데이터를 불러오는 중 문제가 발생했습니다.");
		    }
			*/
		});
			
		
	});
	
});