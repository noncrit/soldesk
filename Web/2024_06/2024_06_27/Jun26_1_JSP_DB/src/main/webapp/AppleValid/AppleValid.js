function applecheck(){
	
	let origin=document.appleRegForm.a_ORIGIN;
	let color=document.appleRegForm.a_COLOR;
	let taste=document.appleRegForm.a_TASTE;
	let price=document.appleRegForm.a_PRICE;
	let introduce=document.appleRegForm.a_INTRODUCE;
	
	if(isEmpty(origin)||isEmpty(color)||isEmpty(taste)||isEmpty(introduce)){
		alert("Fill remain input");
		origin.value="";
		color.value="";
		taste.value="";
		price.value="";
		introduce.value="";
		return false;
	}
	else if(isEmpty(price)||isNotNumber(price)){
		alert("Fill price properly");
		price.value="";
		return false;
	}
	else if(isEmpty(introduce) || atLeastLetter(introduce)){
		alert("Fill introduce properly");
		v.value="";
		return false;
	}
	
	return true;
	
	
	
}