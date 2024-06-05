SELECT * FROM TAB;
SELECT * FROM F_OWNER;
SELECT * FROM FRANCHISE;
SELECT * FROM MENU;

--좌석 수 제일 많은 식당을 운영하는 사람의 전체 정보 조회
SELECT * FROM F_OWNER WHERE O_NUMBER IN (	SELECT F_OWNER_NUMBER 
											FROM FRANCHISE 
											WHERE F_SEATS IN (	SELECT MAX(F_SEATS) 
																FROM FRANCHISE 
															) 
										);

--메뉴 전체의 이름, 가격을 오름차순==> 가격이 같은 메뉴라면 가나다 역순으로 정렬
--ORDER BY 문법 잘 보기!
SELECT M_NAME,M_PRICE,M_SELLING_FRANCHISE,M_SELLING_LOC FROM MENU ORDER BY M_PRICE ASC, M_NAME DESC; 
--전체 사장님 이름, 생일 조회
SELECT O_NAME,O_BIRTH FROM F_OWNER;

--프랜차이즈 식당의 갯수
SELECT COUNT(F_NUMBER) FROM FRANCHISE;

--프랜차이즈 식당 메뉴 전체의 평균가
SELECT AVG(M_PRICE) FROM MENU;

--제일 비싼 메뉴의 이름, 가격
SELECT M_NAME, M_PRICE 
FROM MENU 
WHERE M_PRICE IN (	SELECT MAX(M_PRICE)
					FROM MENU
					);

--최연장자 사장님의 이름, 생일
SELECT O_NAME, O_BIRTH
FROM F_OWNER 
WHERE O_BIRTH IN (	SELECT MIN(O_BIRTH)
					FROM F_OWNER
					);
					
--좌석 수 제일 적은 식당의 이름, 지점명, 좌석 수(2개로 끝나는거를 3개짜리로 해놨음...)
--SELECT F_NAME,F_ADDRESS,F_SEATS FROM FRANCHISE 	WHERE F_SEATS IN (	SELECT F_SEATS 
--																	FROM FRANCHISE 
--																	WHERE F_SEATS IN (	SELECT MIN(F_SEATS) 
--																						FROM FRANCHISE 
--																						) 
--																	);
																	
SELECT F_NAME,F_ADDRESS,F_SEATS FROM FRANCHISE 	WHERE F_SEATS IN (	SELECT MIN(F_SEATS) 
																	FROM FRANCHISE 
																						
																	);
--(2개로 끝나는거를 3개짜리로 해놨음...)													
--홍콩반점 서초점을 운영하는 사람의 이름, 생일
--SELECT O_NAME, O_BIRTH FROM F_OWNER WHERE O_NUMBER IN (	SELECT F_OWNER_NUMBER 
--														FROM FRANCHISE 
--														WHERE F_OWNER_NUMBER IN (	SELECT F_OWNER_NUMBER 
--																					FROM FRANCHISE 
--																					WHERE F_ADDRESS LIKE '%서초%'
--																		) 
--																	);
																	
																	
SELECT O_NAME, O_BIRTH FROM F_OWNER WHERE O_NUMBER IN (	 SELECT F_OWNER_NUMBER 
														FROM FRANCHISE 
														WHERE F_ADDRESS LIKE '%서초%'
														);
																	
																	
--'짜장'이 들어간 음식은 어디가면 먹을 수 있는지 (식당 이름, 지점명) 조회		
SELECT F_NAME, F_ADDRESS FROM FRANCHISE WHERE F_NUMBER IN (	SELECT F_NUMBER 
															FROM FRANCHISE 
															WHERE F_ADDRESS  IN (	SELECT M_SELLING_LOC
																					FROM MENU 
																					WHERE M_NAME LIKE '%짜장%'
																				)
															);
-- 엥간하면 고유키는 1개짜리 따로 지정하는게 편함									
-- 최연소 사장님의 가게에 있는 메뉴의 이름,가격 조회
SELECT M_NAME,M_PRICE 
FROM MENU 
WHERE M_SELLING_FRANCHISE IN (	SELECT F_NAME 
								FROM FRANCHISE 
								WHERE F_OWNER_NUMBER IN (	SELECT O_NUMBER 
															FROM F_OWNER 
															WHERE O_BIRTH IN (	SELECT MAX(O_BIRTH)
																		FROM F_OWNER )
														)
						) AND M_SELLING_LOC IN (	SELECT F_ADDRESS 
													FROM FRANCHISE 
													WHERE F_NUMBER IN(
																		SELECT F_NUMBER 
																		FROM FRANCHISE 
																		WHERE F_OWNER_NUMBER IN (	SELECT O_NUMBER 
																									FROM F_OWNER 
																									WHERE O_BIRTH IN (	SELECT MAX(O_BIRTH)
																												FROM F_OWNER )
																								)
																		)
											);							
							
							
	
)

--최길동이 운영하는 가게의 모든 메뉴 이름, 가격, 사장님 생일

SELECT M_NAME,M_PRICE, (SELECT O_BIRTH 
						FROM F_OWNER 
						WHERE O_NAME = '최길동') AS "OWNER_BIRTH"
FROM MENU
WHERE M_OWNER_NUM IN (	SELECT F_OWNER_NUMBER
						FROM FRANCHISE
						WHERE F_OWNER_NUMBER IN (	SELECT O_NUMBER 
													FROM F_OWNER 
													WHERE O_NAME = '최길동' )
						);
