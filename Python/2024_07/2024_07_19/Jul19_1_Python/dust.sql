create table jul19_dust(
	day number(20) not null,
	MSRRGN_NM varchar2(20 char) not null,
	PM10 number(5,3) not null,
	PM25 number(5,3) not null
)

drop table jul19_dust

create sequence jul19_dust_seq

drop sequence jul19_dust_seq

select * from jul19_dust
