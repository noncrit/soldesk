--sql에서의 주석처리(주석 단축키 똑같음 ctrl+/) , /* 도 가능함
--DB를 사용하기 위해서는 cmd 기반에서 접근 할 수도 있지만, 불편함
--SQL의 결과와 Query의 검증을 위해 개발자 툴에서 사용함
--툴 종류
--Eclipse, DBeaver(디비버), MySQL - WorkBench, Oracle - SQL Developer

--용어 정리!!
/*
	테이블(==relation)
	-데이터베이스에서 정보를 구분하여 저장하는 기본 단위
	-테이블은 행(row), 열(column)으로 이루어진 데이터들의 집합
	-테이블들을 저장하는 공간이 테이블 스페이스(Table space)
	기초 용어 정리
	-행(Row)		 : 테이블을 구성하는 데이터 중에서 가로 부분(→), 튜플(Tuple) 또는 레코드(Record)라고도 부름
	-열(Column)	 : 테이블을 구성하는 데이터 중에서 세로 부분(↓), 필드(field) 또는 속성(attribute)라고도 부름
	-스키마(Schema): 데이터베이스에서 테이블의 기본 구조를 정의하는 형식, 테이블의 헤더를 나타내고, 속성과 자료타입이 정의되어 있음
	-인스턴스(Instance) : 테이블에 실제로 저장된 데이터의 값
	-도메인(Domain): 속성이 가질 수 있는 값의 집합, 특정 속성에서 사용할 데이터의 범위를 사용자가 지정하게 됨
	-ex) p_age number(3) - 정수를 3자리까지만 받겠다, 3자리를 넘어가면 값이 받아와지지 않음
	-ex) p_name_varchar2(10 char) - 문자열을 최대 10글자 까지 받겠다. , 글자수 넘기면 값이 받아와지지 않음
	
*/
--사실 한줄짜리 코드지만, 가독성을 위해 줄을 바꿔놨음
--여러 줄을 실행하고 싶다면? -> 실행하려는 줄을 모두 드래그해서 alt+x
--콤마랑 세미콜론 조심!!!
create table person(
	p_name varchar2(10 char),
	p_age number(3),
	p_gender varchar(2 char)
);
--커서 위치 한줄씩 실행하기 alt + s
insert into PERSON values('홍길동', 10, '남');
insert into PERSON values('김길동', 20, '남');
insert into PERSON values('김길동', 20, '여');
insert into PERSON values('최길동', 30, '남');
insert into PERSON values('홍길동', 10, '남');
select * from PERSON;
--10살의 홍길동씨가 2번 들어갔음

--중복값은 없애고 1번만 출력하길 원할 때
select distinct * from PERSON;

--테이블 지우기
drop table person cascade constraint purge;

--delete from person where p_name='김길동';

select * from PERSON;

/*
 테이블(릴레이션)의 특징
	1. 속성(attribute)은/는 단일 값만 가진다. => 각 속성의 값은 도메인에 정해진 값만 가지고, 그 값은 모두 단일값이어야한다.
	(위의 테이블에서 p_age 라는 column이 2개가 동시에 존재할 수는 없다.)
	
	2. 속성(column)은 서로 다른 이름을 가져야한다.
	
	3. 한 속성의 값은 모두 같은 도메인 값을 가진다.
	
	ex) p_age에 속한 값들은 모두 최대 3자리 정수여야만했음
	4. 속성의 순서가 달라도 테이블의 스키마는 같음 (순서만 바뀐거지 내용 자체는 같다)
	
	5. 테이블 내의 중복된 튜플(tuple)(row)(행)은 허용되지 않는다. 특수한 경우가 아닌이상 같은 데이터가 2번 들어가면
	그 2개 데이터의 구분이 불가능하다... => 모든 튜플에는 차별성이 있어야함
	
----------------------------------
-SQL 명령문의 종류
	
	-데이터 정의어(DDL/Data Definition Language)
	: 테이블간의 관계 구조를 생성하는데 사용함
	ex)Create, Alter, Drop ... 등이 있음
	
	-데이터 조작어(DML/Data Manipulation Language)
	: 테이블에 데이터를 검색하거나 삽입하거나 변경, 수정, 삭제 시 사용 (CRUD) (Create, Read, Update, Delete)
	ex) Select(R), Insert(C), Update(U), Delete(D) 등등
	Select문이 바로 Query임(질의어)
	
	-데이터 제어어(DCL/Data Control Language)
	: 데이터베이스에 접근하고 객체들을 사용하도록 권한을 주거나 회수하는데 사용함
	ex) Grant, Revoke 등등
	보통은 DBA(Database Administrator)의 업무라서 보통은 건드릴 일이 없음
	
	-트랜잭션 처리어(애매한 친구)(TCL/Transaction Control Language)
	: DML에 의해서 조작된 결과를 작업단위(transaction)별로 제어하는데 사용함
	ex)SQL 작성한 후 Commit, Rollback, Savepoint 등이 있음
	근데 이클립스상에서는 auto commit 모드라서 rollback은 사용하기 힘들다...
	
-----------------------------------------
	SQL이라는 언어로 DB를 제어해보자! - DB메이커가 달라도 SQL 구조는 거의 비슷비슷함
	SQL - 대소문자 구분 없음 -> 모든 문자를 대문자로 받아들임 ->낙타체(catAge) 못씀... 뱀체(cat_age) 사용
	집어넣을 데이터 내용은 대소문자 구분 가능
	
	테이블 스페이스 절대 지우지 말것!!! 명령어로 지우는거 아니면 컴퓨터 포맷해야 할 수도 있음
	
	
	
	
	
