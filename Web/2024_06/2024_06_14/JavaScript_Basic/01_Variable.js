/*alert('성공!');*/

/*	JavaScript
	Netscape 사에서 만들었고, 원래 이름은 LiveScript였음
	Java가 인기가 매우 높던 90년대 중반에 만들어짐 => Java에 한번 탑승해보자 => JavaScript로 개명
	그냥 이름만 Java 가져다 붙인 놀라운 언어...
	
	JS는 인터프리터 언어 -> 오타나도 무조건 실행...
	
	1.변수
	변수에 접근하는 방법
	-alert()			: 경고창을 띄워주는 함수
	-console.log()		: 로그를 띄워주는 함수
	-navigator,window,document -> 모두 웹 페이지 창을 의미하는 객체
	-documnet.wirte()	: 웹페이지에 내용을 출력
	
	변수명 = 값 방식 => 위험함 (전역 변수 선언이기 때문)
	name ="Kim";
	age = 26;
	
	방지책으로 사용하는 친구들 = var, let, const
	
	★var : variable의 앞 3글자
		=> 변수의 이름을 중복해서 선언 가능 + 초기화까지 가능
		=> 마지막에 할당된 값이 들어감
		=> 기존에 선언해 둔 변수를 까먹고 다시 값을 할당하는 실수가 발생할 수도 있음
		var a = 10;	
		console.log(a);
		var a =20;
		console.log(a);
		var a =30;
		console.log(a);
		var a;	//마지막에 선언한 30이 들어감
		console.log(a);
	
	★let :	Java에서 변수 만들때랑 같은 느낌 
		=>변수명 중복 불가(전역변수와도 겹치면 안됨)
		=>한번 선언한 이후에도 값 변경 가능함
		let name="kim";
		console.log(name);
		
		//아래쪽 let은 구문오류가 발생함(이미 let에서 name으로 선언되어 있기 때문에 에러가 발생함)
		let name="kim"2;
		console.log(name);
		
		let grade = "F";
		console.log(grade);
		grade="A";
		console.log(grade);
		
	★const	: 값이 절대로 바뀌어서는 안되는 상수값을 넣을 때 사용함
		=>값 수정 불가, 수정하려고 접근시 에러 발생함
		=>파이값, 최대/최소값, 생일 등등.....
		!!!!!!!!!const 변수명은 꼭 대문자로!!!!!!!!!!!
		
		const PI = 3.141592;
		console.log(PI);
		
		//이미 선언된 const에 접근해서 값을 바꾸려고 시도->에러 발생
		PI = 6.141592;
		console.log(PI);
		
	SUMMARY
	-변할 수 있는 값은 var,let
	-변하지 않는 값은 const로 선언
	
	JS 변수명 지정 가능한 조건(Java와 동일함)
	1. 변수는 문자와 숫자, $,_ 까지 사용가능
	2. 첫 글자가 숫자로 시작해서는 안됨
	3. 예약어 변수로 사용 불가
	4. 변수명은 읽기 쉽고 다른 사람이 봐도 이해할 수 있게!!
	5. !!!!!const 변수명은 항상 대문자로 만들기!!!!!
*/

//변수 선언
var a = 10;	
console.log(a);
var a =20;
console.log(a);
var a =30;
console.log(a);
var a;
console.log(a);

let name="kim";
console.log(name);

console.log(name);
		
let grade = "F";
console.log(grade);
		
grade="A";
console.log(grade);

const PI = 3.141592;
console.log(PI);
		
PI = 6.141592;
console.log(PI);
