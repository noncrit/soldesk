/*	이제까지 학습한 내용들

	DB를 설치하긴했음
	CMD 기반의 SQLplus를 다뤄보면서 DBA 맛보기(계정 생성, 권한 부여, tablespace 생성/권한 부여)
	간단한 용어정리(테이블, 행, 열, 스키마, 인스턴스, 도메인 등등)
	SQL의 명령어 DML(정의어)를 다루면서 테이블 생성해봄
	테이블 생성 시 필요한 자료형(주력으로 사용한 것만) 정리
		-문자형 varchar2 ( 파라미터로 숫자만 넣으면 바이트 단위, 10 char 이런식으로 넣으면 10글자라고 선언하는것
		-숫자형 number (p,s)	
		-날짜형 date
	제약 조건(Constraint) 다뤘음
		-not null, primary key, foreign key 등등
	 테이블의 구조를 변경/수정/삭제 - 여기까지 DDL 끝
	 -----
	과자에 대한 테이블
	: 과자 이름, 회사, 가격 정보
	: 테이블에는 primary key

	*/
	create table snack(
		snack_name varchar2(15 char),
		snack_manufacturer varchar2(15 char),
		snack_price number(10),
		constraint PK_snack primary key(snack_name, snack_manufacturer)
	);

	--속성 하나로는 primary key가 될 수 없음
		--속성값 하나를 추가해서 (ex. 과자 일련 번호) primary key로 새로 설정하기
		--2개의 속성을 묶어서 primary key로 설정하기
	
