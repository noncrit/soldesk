create table jul04_student(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_nickname varchar2(10 char) not null
);

create sequence jul04_student_seq;

select * from jul04_student;

create table jul04_exam(
	e_name varchar2(30 char) primary key,
	e_date_year number(30) not null,
	e_date_month number(30) not null,
	e_date_day number(30) not null
);

select * from jul04_exam;
drop table jul04_exam;

create table jul04_exam_test(
	e_name_test varchar2(30 char) primary key,
	e_date_test date not null
);
select * from jul04_exam_test;
drop table jul04_exam_test;

select * from tab;

