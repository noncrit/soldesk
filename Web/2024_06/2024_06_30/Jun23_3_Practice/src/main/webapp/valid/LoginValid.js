function checkLogin(){
	let ID=document.loginForm.j_ID;
	let PW=document.loginForm.j_PW;
	
	if(isEmpty(ID)){
			alert("Fill ID please");
			form.focus();
			return false;
	}
	else if(isEmpty(PW)){
		alert("Fill PW please");
		form.focus();
		return false;
	}
	else if(atLeastLetter(ID,3)){
		alert("Please fill ID properly");
		PN.value="";
		form.focus();
		return false;
	}
	else if(atLeastLetter(PW,3)){
		alert("Please fill PW properly");
		PN.value="";
		form.focus();
		return false;
	}
	
	return true;
}

function checkRegister(){
	let ID=document.registerForm.j_ID;
	let PW=document.registerForm.j_PW;
	let PWC=document.registerForm.j_PWC;
	let NAME=document.registerForm.j_NAME;
	let PN=document.registerForm.j_PN;
	let BIRTH=document.registerForm.j_BIRTH;
	let IMG=docuemnt.registerForm.j_IMG;
	
	if(isEmpty(ID)||
		isEmpty(PW)||
		isEmpty(PWC)||
		isEmpty(NAME)||
		isEmpty(PN)||
		isEmpty(BIRTH)||
		isEmpty(IMG)){
			
		alert("Fill all input properly");
		form.focus();
		return false;
		}
	else if(isNotNumber(PN)){
		alert("Please fill PhoneNumber with Number-only");
		PN.value="";
		form.focus();
		return false;
	}
	else if(isNotNumber(BIRTH)){
		alert("Please fill BIRTH with Number-only");
		BIRTH.value="";
			form.focus();
		return false;
	}
	else if(atLeastLetter(PN,11)){
		alert("Please fill PhoneNumber properly");
		PN.value="";
		form.focus();
		return false;
	}
	else if(atLeastLetter(BIRTH,8)){
		alert("Please fill BIRTH properly");
		BIRTH.value="";
		form.focus();
		return false;
	}
	else if(atLeastLetter(ID,3)){
		alert("Please fill ID properly");
		PN.value="";
		form.focus();
		return false;
	}
	else if(atLeastLetter(PW,3)){
		alert("Please fill PW properly");
		PN.value="";
		form.focus();
		return false;
	}
	else if(atLeastLetter(PWC,3)){
		alert("Please fill PWC properly");
		PN.value="";
		form.focus();
		return false;
	}
	
}

function checkUpdate(){
	alert("유효성 검사 호출 성공");
	
	let PW=document.userUpdateForm.j_PW;
	alert(PW.value);
	
	let PWC=document.userUpdateForm.j_PWC;
	alert(PWC.value);
	
	let NAME=document.userUpdateForm.j_NAME;
	alert(NAME.value);
	
	let PN=document.userUpdateForm.j_PN;
	alert(PN.value);
	
	let BIRTH=document.userUpdateForm.j_BIRTH;
	alert(BIRTH.value);
	let IMG;
	//const IMG=document.getElementById('fileInput').files[0].name;
	if(document.getElementById('fileInput').files.length!=0){
		let IMG=document.getElementById('fileInput').files[0].name;
	}
	alert(IMG);
	
	if(
		isEmpty(PW)||
		isEmpty(PWC)||
		isEmpty(NAME)||
		isEmpty(PN)||
		isEmpty(BIRTH)||
		isEmpty_not_value(IMG)){
			
		alert("Fill all input properly");
		form.focus();
		return false;
	}
	else if(isNotNumber(PN)){
		alert("Please fill PhoneNumber with Number-only");
		PN.value="";
		form.focus();
		return false;
	}
	else if(isNotNumber(BIRTH)){
		alert("Please fill BIRTH with Number-only");
		BIRTH.value="";
		form.focus();
		return false;
	}
	else if(atLeastLetter(PN,11)){
		alert("Please fill PhoneNumber properly");
		PN.value="";
		form.focus();
		return false;
	}
	else if(atLeastLetter(BIRTH,8)){
		alert("Please fill BIRTH properly");
		BIRTH.value="";
		form.focus();
		return false;
	}
	else if(atLeastLetter(PW,3)){
		alert("Please fill PW properly");
		PN.value="";
		form.focus();
		return false;
	}
	else if(atLeastLetter(PWC,3)){
		alert("Please fill PWC properly");
		PN.value="";
		form.focus();
		return false;
	}
	return true;
}

function checkDelete(){
	let PW = document.userDeleteForm.j_PW;
	
	if(isEmpty(PW)){
			
		alert("Fill all input properly");
		form.focus();
		return false;
	}
	else if(atLeastLetter(PW,3)){
		alert("Please fill PW properly");
		PN.value="";
		form.focus();
		return false;
	}
	
	return true;

}