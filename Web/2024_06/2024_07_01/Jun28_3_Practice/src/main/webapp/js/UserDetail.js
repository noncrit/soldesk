function login(){
	alert("성공");
	location.href="LoginController";
	

}

function register(){
	alert("성공");
	location.href="RegisterController";

}

function UserDetail(input){
	alert("UserDetail 호출 성공");
	location.href="UserDetailController?j_ID="+input;
}

function logOut(){
	sessionStorage.clear();
	alert("세션 초기화");
	location.href="LogoutController";
}

function deleteUser(id){
	let t = confirm(`${id}님 정말 회원 탈퇴하시겠습니까?`);
	if(t){
		alert("탈퇴창으로 이동합니다.");
		return true;
	}
	else{
		alert("취소하셨습니다.");
		return false;
	}
}