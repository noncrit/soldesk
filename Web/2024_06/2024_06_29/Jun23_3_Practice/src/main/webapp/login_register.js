function login(){
	alert("성공");
	location.href="LoginController";
	

}

function register(){
	alert("성공");
	location.href="RegisterController";

}

function UserDetail(input){
	
	alert("호출 성공")
	location.href="UserDetailController?j_id="+input;
}	

