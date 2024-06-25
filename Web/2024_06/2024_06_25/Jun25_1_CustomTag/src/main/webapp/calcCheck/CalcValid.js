function check(){
	let x = document.Calcform.x;
	let y = document.Calcform.y;
	
	if(isNotNumber(x)||isNotNumber(y)){
			alert("Not number!");
			x.value="";
			y.value="";
			form.focus();
			return false;
		}
	else if(isEmpty(x)||isEmpty(y)){
		alert("Fill input");
		x.value="";
		y.value="";
		form.focus();
		return false;
	}
			
	return true;
}