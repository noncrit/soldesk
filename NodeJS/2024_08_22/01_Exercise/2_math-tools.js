/*
모듈(Module)이란 ?
하나의 프로그램을 이루는 하나하나의 조각
일반적으로 하나의 JS 파일 하나를 말함 - 라이브러리 느낌

1. 내가 직접 만든 모듈
    말 그대로 내가 만든 모듈

2. 남이 만들어둔 모듈
    - 외장 모듈
    개발자들이 만들어둔 모듈
    이 외장모듈을 사용하기 위해서는 npm에 접속해야함
    JS 개발자들이 유용한 패키지들을 만들어두었고,
    그 코드들이 공개되어있는 곳이 NPM
    서드파티 모듈(3rd-party Module)이라고도 부름


    - 내장 모듈
    Node를 설치하고 나면 기본적으로 제공해주는 모듈
    따로 NPM을 사용하지 않음
    Core 모듈이라고도 부름
*/

// function add(a,b){
//     return a+b;
// }

// add 함수를 모듈 외부에서도 접근할 수 있도록 공개하기
// export

// exports.add = add;
//앞쪽 add : 모듈 외부에서 접근 할 때 사용할 이름
//뒤쪽 add : 모듈 내부에서 내보낼 함수의 이름

// exports.PI = 3.141592;
// exports.add = function add(a,b){return a+b};
// exports.sub = function sub(a,b){return a-b};
// exports.mul = function mul(a,b){return a*b};
// exports.div = function div(a,b){return a/b};

//객체로 표현하기
let calculator ={
    PI : 3.141592,
    add: (a,b) => a+b,
    sub: (a,b) => a-b,
    mul: (a,b) => a*b,
    div: (a,b) => a/b,
}

// exports.calculator = calculator;
module.exports = calculator;
/*
위에서 만든 내용들을 전부 다 하나의 객체에 넣어버렸음
calculator 라는 객체의 속성과 메소드가 되었음
또한 이 객체 자체를 그대로 외부에 공개한 상태

exports : 공개하고 싶은 것을 하나씩 공개할 때 사용
ex) exports.속성=값

module.exports : 공개하고 싶은 것들을 모아서 하나의 객체로 만들어서 공개
module.exports = 객체

*/

