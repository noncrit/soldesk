--어떤 특정한 식당에 대한 테이블
--식당 지점(체인점 지역), 식당 주인(이름), 좌석 수

-- 데이터 2~3개 정도 넣기

create table jun10_restaurant(
	rst_num number(3) primary key,
	rst_location varchar2(20 char) not null,
	rst_owner varchar2(20 char) not null,
	rst_seat number(4) not null
);

drop table jun10_restaurant;

create sequence jun10_restaurant_seq;


insert into jun10_restaurant values(1,'판교','석진',40);
insert into jun10_restaurant values(2,'강남','우진',60);
insert into jun10_restaurant values(3,'평택','승화',20);

select * from jun10_restaurant;
-----------------

--예약 테이블
--예약자 이름, 예약  시간, 예약자 전화번호, 예약 지점

--데이터 2~3개 정도 넣기

create table jun10_reservation(
	rsv_num number(3) primary key,
	rsv_name varchar2(20 char) not null,
	rsv_when Date not null,
	rsv_phoneNum varchar2(40 char) not null,
	rsv_location varchar2(20 char) not null
--	constraint FK_reservation foreign key(rsv_location) references jun10_restaurant(rst_location) on delete cascade
);

select * from jun10_reservation;

drop table jun10_reservation;

create sequence jun10_reservation_seq;
drop jun10_reservation_seq;



--insert into jun10_reservation values(1,'아무개',to_date('2024-06-10/16:34','YYYY-MM-DD/HH24:MI'),'010-1234-5555','판교');
--insert into jun10_reservation values(2,'저무개',to_date('2024-06-10/17:24','YYYY-MM-DD/HH24:MI'),'010-1234-6666','강남');
