function check(){
	let weight = document.info.weight;
	let height = document.info.height;
	let name = document.info.name;
	let image = document.info.image;
	
	if(isEmpty(weight) || isNotNumber(weight)
		|| isEmpty(height) || isNotNumber(height)){
			alert("Ouch!");
			return false;
		}
	else if(isEmpty(name)){
		alert("Fill name")
		return false;
	}
	else if(isEmpty(image)){
		alert("Fill image")
		return false;
	}
		
	return true;
}