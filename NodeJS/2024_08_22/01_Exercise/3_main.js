/*
만들어둔 모듈을 가져와서 사용하는 것을 로드(load)라고 함

*/
// require('./2_math-tools.js');

// require는 모듈을 로드해주는 함수
// 파라미터로 2_math-tools 모듈의 상대 경로를 적음
// require 함수는 모듈을 로드해서 객체 하나를 리턴하는 성질이 있음
// 경로에서 js 확장자는 생략 가능

//하나의 모듈에서 다른 모듈을 불러오는 방식(객체에 저장)
// let m = require('./2_math-tools.js');

// console.log(m.add(1,2));
//에러 발생 Why?
//2_math-tools 라는 모듈의 add가 외부에서 사용될 수 있도록 공개 선언을 해줘야함 

//공개한 것들 모두 불러오기
//일반적으로 const로 상수화 시켜서 모듈을 불러옴 (변수 재사용 방지)

const m = require('./2_math-tools');


// console.log(m.PI);
// console.log(m.add(1,2));
// console.log(m.sub(3,4));
// console.log(m.mul(3,4));
// console.log(m.div(6,2));

// 하나하나 exports 했던 것들을 하나의 객체로 만들고
// 객체 자체를 공개해버리는 방법도 가능

const calculator = require('./2_math-tools');
console.log(calculator.PI);
console.log(calculator.add(1,2));
console.log(calculator.sub(4,3));


