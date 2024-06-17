/*
9. Arrow Function(화살표 함수)
	8번 파일에서 다뤘던 함수를 '함수 선언문'이라고 함
	함수를 표현하는 방법
	
	1.함수 선언문
	function sayHello(){
	console.log('hello');
	
	2. 함수 표현식
	let sayHello= function(){
	console.log("Hello");
}
sayHello();
	
}
sayHello();
*/
//함수 선언문
/*
function sayHello(){
	console.log('hello');
}
sayHello();
*/

//함수 표현식 : 변수에 함수를 담은 식
/*
let sayHello= function(){	
	console.log("Hello");
}
sayHello();
*/

//그렇다면 두 방식의 문법에는 어떤 차이가 있을까?
/*
호출하는 타이밍이 다르다.

함수 선언 : 
JS는 프로그램이 실행되기 전에 모든 함수 선언문을 모두 찾아서 메모리상 한 군데에 저장해뒀다가,
함수가 호출되면 해당하는 함수를 메모리에서 끌어올리는 식으로 사용함 => 실제로는 메모리에 있는거 읽어오는식
그래서 선언 순서 상관없이 작동이 가능
이것을 '호이스팅(Hoisting)'이라 부름

함수 표현식 :
호이스팅 적용이 불가능함, 변수로 표현되기 때문에 순차 처리에 따라서 처리됨
처리 순서가 해당 라인에 도달하면 함수가 생성됨
얘는 장점이 뭐냐 그러면?
=>화살표 함수(Arrow function) : 작성이 매우 간결한 함수

var add = function(num1,num2){
	return num1+num2;
}

//function 키워드를 화살표로 대체
var add=(num1,num2)=>{
	return num1+num2
}

//return 키워드 생략 가능
var add=(num1,num2)=>{
	num1 +num2;
}

//반환할 코드가 한 줄이라면? => 중괄호 생략가능
var add=(num1, num2)=>num1 + num2;

//들어갈 파라미터가 하나라면?=> 파라미터 소괄호 생략가능

let sayHello2 = name=>`Hello, ${name}`;

//주의점 : 파라미터가 없는 함수라면? => 오히려 괄호부분 생략 불가능
let asdf=() => console.log('asdf');
asdf();	


*/

sayHello();
function sayHello(){
	console.log('hello');
}

//Function vs Method
//JS 에서 객체의 속성으로 할당된 함수를 Method 라고 부름
let human = {
	name:"철수",
	walk: function(){
		console.log("뚜벅뚜벅");
	}
}

human.walk();
