function bmiCheck(){
	let name=document.form_out.name;
	let height=document.form_out.height;
	let weight=document.form_out.weight;
	let image=document.form_out.image;
	
	if( isEmpty(name) ||  atLeastLetter(name,2)){
		alert("please Fill in Your name property")
		name.value="";
		name.focus();
		return false;
	}
	
	else if( isEmpty(height) || isNotNumber(height)|| atLeastLetter(height,3) ){
		alert("please Fill in Your height property")
		height.value="";
		height.focus();
		return false;
	}
	
	else if( isEmpty(weight) || isNotNumber(weight)|| atLeastLetter(weight,2) ){
		alert("please Fill in Your weight property")
		weight.value="";
		weight.focus();
		return false;
	}
	
	else if( isEmpty(image) || 
				(isNotType(image,"jpg")&& isNotType(image,"png") && isNotType(image,"bmp") ) 
			){
		alert("please Fill in Your image property")
		image.value="";
		return false;
	}
	
	return true;
		
}















