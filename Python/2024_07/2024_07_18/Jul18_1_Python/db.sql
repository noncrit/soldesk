create table jul18_coffee(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_price number(5) not null,
	c_bean varchar2(10 char) not null
)
select * from tab

create sequence jul18_coffee_seq;

select * from jul18_coffee

/*delete from jul18_coffee where c_price = 4300*/

select count(*) from JUL18_COFFEE where c_bean='로부스타'

select round(avg(c_price),2) from JUL18_COFFEE where c_bean='로부스타'