//자주 사용하는 미들웨어들

//npm install morgan cookie-parser express-session

const express = require('express');
const morgan = require('morgan');
const path = require('path');

const app = express();

//morgan - 요청과 응답에 대한 정보를 콘솔에 알려줌
app.use(morgan('dev'));
/*
GET / 200 4.855 ms - 22
[요청방식] [주소] [응답상태 코드] [응답 속도] - [응답 바이트]
*/

// app.get('/', (req,res)=>{
//     res.send('연결되었습니다.');
// });

//html 내용은 불러와지는데 index.css는 적용이 안됨
//GET /index.css 404 0.798 ms - 148
app.get('/',(req,res)=>{
    res.sendFile(path.join(__dirname, '/index.html'));
});

//css의 적용을 위해 static이라는 미들웨어가 필요함
//css, javaScript 같은 정적 파일을 넘겨주는 역할을 함
//app.use('요청경로', express.static('실제 경로')); 로 사용

// css 폴더 하나 만들어서 css 파일 넣어주기
app.use('/', express.static(path.join(__dirname, 'css')));

//주소값 뒤에 css 파일명 입력하면 내용이 나옴 
//-> 서버상의 파일 경로와 실제 파일 경로가 다름
//제 3자가 파일 구조를 파악하기 어렵게함


app.listen(3000, ()=>{
    console.log('3000번 포트에 연결됨');
});
