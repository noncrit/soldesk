/*
쿠키(Cookie)
쿠니는 서버가 사용자의 웹 브라우저에 전송하는 작은 데이터 조각
브라우저는 이 데이터 조각을 저장해 놓았다가
동일한 서버에 재요청할 때 저장된 데이터를 함께 전송하게 됨
*/

/*
특징
key-value 형태의 데이터
브라우저에 저장되는 데이터
쿠키의 만료시간이 무한일 경우 => 브라우저가 종료되어야 쿠키가 사라짐

브라우저는 매 요청마다 서버에 쿠키를 동봉해서 보내주는데

쿠키가 없거나 만료되었을 경우
서버가 응답을 보낼 떄 쿠키를 새롭게 생성해서 보냄

쿠키가 있는 경우
쿠키로 사용자 상태 식별이 가능함
*/

//npm install nunjucks chokidar => view 관련된 템플릿 제공
//npm install morgan cookie-parser express-session

const express = require('express');
const morgan = require('morgan');
const cookieParser = require('cookie-parser');
const nunjucks = require('nunjucks');

const app = express();
app.use(morgan('dev'));

app.use(cookieParser()); 
//get 방식의 요청이 들어오면 uri 변수들이 파싱됨
//req.cookies 객체에 저장됨

//views 폴더에 템플릿 가져오는 역할
app.set('view engine', 'html');
nunjucks.configure('views',{
    express: app,
    watch: true,
});

//서버에서 JSON 데이터를 파싱하여 JS 객체로 사용
app.use(express.json());
app.use(express.urlencoded({extended:true}));

app.get('/', (req,res)=>{
    
    //중괄호 안에 변수?!
    //1. 변수 할당의 용이성 : 객체나 배열에서 필요한 값만 뽑아내서 변수로 할당
    //2. 파라미터 값에 쓸 때 활용이 용이함 : 
    //함수의 파라미터로 전달된 객체에서 필요한 값만을 뽑아와서 사용 가능
    //지금은 2번으로 사용함
    const {user} = req.cookies;

    if(user){
        res.render('login',{user});
        return; //이 이후로 코드가 더 실행되면 안되니
    }

    res.render('index');
});

//post 요청을 했을 때 쿠키가 생성되도록
app.post('/', (req,res)=>{
    //요청객체는 req.body에 들어감
    const {name} = req.body

    //쿠키 생성
    //user 라는 이름의 쿠키 생성
    //대괄호는 옵션
    res.cookie('user', name, {
        expires: new Date(Date.now()+900000), //만료 시간(밀리초 기준)
        httpOnly: true, //true 설정시 js를 통해 쿠키에 접근 불가(네크워크로만 접근 가능)
        secure: false, // https 인경우에만 쿠키 전송되도록 하는 옵션
        //maxAge : 초단위로 쿠키에 대한 만료 기간 설정
    }).redirect('/');   //기본 주소값으로 쿠키 전송(redirect)
});

//로그아웃 구현
app.get('/delete', (req,res)=>{
    //쿠키 삭제 : 파라미터로 삭제할 쿠키의 이름 넣기
    //쿠키 삭제하고 첫 페이지로 돌아가기
    res.clearCookie('user').redirect('/');
});

app.listen(3000, ()=>{
    console.log('서버 실행중');
});