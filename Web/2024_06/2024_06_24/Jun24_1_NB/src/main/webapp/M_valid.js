function check(){
	let input = document.form.input;
	
	alert(input.value);
	let input_divided = input.value.split("");
	console.log(input_divided[0]);
	console.log(input_divided[1]);
	console.log(input_divided[2]);
	console.log(Equal(input_divided[0], input_divided[1]));
	console.log(Equal(input_divided[0], input_divided[2]));
	console.log(Equal(input_divided[1], input_divided[2]));
	
	
	if(isNotNumber(input)){
			alert("Not number!");
			form.focus();
			return false;
		}
	else if(isEmpty(input)){
		alert("Fill input");	
		form.focus();
		return false;
	}
	else if(atLeastLetter(input,3)){
		alert("Too short input");
		form.focus();
		return false;
	}
	else if(Equal(input_divided[0], input_divided[1])
			||Equal(input_divided[0], input_divided[2])
			||Equal(input_divided[1], input_divided[2])
			){
				alert("Duplicate number!!");
				form.focus();
				return false;
			}
	
	return true;
}

function splitNumber(num) {
  let nums = [];
  num=parseInt(num);
  do {
    nums.unshift(num % 10);
    num = Math.floor(num / 10);
  } while (num > 0);
  return nums;
}