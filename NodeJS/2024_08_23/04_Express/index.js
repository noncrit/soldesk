//NodeJS로 웹을 다루기 위해 http 모듈이 필요함(core module -> 기본적으로 내장되어 있음)
//Spring과 마찬가지로, 사용자는 요청하고 서버는 응답하는 구조

const http = require('http');

http.createServer((request, response)=>{
    response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'})
    response.write('안녕 서버야?');
    response.end();
}).listen(3000) //포트번호 설정, Node는 일반적으로 3000번 사용함

//localhost:3000으로 접속시 response 메시지 보이면 접속 성공

//http 모듈보다 성능이 더 좋은 모듈
//express
//python의 flask/Django, Java의 Spring/Springboot 처럼 일종의 프레임 워크의 하나
//코드의 양을 줄여주고, 유지보수가 용이하도록 만들어줌

//npm init -y 로 package.json 만들고
//npm install express
//package.json 파일에 dependencies 확인
//app.js 파일 하나 새로 생성