/*
	[옵션]
	제약조건(Constraint)라 부르기도 함
	데이터의 무결성을 보장하기 위한 개념
		
		데이터의 무결성 - 이미 데이터 베이스에 저장된 데이터의 일관성과 정확성을 지키는 것
		-무결성의 요건
			1. 도메인 무결성 제약조건(도메인 제약)(Domain Constraint)
				- 테이블 내의 튜플들이 각 속성의 도메인에 지정된 값만 가져야한다는 조건
				- 데이터 타입(Type), NULL(NOT NULL), DEFAULT, CHECK 등등을 이용해 구현
			
			2. 개체 무결성 제약조건(= 기본키 제약 조건) Primary key Constraint
				[용어 정리]
				개체(Entity) : 사람, 장소, 사물, 사건 등과 같이 독립적으로 존재하면서, 고유하게 식별이 가능한 단위
				-아무리 많은 개체가 있어도, 내가 원하는 '유일한' 개체를 발견 할 수 있어야함
				-테이블은 기본키를 지정하고, 해당 기본키는 절대 NULL 값이어서는 안되며, 테이블내에 오직 하나만 존재해야함
				-(Primary key는 1개, Primary key가 될 수 있는 Candidate key는 여러 개가 존재할 수 있음)
			
			3. 참조 무결성 제약조건(Foreign key Constraint)(외래 키 제약 조건)
				-테이블 간의 참조 관계를 선언하는 제약 조건
				-참조를 받는 테이블의 외래키는 참조하는 테이블의 기본키와 동일해야한다.
				-참조받는 테이블의 값이 변경될 때, 참조하는 테이블의 제약을 받는다.
				
--------------------
	1. NOT NULL
		- NULL : 값이 비어있다는 뜻, 아직 아무런 값이 존재하지 않는 상태
		- NOT NULL은 무조건 값이 존재해야 한다는 뜻 : NULL을 허용하지 않는다.
		- 보통 가장 많이 활용하게 될 제약조건
		** 유의 사항 : 가급적이면 테이블을 만들 때 값이 들어가는게 좋다 **
		
		예시코드
		create table example(
			col1 varchar2(10 char),
			col2 varchar2(10 char) not null
		);
		
		create table example2(
			col1 varchar2(10 char),
			col2 varchar2(10 char) constraint col2_notnull not null
		);
		
		2번째 코드의 col2_notnull은 제약 조건에 대한 이름 선언
		1번째 코드의 경우 OracleDB에서 알아서 제약 조건에 대한 이름을 붙임
		
	2. Unique
		- 단어 뜻 그대로 해당 컬럼에 들어가는 값이 전체 테이블에서 유일해야 한다는 조건
		- Not NULL 과도 함께 사용 가능하지만, Unique 자체는 많이 쓰이진 않음
		
		예시코드
		create table example2(
			col1 varchar2(10 char) unique,
			col2 varchar2(10 char) unique not null,
			col3 varchar2(10 char) constraint col3_unique unique(col3)
		);
		
	3. Primary Key(기본키)
		- NULL 값을 허용하지 않고, 중복된 데이터도 허용하지 않음
		- NOT NULL + UNIQUE = Primary Key
		- 데이터의 특정 조건을 검색하거나 수정 등의 작업을 할 때 기본키로 구분함
		ex) ID, 주민번호, 회원 번호 등등
		* 여러 개의 속성의 조합이 기본키가 될 수 있음 *
		- 테이블 생성시 기본키 1개는 무조건 존재하는 편이 좋음
		
		예시 코드
		create table example4(
			col1 varchar2(10 char) primary key,
			col2 varchar2(10 char) not null,
			col3 varchar2(10 char) not null
		);
		
		create table example5(
			col1 varchar2(10 char),
			col2 varchar2(10 char),
			col3 varchar2(10 char),
			constraint PK_example5 primary key(col1, col2) 
			// 컬럼 2개의 조합으로 PK_example5 라는 primary key 선언
		);
		
	4. Foreign key(외래키)(FK로 줄여씀)
		- 다른 테이블의 특정 column을 참조하는 키
		- 다른 테이블의 특정 컬럼을 조회해서 동일한 데이터가 있는 경우에만 입력이 허용되는 식으로 구현
		- 원칙적으로 참조받는 테이블의 Primary Key이거나 Unique 인 경우에만 참조하는 테이블의 FK로 지정 가능
		- 외래키 설정을 위한 조건 
			: 참조받는 대상 컬럼이 먼저 생성되야함
			: 그 이후에 외래키를 설정할 테이블이 생성되야함
		
		- 외래키를 심을 테이블의 형식
		
		create table 테이블명(
			컬럼명 자료형,
			...
			constraint FK명(제약조건 이름) foreign key(컬럼명) 
			references 참조할 대상 테이블의 이름(해당 테이블의 기본키(or 고유키)의 컬럼명)
			on delete set null || on delete cascade
			//** 마지막줄은 옵션으로 예외처리 해놓은 것(보통 둘 중 하나 선택해서 사용)**
			// FK가 참조하는 테이블에서 데이터가 지워졌을 때 처리방식을 설정하는 옵션(NULL 값으로 바꿔놓을지, 같이 값을 지울것인지)	
		);
*/
*/
		--예시코드
		--상위 테이블
		create table example6(
			ex6_id varchar(10 char) primary key
		);
		
		insert into example6 values('10');
		insert into example6 values('20');
		insert into example6 values('30');
		select * from example6;
		
		--하위테이블
		create table EXAMPLE7(
			ex7_id varchar2(10 char),
			constraint fk_ex7 foreign key(ex7_id)
			references example6(ex6_id)
			on delete cascade
		);
		
		insert into EXAMPLE7 values('10');
		insert into EXAMPLE7 values('20');
		insert into EXAMPLE7 values('30');
		insert into EXAMPLE7 values('40');	--error : 상위 테이블에 40이 없어서 추가 불가능
		select * from example7;

		--ex6_id가 '10'인 컬럼을 지우는 경우
		delete from example6 where ex6_id = '10';
		select * from example6;
		select * from example7;
		--옵션으로 설정한 on delete 때문에 값이 같이 날아감	
		
		-----------------학과에 대한 테이블과 이 학과 테이블을 참조하는 학생 테이블을 만들어보자----------------
		
		--학과 테이블 : 학과코드(4자리 숫자), 학과 이름(10글자 이내)
		--학생 테이블 : 학생번호(3자리 숫자), 학생 이름, 학생이 소속되어있는 학과의 코드
		
		--학과 테이블 생성
		create table major(
			major_code char(4) not null,
			major_name varchar(10 char) not null,
			constraint PK_major primary key(major_code)
		);
		
		insert into major values('0001','CS');
		insert into major values('0002', 'DS');
		
		select * from major;
		
		--학생 테이블 생성
		create table student(
			student_code char(3 char),
			student_name varchar(10 char),
			student_major_code char(4 char),
			constraint student_FK foreign key(student_major_code)
				references major(major_code)
				on delete cascade,
			constraint FK_student primary key(student_code)
		);
		
		drop table student;
		
		insert into student values('000','석진', '0001');
		insert into student values('001','진2', '0001');
		insert into student values('002','석3', '0001');
		insert into student values('003','석4', '0002');
		
		select * from student;
		
		insert into student values('001','아무개', '0000');
		
		delete from major where major_code = '0002';
		
		select * from major;
		select * from student;
		
		--on delete 옵션 때문에 major_code가 0002인 모든 학생이 지워졌음
		
		drop table student;
	 	drop table major;
	 	
-----------------------------------
/*
 	5. Check
 		-데이터의 범위, 조건을 설정해서 조건에 해당하는 데이터만 입력을 허용
 		
 	ex)
 	create table example8(
 		col1 number(3) constraint ex8_check check(col1 between 1 and 9)
 	);
 	
 	insert into example8 values(10);
 	--오류 발생 (constraint 위반)
-------------------
	6. Default
		-아무런 데이터도 입력하지 않은 경우 지정한 데이터가 자동으로 입력됨
		
	ex)
	create table example9(
		col1 number(4) default 999
	);
	
	insert into example9 values(default);
	insert into example9 values(null);	--null값도 값이긴해서 들어가기는함
	insert into example9 values(0);
	insert into example9 values(11);
	
	select * from example9;
	
*/
	
	
	
		
		
		
		
