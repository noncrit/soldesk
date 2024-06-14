/*alert('성공!');*/
//js 파일과 html 파일 이름이 같으면 Tomcat에서 접근을 못하네...? Why...?

/*
	문자열 표현 방법
	-String
	
	let name1 = "Kim";
	let name2 = 'kim';
	let	name3 = `kim`;	//backtick
	
	-escape 표현
	작은 따옴표 사용시 \(백슬래시)를 넣으면 `를 특수문자로 인식함
	
	let message1 = "I'm a boy.";
	let message2 = "I\'m a boy.";
	
	문자열 내부에 변수를 표현할 때 backtick을 사용하면 편함
	${변수명} 으로 표현함
	
	let message3 = 'My name is ${name1}';
	document.write(message3 + '<br>');
	
	let message4 = "My name is ${name1}";
	document.write(message4 + '<br>');	// ${name1}이 그대로 문자열로 취급됨
	
	계산식도 사용가능
	let message5 = 'I am ${100 + 99} years old';
	document.write(message5 + '<br>');
	document.write('------------------------<br>');
	
	-숫자형 Number(정수/실수 모두 처리가능)
	let age =100;
	let height=180.5;
	
	사칙연산 가능
	
	document.write(1+2+"<br>");
	document.write(1-2+"<br>");
	document.write(1*2+"<br>");
	document.write(1/2+"<br>");
	
	$$ DivideByZero는 JS에서 infinity로 처리함$$
	let a = 1/0;
	document.write(a);
	
	let b = name1 / 2;
	document.write(b + "<br>");	//NaN : Not a Number
	
	+연산자로 글자끼리 이어주는것도 가능함
	let aa ="나는";
	let bb ="입니다.";
	document.write(aa + name1 + bb + '<br>');
	document.write(aa + '20' + '살' + '<br>');
	
	-논리형 Boolean
	let c = true;
	let d = false;
	
	-Null, Undefined
	let e;
	document.write(e + '<br>'); // undefined : 아직 변수의 값이 할당되지 않은 상태
	
	let f = null;
	document.write(e + '<br>');	// Null : 존재하지 않는 값
	
	typeof 연산자 : 변수의 자료형을 알아낼 때 사용
	//특정 변수의 데이터 타입을 알아야할 때, API로 받아온 데이터의 자료형을 알아내서 다른 방식으로 처리해야 할 때
	
	document.write(typeof name1 +'<br>');
	document.write(typeof message1 +'<br>');
	document.write(typeof c +'<br>');
	document.write(typeof e +'<br>');
	document.write(typeof f +'<br>');	//NULL 값을 하나의 객체로 보고있음
	
*/
let name1 = "Kim";
let name2 = 'kim';
let	name3 = `kim`;

let message1 = "I'm a boy.";
let message2 = "I\'m a boy.";
let message3 = 'My name is ${name1}';
document.write(message3 +"<br>");

let a = 1/0;
document.write(a +"<br>");

let b = name1 / 2;
document.write(b + "<br>");	//NaN : Not a Number

let age =100;
let height=180.5;

let aa ="나는";
let bb ="입니다.";
document.write(aa + name1 + bb + '<br>');
document.write(aa + '20' + '살' + '<br>');

document.write( (name1 == "Kim")  + '<br>');
document.write( (age<20) + '<br>');
document.write('---------------<br>');

let e;
document.write(e + '<br>');

let f = null;
document.write(f + '<br>');

document.write(typeof name1 +'<br>');
document.write(typeof message1 +'<br>');
document.write(typeof c +'<br>');
document.write(typeof e +'<br>');
document.write(typeof f +'<br>');
