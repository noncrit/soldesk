// Model
// 유효성 검사 파일은 front-end 개발자 A가 만들었다고 가정
// front-end 개발자 B라는 사람이 건드렸다고 가정

function check(){
	let x = document.f.x;
	let y = document.f.y;
	
	if(isEmpty(x) || isNotNumber(x)
		|| isEmpty(y) || isNotNumber(y)){
			alert("Ouch!");
			return false;
		}
	return true;
}