/*
10. 객체

사람이라는 객체를 하나 만들어보기
속성 : 이름, 나이

*/

//JS에서 객체는 {}로 표현함
let human={
	name:"Seok",
	age: 26
}

//객체는 중괄호 안에서 구성되며, key와 value값으로 구성된
//property가 들어감(개체를 표현 할 수 있는 속성)
//ex) name(key) Seok(value)
//각각 쉼표로 속성을 구분

//객체 속성에 접근 - 이렇게 2가지 방식으로 가능
console.log(human.name);
console.log(human['age']);

//속성 추가하기
human.gender = "Male";
human['hairColor']="black";

//속성 삭제하기
delete human.hairColor;
////////////////////////////////

//단축 property
//이 때, 조건은 key와 value에서 받아올 변수의 이름이 같아야 단축 표현이 가능
let name = "Jin";
let age = 9;

/*let person = {
	name: name,
	age: age,
	gender: "Male"
}*/

let person = {
	name,
	age,
	gender: "Male"
}

//존재하지 않는 속성에 접근하는 경우 -> undefined 반환
console.log(person.nickname);
	
//이 때, 'in' 연산자를 사용하면 내가 찾는 속성이 있는지 없는지 확인할 수 있음
//	in : 어떤 값이 있는지 없는지 확인하는 용도
console.log('birthday' in person);
console.log('age' in person);

//in 을 활용한 반복문
for (let key in person){
	console.log(key);	//key값을 불러오기
	console.log(person[key]);	//key에 해당하는 값 불러오기
}

//함수로 객체 만들기
function makeObject(name,age){
	return{
		name,
		age,
		hobby: "Game"
	}
}

let kim = makeObject("Kim",5);
console.log(kim);
