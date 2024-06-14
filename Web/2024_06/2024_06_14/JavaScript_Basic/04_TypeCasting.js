//수학점수, 영어점수를 입력받아서 평균 점수를 출력해주는 프로그램

let math_score = prompt("수학 점수를 입력해주세요 : ");
let eng_score = prompt("영어 점수를 입력해주세요 : ");

document.write(typeof(math_score)+"<br>");
//prompt로 받은 값은 무조건 문자열(String)
//"80"+"90"="8090"/2 = 4045 //왜 문자열이 나누기로 계산이 될까..?
// JS의 특징 => 숫자형이 아니더라도 표현식(+,-,*,/)을 활용했을 때, 숫자형으로 변환할 수 있다면,
// 자동으로 자료형이 형 변환 되어서 계산됨=>'자동 형 변환'
// 자동이라 좋은걸까? => 원인을 찾아내기 힘든 에러의 원인이 될 수도 있음..상상만해도 끔찍...
// 항상 의도를 가지고 원하는 타입(자료형)으로 변환해서 사용하는 것이 안전함 => '명시적 형 변환'

/*	
	4. 형 변환
	String() : 문자형으로 변환
	Number() : 숫자형으로 변환
	Boolean(): 논리형으로 변환
	
	형 변환은 왜 필요할까??
	위의 예시처럼 숫자를 의도하고 입력받았는데 문자를 받은 경우=>형 변환이 필요함
	자료형이 다른 두 변수를 계산했을 때, 원하는 결과가 나오지 않을 수 있음
	
	String(): 첫글자 S는 대문자로 작성!/ 괄호안의 값을 문자형으로 바꿔줌
	document.write("String() <br>");
	document.write(
	String(3) + "<br>",
	String(true) + "<br>",
	String(false) + "<br>",
	String(null) + "<br>",
	String(undefined) + "<br>"	
	);
		
	Number(): N은 대문자 / 괄호 안의 값을 숫자형으로 바꿔줌
	document.write("Number() <br>");
	document.write(
	Number("1234") + "<br>",
	Number("asdf") + "<br>",
	Number(true) + "<br>",
	Number(false) + "<br>"
	
	Boolean(): B는 대문자 / 괄호안의 값을 논리형으로 바꿔줌
	false 값 나오는 경우만 알아두면 그 외에는 모두 true
	- 숫자 0
	- 비어있는 문자열(공백 제외, 띄어씌도 값이 있음)
	- NULL
	- Undefined
	- NaN
	
	*주의사항*
	Number(null); 		// 0
	Number(undefined);	// NaN
	
);
*/	

document.write(`수학 점수 : ${math_score} <br>`);
document.write(`수학 점수 : ${eng_score} <br>`);

let avg = (parseInt(math_score) + parseInt(eng_score))/2;

document.write(`평균 점수 : ${parseFloat(avg)}`+`점` + `<br>`);

document.write("String() <br>");
document.write(
	String(3) + "<br>",
	String(true) + "<br>",
	String(false) + "<br>",
	String(null) + "<br>",
	String(undefined) + "<br>"	
);
document.write("--------------------<br>");

document.write("Number() <br>");
document.write(
	Number("1234") + "<br>",
	Number("asdf") + "<br>",
	Number(true) + "<br>",
	Number(false) + "<br>"
);
document.write("--------------------<br>");

let a = Number(prompt("asdf"));
document.write(a + '<br>');
//프롬프트에 입력이 없으면 a = null / Number(null) => 0으로 변환


