--메뉴 데이터를 갯수를 나눠서 페이지로 보여주고 싶다.
--메뉴 테이블에는 PRIMARY KEY M_NUM이 있음(시퀀스 일부러 안썼음) 
--SEQUENCE는 ISNERT 실패해도 카운터가 올라감
--중간에 메뉴 데이터 지울 가능성도 있음
--M_NUM 을 시퀀스로 구현했으면 1,2,3,4 ... 을 정확히 나타내지 못함
--어떻게 극복할까?
-------------------------
--RowNUM (가상 필드)
-- SELECT 를 할 때마다 자동으로 부여되는 숫자
-- *(전체) 와는 같이 사용불가
-- ORDER BY 보다 값이 먼저 처리됨**
-- 무조건 1번부터 조회해야함
-- SELECT 사용시 선언하지 않아도 ROWNUM 이 자동으로 선언됨
--참고: Top-n processing, pagination

--메뉴의 이름을 가나다 순으로 정렬해서 메뉴 전체 정보를 조회
SELECT ROWNUM, M_NAME,M_PRICE,M_SELLING_FRANCHISE,M_SELLING_LOC,M_OWNER_NUM,M_NUM 
FROM MENU 
ORDER BY M_NAME ASC;

--메뉴의 이름을 가나다 순으로 정렬해서 MENU 테이블의 ROWNUM 1~3 까지 전체 정보를 조회
--이렇게 쓰면 ORDER BY 이전에 ROWNUM 이 들어가버림
--우리가 원하는 건 이름순으로 정렬 -> 그 다음 ROWNUM 부여 순으로하는 작업이었음
SELECT ROWNUM, M_NAME,M_PRICE,M_SELLING_FRANCHISE,M_SELLING_LOC,M_OWNER_NUM,M_NUM  
FROM MENU
WHERE ROWNUM BETWEEN 1 AND 3
ORDER BY M_NAME ASC;

--VIEW
--진짜 테이블이 아닌, 가상의 테이블 (테이블 처럼 취급은 함)
--사용자에게 접근이 허용된 자료만을 보여주기 위해 사용
--쿼리문의 형태를 저장하는 형식이라 테이블 구조가 변경되어도 뷰의 구조를 변경하지 않아도 됨 


--서브쿼리로 정렬 먼저 해준 다음 로우넘 호출하면 끝
--Q. 서브쿼리로 부른 로우넘은 그냥 덮어쓰기 처리되나?
--서브쿼리가 FROM 안에서 사용되는 경우 => InLINE View 라고 함


SELECT ROWNUM, M_NAME,M_PRICE,M_SELLING_FRANCHISE,M_SELLING_LOC,M_OWNER_NUM,M_NUM
FROM(
		SELECT ROWNUM, M_NAME,M_PRICE,M_SELLING_FRANCHISE,M_SELLING_LOC,M_OWNER_NUM,M_NUM  
		FROM MENU
		ORDER BY M_NAME ASC
	)
WHERE ROWNUM BETWEEN 1 AND 3;
--단, ROWNUM은 무조건 1번 부터 조회해야하기 때문에 1이 범위에서 벗어나는 순간 이렇게는 구현이 안됨

-- 2~4 를 뽑아내보기
--select 문을 바깥쪽에 한번 더 씌워주면 내부의 rownum이 숫자만 부여해 놓고 효력을 잃어버린다. => 많이 써먹을 예정
--안쪽 SELECT 과 바깥쪽 SELECT 모두 ROWNUM이 생성되니, 안쪽 ROWNUM의 이름을 지정
--그리고 바깥쪽에서 바깥쪽 ROWNUM이 아닌, 안쪽에서 이미 생성된 ROWNUM을 참조하는 식으로 가면 1번 이후 번호에서 ROWNUM 사용 가능
SELECT *
FROM(
		SELECT ROWNUM AS RN, M_NAME, M_PRICE 
		FROM MENU
		ORDER BY M_NAME ASC
	)
WHERE RN BETWEEN 3 AND 12;


--이름이 길동인 사장님댁에 있는 메뉴명, 가격, 식당명, 지점명, 사장님 이름 조회
--가격을 내림차순으로 정렬 / 가격이 같다면 메뉴명을 가나순으로 정렬한 후에
--그 데이터의 3~8 번을 조회
SELECT *
FROM(
	SELECT M_NAME, M_PRICE, F_NAME, F_ADDRESS, O_NAME, ROWNUM AS RN
	FROM MENU,FRANCHISE,F_OWNER 
	WHERE 	M_OWNER_NUM = O_NUMBER
		AND F_OWNER_NUMBER = O_NUMBER
		AND O_NAME LIKE '%길동%'
	ORDER BY M_PRICE DESC, M_NAME ASC
	)
WHERE RN BETWEEN 3 AND 8;

--김씨 성을 가진 사장님네 메뉴명, 가격, 사장님 이름, 사장님 성별
--가격 오름차순으로 정렬한 후에
-- 그 데이터의 2~3번만 조회
SELECT *
FROM(
	SELECT M_NAME, M_PRICE, O_NAME, O_SEX, ROWNUM AS RN
	FROM MENU,F_OWNER 
	WHERE 	M_OWNER_NUM = O_NUMBER
		AND O_NAME LIKE '김%'
	ORDER BY M_PRICE ASC, M_NAME ASC
	)
WHERE RN BETWEEN 2 AND 3;
