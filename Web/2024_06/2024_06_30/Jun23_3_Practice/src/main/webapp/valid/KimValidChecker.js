// 입력이 잘못됐으면 true값을 리턴 할 예정
// (문제가 되면 true, 아니면 false)

//<input>을 넣었을 때 아무것도 안썼으면 true, 뭐라도 썼으면 false
function isEmpty(input){
	return (!input.value);
}

//<input>을 넣었을 때 아무것도 안썼으면 true, 뭐라도 썼으면 false
function isEmpty_not_value(input){
	return (!input);
}

//<input> 하나를 넣었을 때, 한글이나 특수문자가 적혀있다면 true, 아니면 false (???)
function containsAnother(input){
	let pass = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@_.";
	
	let iv=input.value;
	for(let i=0;i<iv.length;i++){
		//iv에 pass에 해당하는 내용이 없는 경우
		if(pass.indexOf(iv[i]) == -1){
			return true;
		}
	}
	return false;
}

//<input> 글자 수를 넣었을 때 그 글자 수보다 적으면 true, 그 글자수 이상이면 false
function atLeastLetter(input,len){
	return(input.value.length<len);	
}

//<input> 2개 넣었을 때, 2개의 내용이 다르면 true, 같으면 false(PW 확인)
function notEqualPw(input1,input2){
	return (input1.value != input2.value);
	
}

//<input> 2개 넣었을 때, 2개의 내용이 다르면 false, 같으면 true(중복 확인)
function Equal(input1,input2){
	return (input1.value == input2.value);
}

//<input>, 문자열 세트 넣었을 때 
// <input>에 문자열 세트에 해당하는 내용이 없으면 true, 있으면 false(pw에 지정한 문자열이 없는 경우)
function noContain(input, passSet){
	let iv=input.value;
	for(let i=0;i<passSet.length;i++){
		if(iv.indexOf(passSet[i])!=-1){
			return false;
		}
	}
	return true;
}

//<input> 넣었을 때, 그 값이 숫자가 아니면 true, 숫자만 있으면 false
function isNotNumber(input){
	return isNaN(input.value);	//Not a number
}


//<input>, 확장자 넣었을 때
// 내가 지정한 확장자 명이 아니면 true, 맞으면 false
function isNotType(input,type){
	//.gif .png 등등
	type = "."+type;
	return (input.value.indexOf(type) == -1);
}