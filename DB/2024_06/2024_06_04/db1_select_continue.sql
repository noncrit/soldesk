
	--관계 연산자
	--NOT, AND, OR, BETWEEN, IN

	--AND, BETWEEM
--가격이 1000원 이상 3000원 이하인 과자의 전체 내용을 조회
SELECT * FROM JUN3_SNACK WHERE SNACK_PRICE>=1000 AND SNACK_PRICE<=3000 ORDER BY SNACK_NUMBER ASC;
SELECT * FROM JUN3_SNACK WHERE SNACK_PRICE BETWEEN 1000 AND 3000 ORDER BY SNACK_NUMBER DESC;

--BETWEEN은 이상/이하로 조건 범위를 고정해놨기 때문에 초과, 미만에 대한 표현이 어려움

--가격이 1000원 이거나 2000원 이거나 3000원인 과자의 전체 정보 조회
SELECT * FROM JUN3_SNACK WHERE SNACK_PRICE=1000 OR SNACK_PRICE=2000 OR SNACK_PRICE=3000 ORDER BY SNACK_PRICE ASC;
--지금이야 조건이 3개 밖에 안되니 그냥 풀어쓰지만, 나중에 OR 조건 많이 붙으면 많이 귀찮아짐
--좀 편하게 작성 할 수 있는 방법? => 그래서 등장한게 IN

SELECT * FROM JUN3_SNACK WHERE SNACK_PRICE IN (1000,2000,3000) ORDER BY SNACK_NUMBER ASC;
--가독성이 매우 좋아짐
--연속되지 않은 값들을 받아오고 싶을 때 => IN 사용

--위의 결과들에 반대되는 결과값을 받아오고 싶은 경우? => NOT 연산자
SELECT * FROM JUN3_SNACK WHERE SNACK_PRICE NOT IN (1000,2000,3000) ORDER BY SNACK_NUMBER ASC;

---------------------------------------------

--패턴 연산자
--문자열을 포함하는 검색을 할 때 사용함 : LIKE '패턴'
--이때 패턴에는 %를 넣는데, 뭐가 들어올지 모른다는 뜻
--LIKE '%ㅋ'	: ㅋ으로 끝나는 패턴
--LIKE 'ㅋ%'	: ㅋ으로 시작하는 패턴
--LIKE '%ㅋ%': ㅋ이 포함된 패턴
--그럼 LIKE 대신 (= 'ㅋ%')는 작동이 안될까? => 등호를 써서 식을 표현하면 ㅋ%를 그냥 문자로 인식해버림

--특정한 단어 찾아보기 '오'라는 글자가 들어가는 회사에서 만든 과자의 이름을 조회
SELECT SNACK_NAME FROM JUN3_SNACK WHERE SNACK_MANUFACTURER LIKE '오%';
--'이'가 들어가는 과자들의 평균가를 조회
SELECT ROUND(AVG(SNACK_PRICE), 1) FROM JUN3_SNACK WHERE SNACK_NAME LIKE '%이%';
--크라운 과자거나, 몽쉘 ~ 인거 이름, 제조사, 가격 조회
SELECT SNACK_NAME,SNACK_MANUFACTURER,SNACK_PRICE FROM JUN3_SNACK WHERE SNACK_MANUFACTURER '크라운' OR SNACK_NAME LIKE '몽쉘%';
--과자의 이름이 '새콤달콤'을 포함하거나 '콘칲'을 포함하는 과자 이름, 제조사, 가격
SELECT SNACK_NAME,SNACK_MANUFACTURER,SNACK_PRICE FROM JUN3_SNACK WHERE SNACK_NAME LIKE '%새콤달콤%' OR SNACK_NAME LIKE '%콘칲%';
--IN은 여기다 못씀( LIKE IN 같은거는 안됨)

--REGEXP_LIKE(컬럼명, 패턴1|패턴2|패턴3...);
--정규표현식(REGEX)으로 구현한 문자 찾는 함수

--과자의 이름이 '콘'으로 시작하거나 '나초'로 끝나는 과자의 이름, 제조사, 가격
SELECT SNACK_NAME,SNACK_MANUFACTURER,SNACK_PRICE FROM JUN3_SNACK WHERE REGEXP_LIKE(SNACK_NAME, '^콘|나초$');

----------------------------------------------
--집합 연산자
--	합집합
--	UNION : 중복되는 값을 제외하고 출력
SELECT 1 ID, '수학' SUBJECT, 90  SCORE FROM DUAL
UNION
SELECT 1 ID, '수학' SUBJECT, 90  SCORE FROM DUAL
UNION
SELECT 1 ID, '수학' SUBJECT, 90  SCORE FROM DUAL;

--	UNION ALL : 중복되는 값을 포함해서 출력
SELECT 1 ID, '수학' SUBJECT, 90  SCORE FROM DUAL
UNION ALL
SELECT 1 ID, '수학' SUBJECT, 90  SCORE FROM DUAL
UNION ALL
SELECT 1 ID, '수학' SUBJECT, 90  SCORE FROM DUAL;

--	교집합
--	INTERSECT : 두 집합 중 공통되는 값 출력
SELECT 1 ID, '수학' SUBJECT, 90  SCORE FROM DUAL
UNION
SELECT 2 ID, '영어' SUBJECT, 80  SCORE FROM DUAL
INTERSECT
SELECT 1 ID, '수학' SUBJECT, 90  SCORE FROM DUAL;

--	차집합
--	MINUS : A,B 두 셀렉문에 대하여 A의 원소중 B에 없는 것을 출력 
--Q. A-B-C 이면 ((A-B)-C) 인가??
SELECT 1 ID, '수학' SUBJECT, 90  SCORE FROM DUAL
MINUS
SELECT 2 ID, '영어' SUBJECT, 80  SCORE FROM DUAL
MINUS
SELECT 3 ID, '수학' SUBJECT, 100  SCORE FROM DUAL;

--과자의 데이터 중에서 회사가 크라운이고 가격이 1000원 이하이거나 3000원 이상인 과자의 전체 정보를 조회(연산자 우선순위 예제)
SELECT * FROM JUN3_SNACK WHERE SNACK_MANUFACTURER='크라운' AND SNACK_PRICE<=1000 OR SNACK_PRICE>=3000;

SELECT * FROM JUN3_SNACK WHERE SNACK_MANUFACTURER='크라운' AND (SNACK_PRICE<=1000 OR SNACK_PRICE>=3000);


--연산자의 우선순위
--OR < AND < NOT < 비교연산자 < 괄호

------------------------
--GROUP BY : 특정 컬럼 기준으로 대상 컬럼들을 그룹으로 묶어 연산해서 하나의 결과로 나타내는 역할
--회사별 과자의 평균가격, 최소가격, 최고 가격
SELECT AVG(SNACK_PRICE) FROM JUN3_SNACK WHERE SNACK_MANUFACTURER='오리온';
SELECT MIN(SNACK_PRICE) FROM JUN3_SNACK WHERE SNACK_MANUFACTURER='오리온';
SELECT MAX(SNACK_PRICE) FROM JUN3_SNACK WHERE SNACK_MANUFACTURER='오리온';

SELECT	SNACK_MANUFACTURER,ROUND(AVG(SNACK_PRICE),1) AS AVG_PRICE ,
		MIN(SNACK_PRICE) AS MIN_PRICE,
		MAX(SNACK_PRICE) AS MAX_PRICE FROM JUN3_SNACK GROUP BY SNACK_MANUFACTURER;
		
--ROLL UP 연산자 : 컬럼에 대한 소계(SUBTOTAL)을 만들어줌
--GROUP BY ROLLUP(그룹 대상)
--GROUP BY 절의 컬럼 갯수가 N개라면, ROLLUP을 썼을 때는 N+1개의 컬럼이 결과로 나옴

--회사의 이름, 회사별 과자 총 가격의 합계, 모든 과자들의 가격 합계

SELECT SNACK_MANUFACTURER,SUM(SNACK_PRICE) FROM JUN3_SNACK GROUP BY ROLLUP(SNACK_MANUFACTURER);

--SNACK_MAKER 가 NULL이면 '전체', 그게 아니면 S_MAKER 값
SELECT NVL2(SNACK_MANUFACTURER, SNACK_MANUFACTURER, '전체'), SUM(SNACK_PRICE) FROM JUN3_SNACK GROUP BY ROLLUP(SNACK_MANUFACTURER);


--DECODE(컬럼명, 조건, 조건에 맞을 경우 결과값, 조건에 맞지 않을 경우 결과값)
--DECODE 사용시 : 조건 자리에는 비교연산자 못씀, 산술 연산자만 사용 가능
SELECT DECODE(SNACK_MANUFACTURER, NULL,'전체',SNACK_MANUFACTURER), SUM(SNACK_PRICE) FROM JUN3_SNACK GROUP BY ROLLUP(SNACK_MANUFACTURER);
------------------------------

--HAVING : GROUP BY 절에 의해 만들어진 결과 중 원하는 조건에 부합하는 자료만 뽑아오고 싶을 때 사용
--HAVING, WHERE : 모두 조건을 활용해서 우리가 원하는 데이터만 추출하는데 이용됨
--HAVING 절 : 그룹의 결과 제한
--WHERE 절 : 조건을 사용해서 결과를 필터링 한 뒤 그룹화 

--회사별 과자의 평균 가격이 2000원 이상인 외사의 이름, 평균 가격을 조회
SELECT SNACK_MANUFACTURER, ROUND( AVG(SNACK_PRICE), 1) FROM JUN3_SNACK GROUP BY SNACK_MANUFACTURER HAVING  AVG(SNACK_PRICE)>=1000;

SELECT SNACK_MANUFACTURER, ROUND( AVG(SNACK_PRICE), 1) FROM JUN3_SNACK HAVING  AVG(SNACK_PRICE)>=1000 GROUP BY SNACK_MANUFACTURER ;

--ORDER BY : 정렬 ASC(오름차순), DESC(내림차순)
--ORDER BY 정렬대상 ASC/DESC;

--크라운 또는 삼양 회사의 과자 평균가격이 1800원 이상일 때, 각 회사의 평균 가격을 내림차순 정렬
SELECT SNACK_MANUFACTURER, ROUND( AVG(SNACK_PRICE), 1) FROM JUN3_SNACK
	WHERE SNACK_MANUFACTURER IN('크라운','삼양') 
	GROUP BY SNACK_MANUFACTURER HAVING AVG(SNACK_PRICE)>=1000 
	ORDER BY AVG(SNACK_PRICE) DESC;
















