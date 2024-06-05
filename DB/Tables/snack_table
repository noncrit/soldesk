	create table jun3_snack(
		snack_number number(4)	primary key,
		snack_name varchar2(15 char) not null,
		snack_manufacturer varchar2(15 char) not null,
		snack_price number(10) not null
--		constraint PK_snack primary key(snack_name, snack_manufacturer)
	);
	select * from jun3_snack;
	select * from tab;
	drop table laptop;
/*
 	DML(Data Manipulation Language)라고 하고, 테이블에 **데이터를** 검색,삽입,수정,삭제 하는데 사용되는 문장
 	select, insert, update, delete 등이 있음 => 줄여서 CRUD 라고 부름 (Create, Read, Update, Delete)
 	(create table은 여기에 속하지는 않음) (DBA의 작업)
 	
 	insert into 테이블명(컬럼명, 컬럼명, ...) values(값, 값, 값....); 당연히 순서랑 파라미터 타입 맞춰야함

 */
insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(1, '초코파이', '오리온', 5000);

--컬럼의 순서를 다르게 넣어보기? ->파라미터 타입, 이름만 지켜주면 멀쩡히 들어감
insert into jun3_snack(snack_name, snack_number, snack_price,snack_manufacturer)
	values('새콤달콤', 3, 5000, '롯데');

--컬럼에 값을 안넣은 경우 > not null 걸려있어서 오류남(원래는 null값으로 들어는 감)
insert into jun3_snack(snack_name, snack_number)
	values('새콤달콤', 1);

--컬럼명 명시하는 부분 생략하고 테이블 생성 당시 컬럼명 순서대로 데이터 넣는것도 가능함
insert into jun3_snack values(2, '엄마손파이', '롯데',4000);

drop table jun3_snack cascade constraint purge;

----------------------다시 테이블 생성하고 값 5개 정도만 넣기

	create table jun3_snack(
		snack_number number(4)	primary key,
		snack_name varchar2(15 char) not null,
		snack_manufacturer varchar2(15 char) not null,
		snack_price number(10) not null
--		constraint PK_snack primary key(snack_name, snack_manufacturer)
	);
	
insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(1, '초코파이', '오리온', 5000);
	
insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(2, '이구동성', '오리온', 2000);
	
insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(3, '나쵸', '오리온', 2000);
	
insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(4, '몽쉘', '크라운', 5000);

insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(5, '새우깡', '농심', 1000);
	
select * from tab;
select * from jun3_snack;
DESC jun3_snack;	--Q. 테이블 구조 표현하는 옵션이라는데 이거는 못쓰나??

--근데 과자의 종류가 엄청나게 많을텐데 번호를 일일히 넣는다...?----
--나중에 까먹으면....?--
--그래서 자동으로 번호 부여 작업이 가능했으면 좋겠다!--

--factory pattern!!-- 번호를 순서에 맞게 자동으로 생성해보자 
--MySQL : AutoIncrement 
--OracleDB : Sequence
	--번호를 순서에 맞게 자동으로 생성해주는 방식인데 큰 단점이 있음
	--테이블과는 무관함!!
	--!!!! insert 에 실패해도 sequence 값이 무조건 올라감 !!! -> 대처하는 정렬 방법이 있음
	--그리고, 증가된 값을 다시 내릴 수 없음!!

--create sequence 시퀀스명; (간단한 버전)
--보통 테이블명_seq로 이름지음
create sequence jun03_snack_seq;

--옵션 붙은 시퀀스 선언
/*
 	create sequence 시퀀스명
 		increment by 1	--증가값 수치
 		start with 1	--시작값(초기화 값)
 		minvalue 1		--최소값(사이클 옵션을 사용 할 경우 최대값 도달 후 최소값으로 돌아와 다시 시작함)
 		maxvalue 99		--최대값
 		nocycle	/ cycle	--cycle/nocycle 최대값 도달시 반복 여부
 		nocache / cache	--캐시 사용 여부(미리 생성해둘지)
 		noorder	/ order	--요청 순서대로 값을 생성할지 말지
 */

--sequence의 삭제 - drop sequence 시퀀스명;

--실제로 써먹어보기
--시퀀스명.nextval

drop table jun3_snack cascade constraint purge;

	create table jun3_snack(
		snack_number number(4)	primary key,
		snack_name varchar2(15 char) not null,
		snack_manufacturer varchar2(15 char) not null,
		snack_price number(10) not null
--		constraint PK_snack primary key(snack_name, snack_manufacturer)
	);

--jun03_snack_seq;

insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(jun03_snack_seq.nextval, '초코파이', '오리온', 5000);
	
insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(jun03_snack_seq.nextval, '이구동성', '오리온', 2000);
	
insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(jun03_snack_seq.nextval, '나쵸', '오리온', 2000);
	
insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(jun03_snack_seq.nextval, '몽쉘', '크라운', 5000);

insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price )
	values(jun03_snack_seq.nextval, '새우깡', '농심', 1000);
	
select * from jun3_snack;
--select jun03_snack_seq.currval from dual; --작동을 안함...
--참고) Dual 을 오라클에서 기본 제공하는 일종의 더미 테이블임(찾아보고 정리하기)
--dual - 함수 계산 결과같은거 임시로 보고 싶을 때 변수 같이 사용하는 1x1 튜플

drop table jun3_snack cascade constraint purge;
drop sequence jun03_snack_seq;

--테이블 다시 만드는데, 속성 하나 추가 (유통기한 Date)
	create table jun3_snack(
		snack_number number(4)	primary key,
		snack_name varchar2(15 char) not null,
		snack_manufacturer varchar2(15 char) not null,
		snack_price number(10) not null,
		snack_best_before Date not null
--		constraint PK_snack primary key(snack_name, snack_manufacturer)
	);
	
	create sequence jun3_snack_seq;
	drop sequence jun3_snack_seq;
	select sysdate from dual; --dual 은 오라클 더미 테이블!! 1x1짜리로 변수처럼 사용함
	
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '새우깡', '농심', 1000, sysdate);
	
	select * from jun3_snack;
	
--유통기한 자리에 현재 시간을 알려주는 sysdate를 사용 할 수는 없음
--대신 to_date() 내장함수를 사용하자!
--to_date('값' , '패턴') 
--	패턴 : 무조건 대문자로 기입 - YYYY,MM,DD,PM,AM HH(12시간 기준),HH24(24시간 기준, 추천함),MI(분),SS(초) 등등
	
	--예시
--	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
--		values(jun3_snack_seq.nextval, '매운새우깡', '농심', 1000, to_date('2024-06-07 14', 'YYYY-MM-DD HH24') );	

	select * from jun3_snack;
--회사 3~4개, 회사당 과자의 종류도 5개씩, 유통기한도 다르게

	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '닭다리 너겟', '농심', 2000, to_date('2024-06-09 16', 'YYYY-MM-DD HH24') );
	
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '바나나킥', '농심', 1300, to_date('2024-06-11 10', 'YYYY-MM-DD HH24') );

	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '딸기바나나킥', '농심', 1400, to_date('2024-06-06 10', 'YYYY-MM-DD HH24') );
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '양파링', '농심', 2000, to_date('2024-06-05 17', 'YYYY-MM-DD HH24') );
	-----------------
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '쿠크다스', '크라운', 2100, to_date('2024-06-18 19', 'YYYY-MM-DD HH24') );	
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '초코하임', '크라운', 1900, to_date('2024-06-18 18', 'YYYY-MM-DD HH24') );		
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '찹쌀 설병', '크라운', 3000, to_date('2024-06-19 23', 'YYYY-MM-DD HH24') );
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '맵쌀 설병', '크라운', 2900, to_date('2024-06-19 23', 'YYYY-MM-DD HH24') );
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '콘칲', '크라운', 1500, to_date('2024-06-07 06', 'YYYY-MM-DD HH24') );		
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '참크래커', '크라운', 500, to_date('2024-06-29 11', 'YYYY-MM-DD HH24') );	
	-------------------	
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '사또밥', '삼양', 1200, to_date('2024-06-01 23', 'YYYY-MM-DD HH24') );	
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '짱구', '삼양', 2000, to_date('2024-06-03 12', 'YYYY-MM-DD HH24') );		
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '회오리 킹', '삼양', 1000, to_date('2024-06-17 14', 'YYYY-MM-DD HH24') );		
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '삼양 라면 스낵', '삼양', 800, to_date('2024-06-27 04', 'YYYY-MM-DD HH24') );		
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '별 뽀빠이', '삼양', 1000, to_date('2024-06-01 15', 'YYYY-MM-DD HH24') );		
---------------------------
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '스윙칩', '오리온', 1600, to_date('2024-06-29 08', 'YYYY-MM-DD HH24') );
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '도도한 나초', '오리온', 1400, to_date('2024-06-27 17', 'YYYY-MM-DD HH24') );		
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '후레쉬 베리', '오리온', 3000, to_date('2024-06-08 10', 'YYYY-MM-DD HH24') );		

	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '다이제', '오리온', 1500, to_date('2024-06-09 11', 'YYYY-MM-DD HH24') );
		
	insert into jun3_snack(snack_number, snack_name, snack_manufacturer,snack_price,snack_best_before )
		values(jun3_snack_seq.nextval, '치킨팝', '오리온', 1300, to_date('2024-06-23 16', 'YYYY-MM-DD HH24') );
--select jun03_snack_seq.currval from dual;

	select * from jun3_snack order by snack_number;
	select count(*) from jun3_snack;

	------매우 중요-------	
------데이터 읽어오기(Read)----------
/*
	select [distinct(옵션)] 컬럼명, [컬럼명 as 별칭 || 컬럼명 별칭], [연산자], [통계함수]
		from [테이블명]
		where [조건식]
		group by [그룹 대상]
		having [함수 포함 조건]
		order by [정렬 대상 asc/desc(오름차순, 내림차순)
*/
---과자 테이블의 내용 전체 불러오기 ( * : 모든 컬럼 )
	select * from jun3_snack;
	select snack_manufacturer from jun3_snack;
	
--distinct 중복 제거 옵션	//Q. 중복의 기준은 뭐로 잡나...? 
	select distinct * from jun3_snack;
	
--=> select 문 안쪽에서 사칙연산이 가능함, 근데 컬럼명이 깔끔하게 안나옴
--실제 프로그래밍 할 때, DB의 컬럼명으로 데이터를 불러오는 경우가 잦음
--별칭을 사용해서 이름 명확하고 깔끔하게 바꿔주기
--별칭 사용법
--	as : select snack_price/100 as s_price from jun3_snack;
	select snack_price/100 as s_price from jun3_snack;
-- 컬럼명 띄어쓰기 후 바로 별칭 써주기(이쪽을 좀 자주 씀)
	select snack_price/100 s_price from jun3_snack;

-- 연산자( 산술 연산자 ) : dual 테이블 사용할 예정 -> 오라클 자체 제공 더미 테이블
--	간단하게 함수를 이용해서 계산 결과값을 확인할 때 사용하는 테이블

	select 1 + '3' from dual;
--결과 4 나옴
--why? : 대부부의 프로그래밍 언어는 형변환시 문자의 우선도가 높아서 문자 13 결과가 나오는데,
--오라클에서는 반대로 숫자의 우선순위가 더 높다.
	select 1 + 'a' from dual;
--invalid 'number' a의 숫자 형변환이 실패했음을 알려줌
--즉, 오라클에서는 연산자가 숫자면 숫자만 연산 해줌

--문자를 더해주기 위한 연산자가 따로 있음
--바로 '||' ( shift+ \ )
	select 1||'a' from dual;
