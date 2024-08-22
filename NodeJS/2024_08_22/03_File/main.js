const fs = require('fs');

/*
파일 쓰기

writeFile() : 파일이 존재하지 않으면 파일을 생성하고 내용을 적어냄, 단 이어쓰기 기능 X (appendFile())
*/

let data = '파일 시스템 예제!';

// console.log('파일을 생성합니다.')

// fs.writeFile('text1.txt', data, 'utf-8', function(error){
    
//     if(error){
//         throw error
//     }
//     //정상적으로 실행되었으면
//     console.log('파일이 생성되었습니다.')

// })
// console.log('파일 생성 중 .....')

 
// //파일을 생성합니다
// //파일 생성중
// //파일이 생성되었습니다.

// /*
// 이렇게 소스코드의 작동 순서가 위-> 아래 순서대로 작동하지 않는 상황
// 비동기 처리(Asynchronous)

// 작업시간이 오래 걸리는 I/O 작업같은 경우 우선 순위를 뒤로 밀어버리는 식으로
// 처리 지연시간을 최소화함
// */

// fs.unlink('text1.txt', function(error){
//     if(error){
//         throw error
//     }
//     console.log('파일 삭제 성공');
// })

//난 렉이 걸려도 순서대로 진행되는게 좋다!
// fs.writeFileSync();

console.log('파일을 생성합니다.');
console.log('파일 생성 중');
fs.writeFileSync('text1.txt', data); //기본 인코딩이 utf-8
console.log('파일이 생성되었습니다.');

//파일 읽기
fs.readFile('text1.txt', 'utf-8', function(error){
    if(error){
        throw error
    }
    console.log('파일 읽기 성공');
})

//파일 이어서 쓰기
fs.appendFile('text1.txt','\n데이터추가하기',function(error){
    if(error){
        throw error
    }
    console.log('에이')
})


