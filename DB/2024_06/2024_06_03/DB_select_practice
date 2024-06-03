/*
	select [distinct(옵션)] 컬럼명, [컬럼명 as 별칭 || 컬럼명 별칭], [연산자], [통계함수]
		from [테이블명]
		where [조건식]
		group by [그룹 대상]
		having [함수 포함 조건]
		order by [정렬 대상 asc/desc(오름차순, 내림차순)
*/
--내장함수 실행은 select 바로 뒤쪽에서만 가능한듯?

/*
	--Where 절 ( 조건식 )
	--전체 데이터 중 지정한 조건에 맞는 데이터를 찾아주는 문장
	--조건식에 사용할 연산자를 알아보자 (비교 연산자)
	-- =, !=, ^=, <>, >, <, >=, <= 등등
	-- !=, ^=, <>  이 세개의 연산자는 모두 같지 않다를 의미함
	-- !=, <>는 표준화를 하려다보니 사용하게됨
	-- ^=는 다른 DB랑 차별성을 두기 위해 사용함(?!)
*/
	-- 가격이 3000원인 과자의 모든 정보 조회
select * from jun3_snack where snack_price=3000;
select * from jun3_snack;
	
	--모든 과자 이름, 가격 조회
	select snack_name,snack_price from jun3_snack;

	--모든 과자이름(가격) 조회 ex) 콘칩(2000원) 이런 모양으로
	select concat( snack_name , '(' || snack_price || '원)' ) from jun3_snack;
	
	--수업에 나온 답(별칭 부분 큰 따옴표 써주기)
	select snack_name || '(' || snack_price || '원)' "이름(가격)" from jun3_snack;
	
	--별칭이 as 생략된건가?? - ㅇㅇ 두글자 아끼기
	select snack_name || '(' || snack_price || '원)' as "이름(가격)" from jun3_snack; 
	
	--2000원 이하 과자 중 최소가격
	select min(snack_price)  from jun3_snack where snack_price<=2000;
	
	--모든 과자의 평균가
	select round( avg(snack_price) , 1) from jun3_snack;
	
	--모든 과자의 이름과 가격의 30% 할인된 금액
	select snack_name, snack_price*0.7 as "discounted 30%" from jun3_snack;
	
	--3500원인 과자의 갯수는 몇개?
	select count(snack_price) from jun3_snack where snack_price=3500;
	
	--3000원 이하인 과자의 이름,회사 이름
	select snack_name, snack_manufacturer from jun3_snack where SNACK_price<=3000;
	
	--------------
	select * from jun3_snack;
	--모든 과자의 이름, 가격, 유통기한
	select snack_name,snack_price,snack_best_before from jun3_snack;
	--모든 과자의 이름 , 가격, 부가세 조회(가격의 10%)
	select snack_name, snack_price, round( snack_price * 0.1) ,1) "VAT" from jun3_snack;
	
	--모든 과자의 이름, 가격, 판매가 조회(20% 할인)
	select snack_name, snack_price, round( snack_price * 0.8) ,1) as "discounted" from jun3_snack;
	 
	--3000원 보다 큰 금액의 과자들의 평균가 조회
	select avg(snack_price) from jun3_snack where snack_price>3000;
	
	--최고가, 최저가, 총 과자 종류 몇 가지인지 조회
	select max(snack_price),min(snack_price),count(snack_number) from jun3_snack;

	--3000원 이상인 과자의 전체 정보 조회
	select * from jun3_snack where snack_price>=3000;
	
	--3000원 미만인 과자의 이름, 가격, 판매가 조회(20% 할인)
	select snack_name, snack_price,  snack_price * 0.8 as "discounted" from jun3_snack where snack_price<3000;
	
	--특정 과자의 가격 조회
	select * from jun3_snack where snack_name='콘칲';
	
	--크라운 회사의 과자 가격의 총합 조회
	select sum(snack_price) from jun3_snack where snack_manufacturer='크라운';
	
	--6월 안으로 먹어야 하는 과자의 이름,가격,유통기한 조회 (날짜형끼리도 비교가 가능
	select snack_name, snack_price, snack_best_before from jun3_snack
		where snack_best_before <to_date('2024-07-01 00:00:00','YYYY-MM-DD HH24:MI:SS');
