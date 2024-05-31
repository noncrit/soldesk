create table may31_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null,
	c_kcal number(3) not null,
	c_start date not null
);


/*
	DDL에서 create 문은 실제로 활용해봤음
	이제 비교적 쉬운 alter / drop / truncate 활용해보기
	
*/

insert into may31_coffee values('아메리카노', 3000, 15, sysdate);

select * from may31_coffee;

--데이터 타입 변경, 컬럼의 크기(용량) 변경
--alter table [테이블명] modify [컬럼명] [데이터타입(용량)];
alter table may31_coffee modify c_name number(3);
--이미 입력된 값이 있어서 테이블의 데이터 타입 변경 불가

alter table may31_coffee modify c_name varchar2(2 char);
--테이블에 이미 값이 입력된 상태에서 기존 자료형 크기보다 용량을 적게 변경하면 에러 발생함

--주의사항	: 데이터 타입 변경할 때는 해당 컬럼의 값을 모두 지워야함, 그렇지 않으면 오류 발생!
--		: 컬럼의 용량을 줄이게 될 경우, 해당 컬럼의 용량을 조사해서 변경할 크기보다 큰 값이 있는지 체크하고 변경하기

-- 컬럼의 이름을 바꾸고 싶은 경우
--alter table [테이블명] rename column [기존이름] to [바꿀이름];
alter table may31_coffee rename column c_name to c_name2;

select * from may31_coffee;

--컬럼을 추가하고 싶은 경우
--alter table [테이블명] add [추가할 컬럼명] [데이터 타입] [제약조건(생략가능)];

-- 기존 데이터가 하나라도 존재하면 not null은 못씀(추가되는 컬럼에 null 값 들어가야되는데 not null이랑 충돌함)
alter table may31_coffee add c_taste varchar2(20 char) not null;
alter table may31_coffee add c_taste varchar2(20 char);

--컬럼 삭제
--alter table [테이블명] drop column [컬럼명];
alter table may31_coffee drop column c_taste;

--테이블 내의 내용 지우기 -truncate 데이터만 날려버림(테이블의 스키마 자체는 남겨둠)
--truncate table [테이블명];
truncate table may31_coffee;
select * from may31_coffee;

--테이블 자체를 지워버리고싶은 경우 (윈도우로 따지면 휴지통에 넣기..?)
--drop table [대상 테이블명];	drop하면 문제가 생기는 제약조건 걸려있는 경우 드랍이 안됨
--drop table [대상 테이블명] cascade constraint ~~;	--cascade -> 제약 조건 관련된 것까지 모두 지우겠다 
drop table may31_coffee cascade constraint;
select * from may31_coffee;

--휴지통에 넣은 테이블 복원하기
--flashback table [테이블명] to before drop;
flashback table may31_coffee to before drop;
select * from may31_coffee;

--휴지통에 다시 넣음
drop table may31_coffee cascade constraint;

--(휴지통 안에 넣은거)복원불가한 완전 삭제
purge recyclebin;
select * from may31_coffee;

--휴지통에 넣고 바로 비우기 => 한번에 완전 삭제
--drop table [테이블명] cascade constraint purge;
drop table may31_coffee cascade constraint purge;

select * from tab;

------------------------
/*
	DDL을 신입에게 맡기지는 않는다. => 잘못 건드리면...
	보통 DBA가 전담해서 테이블을 만들고, 수정하고를 담당함 / 신입은 CRUD 정도만
 */

