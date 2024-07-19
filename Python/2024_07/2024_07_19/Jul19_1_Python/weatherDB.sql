create table jul19_weather(
	hour number(20) not null,
	temp number(20) not null,
	tmx number(20) not null,
	wfKor varchar2(20 char) not null,
	wdKor varchar2(20 char) not null,
	w_no number(30) primary key
)

drop table jul19_weather

select * from jul19_weather

create sequence jul19_weather_seq

truncate table jul19_weather