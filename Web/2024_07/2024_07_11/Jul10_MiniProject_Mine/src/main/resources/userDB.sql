create table jul10_userData(
	user_code number(20) primary key,
	name varchar2(40 char) not null,
	win number(20) not null,
	lose number(20) not null,
	total_play number(22) not null
);

select * from jul10_userData;

select * from jul10_userData where user_code = 1;
update jul10_userData set win=6, lose=10, total_play=(6+10) where user_code = 1;

truncate table jul10_userData;

insert into jul10_userData values(1, 'ksj', 10, 10, 20);
