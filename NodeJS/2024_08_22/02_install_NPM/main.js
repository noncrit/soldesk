/*
NPM은 Node Package Manager 의 약자로,
Node로 생성한 패키지/프로젝트를 관리하는 도구
*/

// npm init -y : npm을 쓸 수 있는 초기 환경을 설정
// -y : 일일히 y 입력하는거 말고 일괄 기본값으로 설정한다는 옵션
// 그리고 이 패키지의 설정 정보가 package.json에 들어감

/*
{
  "name": "02_install_npm", //프로젝트의 이름
  "version": "1.0.0",       //프로젝트의 버전
  "main": "main.js",        //진입점이 되는 모듈명
  "scripts": {              //스크립트 명령어들 모음
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],           //패키지를 문자열 배열로 설명해 줌
  "author": "",             //작성자
  "license": "ISC",         //패키지에 대한 권한
  "description": ""         //이 프로젝트에 대한 설명
  "dependencies":""         //모듈 의존성 관리
}
*/

//npm install cowsay

/*
package-lock.json 이 생기고, package.json 둘 다
cowsay에 대한 dependencies가 생긴 것이 확인됨

package-lock.json : 
나중에 이 프로젝트를 배포할 때, 이 프로젝틑에 필요한 모듈의 버전을 명시해둔 파일
이걸 토대로 다른 컴퓨터에서 이 프로젝트를 실행할 때
그 내용을 바탕으로 npm install 명령을 실행하면 관련 모듈들이 한번에 설치됨

*/

const cowsay = require('cowsay');
console.log(cowsay.say({
  text : 'I love Sogogi',
}));

