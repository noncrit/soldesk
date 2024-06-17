/*
8. 함수(Function)
	서비스를 만들다보면 같거나, 비슷한 기능이 생기기 마련
	팝업창, 결제 등등...
	
	매번 새롭게 만들지 말고! => 자주 사용하는 기능을 하나로 묶어서 불러다 쓰자!
	
	function 함수명(파라미터) {
		//내용
	}
	
	함수형(파라미터); 형태로 호출하면 됨
	
*/

//파라미터 없는 함수
/*function showError(){
	alert('에러발생');
}
showError();*/
//이 메시지를 하나의 서비스 중 여러 군데에서 쓰고 있다면? -> 그냥 함수 호출만 하면 OK

//파라미터 있는 함수
/*function sayHello(name){
	let msg=`hello, ${name}`;
	alert(msg);
}
sayHello("kim");

sayHello(); // undefined 출력*/

/*function sayHello(name){
	let msg=`Hello`;
	if(name){
		msg+=`,${name}`;
	alert(msg);
	}
}*/

let msg="Hello"; //어디서나 접근 할 수 있는 전역변수(Global Variable)
console.log("함수 호출 전");
console.log(msg);


console.log("함수 내부");
function sayHello(name){
	let msg=`Hello`;	//지역 변수(Local Variable)
	if(name){
		msg+=`,${name}`;
	alert(msg);
	}
}
	
sayHello("kim");
console.log("함수 호출 후");
console.log(msg);

//Undefined 처리 팁

//OR 사용
function sayHello2(name){
	let newName=name||`Friend`;
	let msg = `Hello, ${newName}`;
	console.log(msg);
}
sayHello2();
sayHello2("kim");

//default value 사용
function sayHello3(name = `Friend`){
	let msg = `Hello, ${name}`;
	console.log(msg);
}

sayHello3();
sayHello3("seok");

//return 으로 값 반환
function add(num1, num2){
	return num1+num2;
}
let result = add(1,2);
console.log(result);

//return 은 값을 반환함과 동시에 함수를 종료하는 역할을 수행함

//정리
//각각의 함수는 한 가지 작업만 하는게 좋다..
//=>하나의 함수가 여러 작업을 진행한다면, 쪼개서 여러 개의 단일 기능 함수로 나누기
//함수명은 읽기 쉽고, 어떤 기능인지 알 수 있게 이름 짓기