/*
	테이블에 데이터를 검색, 삽입, 수정, 삭제 하는데 사용하는 문장인
	데이터 조작어(DML) 중에서 데이터를 넣게하는 명령어인 INSERT와 데이터를 검색 OR 조회 할 수 있는 명령어인 SELECT의 구조를 뜯어봤음
	
	INSERT INTO 테이블명 VALUES(파라미터(테이블 스키마 순서대로));
	INSERT를 하면서 PK를 줄 수 없는 상황에 강제적으로 고유 번호값을 만드는 방법으로 PK를 부여했음
	(Q. 실무에서 DB 쓰면서 2개 이상의 컬럼을 합쳐서 PRIMARY KEY로 쓰는 경우는 거의 없나??)
	그 고유한 번호값들을 하나하나 찍어낼 수는 없으니 SEQUENCE를 활용했음
	SEQUENCE : DB와는 무관한 독립 자료 구조, 단점으로는 INSERT 작업이 실패해도 SEQUENCE 값은 1씩 계속 올라감
	
	[대괄호는 무시], [컬럼명 별칭]은 중간에 AS 생략된 형태
	select [distinct(옵션)] 컬럼명, [컬럼명 as 별칭 || 컬럼명 별칭], [연산자], [통계함수]
	from [테이블명]
	where [조건식]
	group by [그룹 대상]
	having [함수 포함 조건]
	order by [정렬 대상 asc/desc(오름차순, 내림차순)

	DISTINCT : 중복된 데이터 제거
	컬럼명에 별칭 부여 : AS ~ 하거나 그냥 띄어쓰기
		별칭에 특수문자, 띄어쓰기가 들어가야 할 경우 또는 숫자가 들어가야 할 경우 : "별칭" 으로 큰 따옴표 사용해서 표현
	
	연산자 시리즈 
	1.산술 연산자(+,ㅡ,*,/), 문자를 이어주는 연산자 ||

	DUAL 더미테이블 이용해서 내장 함수(숫자, 문자, 날짜, 통계, NULL) 살펴봤음
	
	전체 데이터중에서 조건에 맞는 데이터를 찾는 WHERE(조건식) 다루면서
	2.비교 연산자(>=,!=,^=,<> 등등)
	
	3.관계 연산자(AND, BETWEEN, OR, IN, NOT)
		BETWEEN : 이상, 이하만 표현 가능
	
	4.패턴 연산자 : 문자열을 포함하는 검색
		LIKE '%패턴%' 의 형태
		= 를 사용하고 싶지만, 문법상의 문제로 뒤쪽 패턴이 그냥 문자로 인식됨
		
	5.집합 연산자(UNION (ALL), MINUS, INTERSECT)
		UNION : 중복되는 값을 제외하고 UNION 진행
		UNION ALL : 중복되는 값을 포함해서 UNION 진행
		INTERSECT : 집합 중 공통되는 값 출력
		MINUS : 차집합, A-B A의 원소 중 B에 없는 원소들만 출력
	
	**연산자의 우선 순위**
	괄호 > 비교연산자 > NOT > AND > OR
	
	여기까지 WHERE 조건식 끝
	
	GROUP BY : 특정 컬럼을 기준으로 그룹을 묶는 연산을 수행해 하나의 결과를 나타냄
		ROLLUP 연산자 : 컬럼에 대한 소계(SUBTOTAL)을 만들어줌
		HAVING : GROUP BY로 묶을 그룹의 조건을 설정하는 부분 ( WHERE 는 SELCET 전체의 조건을 설정하는 역할)
		
	ORDER BY 컬럼명 ASC/DESC
---------------------------------------------
	다음 다룰 내용
	 서브 쿼리(SubQuery) : 하나의 쿼리문 안에 또 다른 쿼리가 있는 nested query
	 	다른 테이블에서 가져온 데이터로 현재 테이블에 있는 정보를 찾거나 가공할 때 사용
	 	데이터가 대량인 경우, 데이터를 모두 합쳐서 연산하는 join이 있지만, join 자체의 성능 문제도 있고, 고려할 부분이 좀 있음
	구조
	메인 쿼리(외부 질의), 서브 쿼리(내부 질의)로 구성됨
*/
--과자의 평균가보다 가격이 낮은 과자의 이름, 가격 조회
SELECT SNACK_NAME, SNACK_PRICE
	FROM JUN3_SNACK
	WHERE SNACK_PRICE < 	(
							SELECT AVG(SNACK_PRICE)
							FROM JUN3_SNACK
							);
	
-- 부분으로 나눠서 작성해야 가독성 좋다...

-- 메인쿼리의 WHERE 절에서 서브쿼리의 결과와 비교할 때는 비교 연산자 사용
	
--과자들 중 최고가?							
SELECT SNACK_NAME FROM JUN3_SNACK WHERE SNACK_PRICE=(SELECT MAX(SNACK_PRICE) FROM JUN3_SNACK );						
--제일 비싼 과자의 이름, 제조사, 가격
SELECT SNACK_NAME, SNACK_MANUFACTURER, SNACK_PRICE FROM JUN3_SNACK WHERE SNACK_PRICE=(SELECT MAX(SNACK_PRICE) FROM JUN3_SNACK );
--제일 싼 과자는 어디에서 만드는지
SELECT DISTINCT SNACK_MANUFACTURER FROM JUN3_SNACK WHERE SNACK_PRICE=(SELECT MIN(SNACK_PRICE) FROM JUN3_SNACK );
--평균가보다 비싼 과자는 몇 종류인지
SELECT COUNT(SNACK_NUMBER) FROM JUN3_SNACK WHERE SNACK_PRICE>(SELECT AVG(SNACK_PRICE) FROM JUN3_SNACK );
--유통기한이 가장 오래 남은 과자의 전체정보
SELECT * FROM JUN3_SNACK WHERE SNACK_BEST_BEFORE=(SELECT MAX(SNACK_BEST_BEFORE) FROM JUN3_SNACK );
SELECT * FROM JUN3_SNACK ORDER BY SNACK_BEST_BEFORE DESC;

SELECT * FROM COLS WHERE TABLE_NAME='JUN3_SNACK';

-------------------

--과자 회사 테이블을 만들건데, [회사 이름, 주소, 직원 수] 값을 가지게 해주세요
CREATE TABLE COMPANY_SNACK(
	COMPANY_NAME VARCHAR2(15 CHAR) PRIMARY KEY,
	COMPANY_ADDRESS VARCHAR2(30 CHAR) NOT NULL,
	COMPANY_WORKERS NUMBER(10) NOT NULL
);
DROP TABLE COMPANY_SNACK CASCADE CONSTRAINT PURGE;
SELECT DISTINCT SNACK_MANUFACTURER FROM JUN3_SNACK;
--과자 테이블에 맞춰서 데이터 넣기
INSERT INTO COMPANY_SNACK VALUES('크라운','서울시 용산구 한강대로 72길 3',6000);
INSERT INTO COMPANY_SNACK VALUES('농심','서울특별시 동작구 여의대방로 112',7000);
INSERT INTO COMPANY_SNACK VALUES('삼양','서울특별시 성북구 오패산로3길 104',5000);
INSERT INTO COMPANY_SNACK VALUES('오리온','서울특별시 용산구 백범로 90다길 13',5400);

SELECT * FROM COMPANY_SNACK;

------------------
--직원의 수가 제일 적은 회사에서 만드는 과자 이름, 가격
SELECT SNACK_MANUFACTURER,SNACK_NAME, SNACK_PRICE FROM JUN3_SNACK WHERE SNACK_MANUFACTURER IN (SELECT COMPANY_NAME 
												FROM COMPANY_SNACK 
												WHERE COMPANY_WORKERS=(
															SELECT MIN(COMPANY_WORKERS) 
															FROM COMPANY_SNACK
															)
												);
SELECT MIN(COMPANY_WOKERS) FROM COMPANY_SNACK;
--제일 비싼 과자를 만든 회사는 어디에 있는지 
SELECT COMPANY_ADDRESS FROM COMPANY_SNACK WHERE COMPANY_NAME IN (	SELECT SNACK_MANUFACTURER 
									FROM JUN3_SNACK 
									WHERE SNACK_PRICE=(
												SELECT MAX(SNACK_PRICE) 
												FROM JUN3_SNACK
											)
								);
--최고가, 최저가로 제품을 파는 업체가 2개가 넘을 경우를 대비해서 메인쿼리의 조건은 IN 으로 데이터를 받아야함
--등호는 단일 대상까지밖에 비교를 못함

--서울에 있는 회사에서 만드는 과자의 평균가
SELECT min(SNACK_PRICE) FROM JUN3_SNACK WHERE SNACK_MANUFACTURER IN (	SELECT COMPANY_NAME 
									FROM COMPANY_SNACK 
									WHERE COMPANY_ADDRESS LIKE '%서울%'
								);
--평균가 이상의 과자를 만드는 회사의 이름, 위치																
SELECT COMPANY_NAME,COMPANY_ADDRESS FROM COMPANY_SNACK WHERE COMPANY_NAME IN (
										SELECT SNACK_MANUFACTURER 
										FROM JUN3_SNACK 
										WHERE SNACK_PRICE > (
													SELECT AVG(SNACK_PRICE) 
													FROM JUN3_SNACK
													) 
										);
																			
	
