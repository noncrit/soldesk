/*
7. 반복문(Java와 동일함)

1~10까지 출력(document.write()사용해서 for,while, do while)

반복문 탈출

break : 반복문을 멈추고 빠져나옴
continue: 해당 반복문을 멈추고 다음 반복으로 넘어가서 다시 반복 실행
return : (추천은 안하는 방식) 반복문이 돌아가던 함수 자체가 종료됨

*/

let i=0;

for(i=1;i<11;i++){
	document.write(i+' ');
}

document.write('<hr>');
 
let j=1;
while(j<11){
	document.write(j+' ');
	j++;
}

document.write('<hr>');

let k=1;
do{
	document.write(k+' ');
	k++;
}while(k<11)
