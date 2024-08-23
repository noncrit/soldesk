const express = require('express');
const path = require('path'); //HTML 응답을 위한 path 설정

const app = express(); //객체 생성
const port = 3000;

//get 방식 요청
app.get('/',(req,res)=>{
    res.send('익스프레스 켜졌냐?');
});

//url 추가하기 - 변경된 내용은 서버 껐다 켜줘야함
app.get('/kim',(req,res)=>{
    res.send('아이엠 그루트!')
});


//동작 확인
app.listen(port, ()=>{
    console.log(`Express가 ${port}번 포트에서 동작중!`)
});

//내용 변경한거 자동 반영(서버 on/off 안해도 되도록)
//nodemon 설치
//npm install -g nodemon

//라우터(Router)
//클라이언트의 요청 경로를 보고(path) 해당 경로로 패킷을 넘겨주는 역할
//Routing : 네트워크 안에서 데이터를 보낼 경로를 선택하는 과정

//단순한 문자열 대신 HTML로 응답을 하고싶다!
//res.sendFile() 메소드를 활용하면 가능
//파일의 경로를 path 모듈을 사용해서 지정해두면 된다.

app.get('/success', (req,res)=>{
    // __dirname : 현재 경로 위치
    res.sendFile(path.join(__dirname, '/index.html'));
});
