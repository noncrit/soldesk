/*
	자료형(데이터 타입)
	-크게 3가지의 타입으로 나눌 수 있음
	
	-문자형 : char(용량), varchar2(용량)
		char :	무조건 지정한 용량대로 데이터를 저장함(공간이 남으면 그 공간 전부를 공백으로 채움)
				저장 공간 할당에 신경을 덜 쓰기 때문에 처리속도가 빠름
				값이 확실하게 고정될 수 있는 데이터에 대해서는 varchar보다 유리함
		
		varchar2 :정해진 용량보다 데이터가 덜 들어오면 저장공간 크기를 알아서 조정함(동적 할당)
				  용량을 확인한 뒤 조정까지 거치기 때문에 속도가 상대적으로 느림
				  보통은 char대신 이쪽을 많이 씀
------------------------------
	문자형 용량 표기 방법
		varchar2(5)	: 5byte 할당
			영어, 숫자, 띄어쓰기는 1byte
			한글 한글자는 3byte
			글자수 계산하기가 애매...
		
		varchar2(5 char) : 글자 5개 할당
			한글/영어 5글자 => 최대 15byte 표현가능
				 							
		문자 자료형 쓸 때는 char로 확실히 해주자

*/

create table test(
	t_name varchar2(5)
);

create table test2(
	t_name varchar2(5 char)
);

--문자형의 값을 넣을 때는 작은따옴표 꼭 넣기 => 헷갈린다...

insert into test values('가나다');
insert into test2 values('가나다');

drop table test cascade constraint purge;
drop table test2 cascade constraint purge;

--------------------------------------------------
/*
	숫자형 자료형
		NUMBER(P,S)	: 십진수를 기준으로 표현
			P : 정밀도(Precision), 소수점 기준 모든 유효숫자 기준치, P에 명시된 것보다 더 큰 숫자를 입력하면 오류 발생
			S : 범위(Scale), S가 양수면 소수점 이하값, S가 음수면 소수점 이상(정수 부분)의 유효자리를 나타냄
				S에 명시한 숫자 이상의 수가 입력되면 S에 명시한 숫자 기준으로 반올림 처리함
				S가 음수면 소수점 기준 왼쪽 자릿수만큼 반올림
				
				P가 S보다 크면 S는 소수점 이하 유효숫자 자릿수를 나타냄
		ex) 123.54
		number(3);		124		// 정수값 3자리만 표현하겠다는 뜻, number(3,0)과 똑같음
		number(3,2);	오류 발생	// X.XX 형태로 입력받겠다는 선언 (근데 P=3인데 입력값의 유효숫자는 5자리임)
		number(5,2);	123.54	// XXX.XX 
		number(7,1);	124.0(오답)// XXXXXX.X	>> 123.5
		number(7,-1);	120		// 십의 자리까지 보여주겠다(소수점 왼쪽 첫 자리인 일의 자리에서 반올림)	>> 120
		
		FlOAT(P)	: NUMBER의 하위 타입, 이진수 기준 표기
		
*/

create table testNum(
	t_num number(5),
	t_flo float(5) 	--5자리 이진수를 의미함, 실제로는 float(1.5) = > float(2) 반올림 됨, 나머지는 0으로 채워진 상태
					--그래서 12000 표기됨
					--사실상 number만 잘 써도 큰 상관은 없음
);

insert into testNum values(12345,12345);

select * from testNum;

drop table testnum cascade constraint purge;
		
/*
 	날짜 타입 자료형
 	
 		Date	: 연도, 월, 일, 시, 분, 초까지 입력이 가능함
 		
 		Timestamp: 연도, 월, 일, 시, 분, 초, 밀리초까지 입력 가능
 		
 		주력은 Date 사용함 ->java.util.date, java.sql.date 끌어와서 씀
 
 
 */
		
			
