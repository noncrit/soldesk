-- 음료 테이블과 카페 테이블

--음료 테이블 : 음료이름 / 가격 / 판매하는 카페의 이름
--카페 테이블 : 카페이름 / 지역 / 좌석 수
--조건 : 참조관계 고려 x, 각 테이블에서 음료이름, 카페이름은 고유한 값을 갖는다.

CREATE TABLE CAFE(
	CAFE_NAME VARCHAR2(15 CHAR) PRIMARY KEY,
	CAFE_ADDRESS VARCHAR2(10 CHAR) NOT NULL,
	CAFE_NUM_OF_SEATS NUMBER(5) NOT NULL
);

CREATE TABLE BAVERAGE(
	B_NAME VARCHAR2(15 CHAR) PRIMARY KEY,
	B_PRICE NUMBER(10) NOT NULL,
	B_NAME_OF_CAFE VARCHAR2(15 CHAR) NOT NULL
);


--A라는 카페는 서울에 위치하고 좌석은 100석
--A (아메리카노,2000원) , (라떼,3000원), (녹차,2000원)울 판매

INSERT INTO CAFE VALUES('A','서울',100);
INSERT INTO BAVERAGE VALUES('아메리카노',2000,'A');
INSERT INTO BAVERAGE VALUES('라떼',3000,'A');
INSERT INTO BAVERAGE VALUES('녹차',2000,'A');

--B라는 카페는 제주도에 위치하고 좌석은 80석
--B (홍차,2500원) , (스무디 ,3000원), (에스프레소, 4000원)울 판매
INSERT INTO CAFE VALUES('B','제주도',80);
INSERT INTO BAVERAGE VALUES('홍차',2500,'B');
INSERT INTO BAVERAGE VALUES('스무디',3000,'B');
INSERT INTO BAVERAGE VALUES('에스프레소',4000,'B');

SELECT * FROM CAFE;
SELECT * FROM BAVERAGE;

--3. 쿼리문 작성
--전체 음료 기준 평균가보다 비싼 음료는 몇 종류?
SELECT COUNT(B_NAME) FROM BAVERAGE WHERE B_PRICE>(
													SELECT ROUND(AVG(B_PRICE),1) 
													FROM BAVERAGE
													);
												
--제일 싼 음료를 파는 카페의 이름은?
SELECT CAFE_NAME FROM CAFE WHERE CAFE_NAME IN (
												SELECT B_NAME_OF_CAFE
												FROM BAVERAGE
												WHERE B_PRICE IN (
																	SELECT MIN(B_PRICE) 
																	FROM BAVERAGE
																	)	
												);
--
--서울에 있는 카페에서 만드는 음료의 평균가?
SELECT ROUND(AVG(B_PRICE), 1) FROM BAVERAGE WHERE B_NAME_OF_CAFE IN (SELECT B_NAME_OF_CAFE
														FROM BAVERAGE
														WHERE B_NAME_OF_CAFE IN (
																				SELECT CAFE_NAME 
																				FROM CAFE
																				WHERE CAFE_ADDRESS LIKE '%서울%'
																				)	
													);
--좌석이 90석 이상인 카페에서 파는 음료의 이름?	
SELECT B_NAME FROM BAVERAGE WHERE B_NAME_OF_CAFE IN (
													SELECT B_NAME_OF_CAFE
													FROM BAVERAGE
													WHERE B_NAME_OF_CAFE IN (
																			SELECT CAFE_NAME 
																			FROM CAFE
																			WHERE CAFE_NUM_OF_SEATS >= 90
																			)	
													);
--전체 음료 기준 평균가 이하인 음료의 이름?
SELECT B_NAME FROM BAVERAGE WHERE B_PRICE<=  (
														SELECT ROUND(AVG(B_PRICE),1) 
														FROM BAVERAGE
													);	
													
--가장 비싼 음료를 파는 카페는 어디에 있는지?
SELECT CAFE_ADDRESS FROM CAFE WHERE CAFE_NAME IN (
													SELECT B_NAME_OF_CAFE
													FROM BAVERAGE
													WHERE B_PRICE IN (
																			SELECT MAX(B_PRICE) 
																			FROM BAVERAGE
																			)	
													);												