/*
11. 배열
	순서가 있는 리스트
*/

//JS의 배열은 대괄호로 표현
let students = ["곽두팔", "이춘식", "김춘삼"];
//JS의 인덱스는 0부터 시작함
console.log(students[1]);

//배열은 문자뿐만 아니라 숫자, 객체, 함수 ... 를 포함할 수 있음
let arr =[
	"비버",
	3,
	false,
	{
		name:"비붜",
		age:7
	},
	function test(){
		console.log("test");
	}
];
console.log(arr);

//배열의 길이 확인
console.log(arr.length);

let days=["월", "화", "수"];
console.log(days);

//push() : 배열 끝에 요소를 추가 (, 로 구분해서 여러 개 추가 가능)
days.push("목");
console.log(days);

//pop(): 배열 끝 요소 제거(스택이랑 비슷한듯?)
days.pop();
console.log(days);

// shift(), unshift : bitwise 비슷, 배열의 제일 앞에 요소 제거/추가
days.unshift("일");
console.log(days);

days.shift();
console.log(days);

//unshift()는 요소 여러 개 추가 가능
days.unshift("목","금","토");
console.log(days);

let today = new Date();
console.log(today);