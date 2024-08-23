/*
미들웨어 (MiddleWare)
Express의 핵심 기능 중 하나

공식문서에 따르면 요청 객체(req), 응답 객체(res),
애플리케이션의 요청-응답 주기 중
미들웨어 함수에 대한 액세스 권한을 갖는 함수이며,
일반적으로 next라는 이름의 변수로 표현한다.

미들웨어 : 요청과 응답의 중간(middle)에서 작동하기에 middleware라고 부름
요청과 응답을 조작해서 기능을 추가하기도 하고,
잘못들어오거나 나쁜 요청을 걸러내는 역할을 함
*/

/*
app.use(미들웨어) 의 형태로 사용
파라미터 자리에는 req,res,next 로 묶인 함수를 넣어주면 된다.
코드는 위-> 아래로 순차 진행된다.
요청 - 응답 사이에 기능 추가 가능
next : 다음 미들웨어로 넘어가라는 파라미터, 심어두지 않으면 다음 미들웨어로 넘어가지 않음
*/

/*
미들웨어가 실행되는 경우
app.use(미들웨어) : 모든 요청에서 미들웨어 실행
app.use('/acb/', 미들웨어) : abc로 시작하는 모든 요청에서 미들웨어 실행
*/

const express = require('express');
const app = express();

//미들웨어 호출
app.use((req,res, next)=>{
    console.log('모든 요청에 대해 실행됨!');
});

app.get('/',(req,res,next)=>{
    console.log('실행중');
}), (req,res)=>{
    //일부러 에러 발생시키기
    throw new Error('에러는 에러처리 미들웨어로 갑니다~~');
};



app.listen(3000, ()=>{
    console.log('3000번 포트입니다.');
});

//에러처리를 위한 미들웨어 : 파라미터가 4개
//err에는 에러에 대한 정보가 들어있음
//express가 에러를 기본적으로 처리하기는 하지만
//실무에서는 직접 처리방향을 지정하는게 좋다.
//에러처리 미들웨어는 코드의 제일 아래쪽에 위치하는 것이 좋다.
app.use((err,req,res,next)=>{
    console.err(err);
    res.status(500),send(err.message);
});