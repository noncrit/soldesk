--주의! : 이클립스랑 다른 DB랑 문법이 좀 다른 JOIN이 많음!
--테이블 JOIN : 테이블 여러개를 붙여서 RAM에 잠깐 넣어두는 방식

--아래와 같은 JOIN은 나타낼 수 있는 모든 값이 나온다.(INNER JOIN)
SELECT * FROM FRANCHISE, F_OWNER;

--원하는 형태의 JOIN 테이블을 만들기 위해서는 조건이 필요
SELECT * FROM FRANCHISE, F_OWNER WHERE F_OWNER_NUMBER = O_NUMBER;

--전체 식당의 이름, 지점명, 사장님 이름, 사장님 생일
SELECT F_NAME,F_ADDRESS,O_NAME,O_BIRTH FROM FRANCHISE, F_OWNER WHERE F_OWNER_NUMBER = O_NUMBER;

--전체 메뉴명, 가격, 식당이름, 지점명
SELECT M_NAME,M_PRICE,F_ADDRESS FROM MENU, FRANCHISE WHERE F_OWNER_NUMBER = M_OWNER_NUM;
SELECT M_NAME,M_PRICE,F_ADDRESS FROM MENU LEFT INNER JOIN FRANCHISE ON F_OWNER_NUMBER = M_OWNER_NUM;


--좌석의 수가 50석 이상인 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석 수
SELECT M_NAME,M_PRICE,F_NAME,F_ADDRESS,F_SEATS FROM MENU, FRANCHISE WHERE F_OWNER_NUMBER = M_OWNER_NUM AND F_SEATS>=50;

--규모가 제일 큰 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석 수
SELECT M_NAME,M_PRICE,F_NAME,F_ADDRESS,F_SEATS 
FROM MENU, FRANCHISE 
WHERE F_OWNER_NUMBER = M_OWNER_NUM AND F_SEATS IN (	SELECT MAX(F_SEATS)
							FROM FRANCHISE	);

--최연장자 사장님이 운영하는 식당의 전체 메뉴명, 가격, 식당이름, 지점명, 사장님 이름, 생일
--메뉴명은 가나다순으로 출력, 메뉴명이 같다면 식당이름 가나다순
SELECT M_NAME,M_PRICE,F_NAME,F_ADDRESS,O_NAME, O_BIRTH
FROM MENU, FRANCHISE, F_OWNER
WHERE M_OWNER_NUM = O_NUMBER 
	AND F_OWNER_NUMBER = M_OWNER_NUM 
	AND O_BIRTH IN (SELECT MIN(O_BIRTH)
					FROM F_OWNER
					)
ORDER BY M_NAME ASC, F_NAME ASC;
