/*
6. 조건문
	어떤 조건에 따라서 이후에 실행이 달라지게 하는 문법
	
	if문 (Java와 동일함)
	if 절 괄호안에 조건을 따져서 true 라면 실행
	
	if, else if, else 똑같음
	
	예제 생략
	
	switch - case
	장점 : case가 다양할 때, 보다 간결하게 나타낼 수 있다.
	
	switch(변수명 or 값){
		case 값1:
			코드 내용
		case 값2:
			코드 내용
		...
		default:
			코드 내용
	}
	
	사과 100원
	바나나 200원
	키위 300원
	멜론 500원
	수박 500원
	사고싶은 과일을 입력(prompt)해서 그 가격을 출력(alert)

*/

let fruit_name=prompt("과일 이름을 입력해주세요.");

switch(fruit_name){	//작은 따옴표 말고 ` 이거 써야함!!
		case '사과':
			alert(`${fruit_name} : 100원`);
			break;
		case '바나나':
			alert(`${fruit_name} : 200원`);
			break;
		case '키위':
			alert(`${fruit_name} : 300원`);
			break;
		case '멜론':
			alert(`${fruit_name} : 500원`);
			break;
		case '수박':
			alert(`${fruit_name} : 500원`);
			break;
		default:
			alert(`${fruit_name} : 과일 맞음?`);
			break;
}
	
