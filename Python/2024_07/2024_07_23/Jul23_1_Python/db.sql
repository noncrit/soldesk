create table search_location(
	sl_no number(3) primary key,
	sl_place_name varchar2(30 char) not null,
	sl_phone varchar2(30 char) not null,
	sl_x number(9, 6) not null,
	sl_y number(9,6) not null
)

create sequence search_location_seq

--NVL 함수 : NULL 값 처리할 때 사용함 / 들어온 값 NULL이면 지정한 값으로 바꿈
--NVL(값, NULL일때 대체할 값)---

select nvl(null, '-'), nvl('null','-') from dual

--NVL2 함수 : NULL 값의 여부에 따라서 지정한 값으로 바꿔주는 함수
--NVL2(값, 해당 값이 있을 때 대체 값, 해당 값이 없을 때 대체값)

select nvl2(null, 'A', 'B'), nvl2('null','A','B') from dual

select * from SEARCH_LOCATION

select sl_place_name,sl_phone,sl_x,sl_y from search_location