/*alert('성공!');*/

/*
5. 연산자
	산술 연산자(+,-,*,/)
	
	거듭제곱을 자체적으로 표현 가능(곱셈기호 2번)
	
	let num1 = 2**3; //2의 3제곱
	
	산술연산자의 우선순위
	(*,/) > (+, -)
	
	연산자를 줄여서 쓰는 것도 가능함
	let num1 = 10;
	num+=5;
	
	증감 연산자
	++,--
	
	
	let num2=20;
	num2++; 
	document.write(num2);
	
	******중요!!!!!!**********
	//후위 증감 연산자 : 변수의 현재 값을 사용, 그 후에 변수의 값을 증가시킴
	//대입 연산자가 먼저 작동 => 그 후에 증감 연산자가 처리됨
	let result = num2++;
	document.write(result);
	
	//전위 증감 연산자
	//변수의 값을 증가시키고, 그 후에 변수의 값을 사용
	//증감 연산자 처리 => 대입 연산자 작동
	let result2 = ++num2;
	document.write(result2);
	
	비교 연산자(Java 때와 같음)
	< > >= <= == !=
	document.write('<br>------------<br>');
	document.write( (10>5) + '<br>'); //true
	document.write( (10<5) + '<br>'); //false
	document.write('<br>------------<br>');
	
	문자열 "10"과 10이 같을까?
	document.write( ("10"==10) + '<br>');//true
	자동 형 변환 때문에 True가 리턴됨
	
	등호 3개 ===, !== (일치 연산자): 값, 자료형까지 비교해라
	document.write( ("10"===10) + '<br>'); //true?
	
	논리 연산자
	||(OR) : 여러개 중 하나라도 true이면 무조건 true 반환( 모두 false 여야 false가 반환됨)
	=>첫번째 true값을 발견하면 연산을 멈추고 true 반환
	
	&&(And): 모든 값이 true여야 true를 반환(하나라도 false 라면 즉시 false를 반환)
	=>첫번째 false 값을 발견하면 연산을 멈추고 false 반환
	
	!(Not) : 반대의 값을 반환
	
	
	
	
	
	
*/
//let num1 = 2**3;
//alert(num1);

let num1 = 10;
num1+=5;

let num2=20;
//num2++;
//document.write(num2);

let result = num2++;
document.write(result);

let result2 = ++num2;
document.write(result2);

document.write('<br>------------<br>');
document.write( (10>5) + '<br>'); //true
document.write( (10<5) + '<br>'); //false
document.write('<br>------------<br>');

document.write( ("10"==10) + '<br>');//true
document.write( (String(10)==Number(10)) + '<br>'); //true?
document.write( ("10"===10) + '<br>'); //False
