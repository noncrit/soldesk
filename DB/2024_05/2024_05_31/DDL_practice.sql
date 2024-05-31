/*
	노트북에 대한 테이블 작성
	: 이름, 가격, cpu 이름, 램 용량, hdd 용량, 보증기간
	조건 - 하나의 기본키를 무조건 갖기, 모두 값은 채워넣어야함
	
	노트북의 사양이 좋아져서 128GB짜리 ram을 사용하게되었음.
	이 때, RAM 컬럼의 용량을 변경하는 문장 하나 작성
	
	노트북의 크기에 대한 컬럼 추가하는 문장 작성
	단위는 cm, 소수점 2번쨰 자리까지 나타낼 예정
	크기에 대한 컬럼은 빈 값으로 넣을 수 없음
	
	노트북에는 앞으로 HDD 대신 SSD를 장착할 예정
	HDD 컬럼 이름을 SSD로 변경하는 문장 작성하기
	
	보증기간 컬럼을 삭제하는 문장 작성
	
	노트북의 가격이 80만원 -> 230만원 사이의 값만 들어갈 수 있게
	해당 컬럼을 변경하는 문장 작성
	
	만든 테이블을 완전 삭제하는 문장 작성
 */
--1
create table laptop(
	laptop_name varchar2(15 char) not null,
	laptop_price number(15) not null,
	laptop_cpu_name varchar2(20 char) not null,
	laptop_ram_capacity number(2) not null,
	laptop_hdd_capacity varchar2(10 char) not null,
	latptop_warranty date not null,
	constraint PK_laptop primary key(laptop_name)
);

drop table laptop;
--2
alter table laptop modify laptop_ram_capacity number(3);

--3
alter table laptop add laptop_size number(4,2) not null;

--4
alter table laptop rename column laptop_hdd_capacity to laptop_ssd_capacity;

--5
alter table laptop drop column latptop_warranty;

--6
alter table laptop modify laptop_price number(7);
alter table laptop add constraint price_range check(laptop_price>=800000 and laptop_price<=2300000);
alter table laptop drop constraint price_range;
--7
drop table laptop cascade constraint purge;

