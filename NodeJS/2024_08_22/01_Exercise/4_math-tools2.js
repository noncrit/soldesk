/*
JS 파일 하나가 모듈 하나
그런데 Node.js가 모듈을 load 하는 과정에서 자동으로 해주는 작업이 있음
'Module Wrapper Function'
모듈 내의 전체 코드를 감싸주는 작업
(function (exports, require, module, __filename, __dirname)){
    모듈 코드 ...
}
의 형태

예를 들어
function add(a,b){
    return a+b;    
}
exports.add = add;
이런 코드가 있을 때

(function (exports, require, module, __filename, __dirname)){
    function add(a,b){
        return a+b;    
    }
}
이렇게 감싸는 식

*/

function add(a,b){
    return a+b;
}

//함수 내부 속성 확인
//console.dir 은 특정 객체의 내부 속성을 출력해주는 함수
console.log('exports -----------');
console.dir(exports);
console.log('require------------');
console.dir(require);
console.log('module-------------')
console.dir(module)
console.log('__filename------------');
console.dir(__filename)
console.log('__dirname------------');
console.dir(__dirname)

/*
exports 객체에는 아무 속성(Property)도 들어있지 않고,
module 객체에는 다양한 속성이 존재함
module 객체 안을 잘 보면 exports 라는 속성이 있고
그 속성은 비어있는 객체를 하나 가지고 있음
출력한 객체들 중 exports 객체 (맨 위)와 module 내부의 exports 객체는 동일한 객체임

즉, exports, module.exports 모두 해당 객체에 접근하는 식으로 구현된 것을 알 수 있음
*/

//함수 공개하고 난 뒤 속성들 다시 살펴보기
function add(a,b){
    return a+b;
}

exports.plus =add;

console.log('exports -----------');
console.dir(exports);
console.log('require------------');
console.dir(require);
console.log('module-------------')
console.dir(module)
console.log('__filename------------');
console.dir(__filename)
console.log('__dirname------------');
console.dir(__dirname)

/*
exports 객체에 plus 라는 속성이 추가되었고,
그 값이 add 함수인 것이 확인됨
module 객체의 exports 속성이 가리키는 객체도 당연히 똑같음
바로 이 객체가 다른 모듈에서 require 함수로 이 모듈을 로드 할 때 리턴되는 객체이다
ex)
main.js
const m = require('./4_math-tools2.js'); 로 로드하면
require 함수는 module 함수의 exports 속성이 가진 객체를 리턴하게 된다.
*/

/*
그럼 그냥 exports = 객체로 객체를 공개버리면 똑같은거 아닌가?

exports 객체와 module 객체의 exports 속성이 가리키는 객체는 분명히 동일한 객체가 맞음

하지만, require 함수는 module 객체의 exports 속성이 가리키는 객체를 리턴하기 때문에 
exports 객체를 아예 새로 설정하게 되면, 더 이상 기존 사용하던 객체에 접근 할 수 없게된다.

그래서 exports.속성 = 값 형태로만
객체의 속성만 추가하는 방법으로 사용이 가능

대신 module.exports를 사용하면,
module.exports = 객체
module.exports.속성 = 값 형태도 가능함
*/