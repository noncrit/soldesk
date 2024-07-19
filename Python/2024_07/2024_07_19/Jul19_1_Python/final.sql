--table 간 제약조건은 고려하지 않음

--학생 : 이름, 생일, 몇 강의장, 중간고사 점수(정수), 기말고사 점수(정수)
create table jul19_final_student(
	s_no number(3) primary key,
	s_name varchar2(30 char) not null,
	s_birth date not null,
	classroom varchar2(30 char) not null,
	score_midterm number(10),
	score_finalterm number(10)
)

create sequence jul19_final_student_seq

drop table jul19_final_student

select * from jul19_final_student


--강의장 : 몇 강의장, 강의장 위치
--1강의장 : 5층 복도 오른쪽 / 2강의장 : 5층 복도 왼쪽 끝 / 3강의장 : 5층 복도 왼쪽 첫번째 / 4강의장 : 6층 정면 / 5강의장 : 6층 오른쪽
--강의장에 대한 데이터는 SQL 파일에서 직접 입력
create table jul19_final_classroom(
	c_name varchar2(20 char) primary key,
	c_location varchar2(50 char) not null
)

insert into jul19_final_classroom values('1강의장', '5층 복도 오른쪽')
insert into jul19_final_classroom values('2강의장', '5층 복도 왼쪽 끝')
insert into jul19_final_classroom values('3강의장', '5층 복도 왼쪽 첫번째')
insert into jul19_final_classroom values('4강의장', '6층 정면')
insert into jul19_final_classroom values('5강의장', '6층 오른쪽')

select * from jul19_final_classroom
