CREATE TABLE JUN28_LOGIN(
	j_ID VARCHAR2(20 CHAR) NOT NULL,
	j_PW VARCHAR2(20 CHAR) NOT NULL,
	j_PN VARCHAR2(40 CHAR) NOT NULL,
	j_NAME VARCHAR2(40 CHAR) NOT NULL,
	j_BIRTH VARCHAR2(20 CHAR) NOT NULL,
	j_IMG VARCHAR2(200 CHAR) NOT NULL,
	CONSTRAINT PK_LOGIN PRIMARY KEY(j_ID)
);

DROP TABLE JUN28_LOGIN;

truncate table JUN28_LOGIN;

INSERT INTO JUN28_LOGIN VALUES('ksj','12345','01012345678', 'kim', '19970509','C:\Users\sdedu\Desktop\tmp_web');


SELECT * FROM JUN28_LOGIN;

SELECT * FROM JUN28_LOGIN WHERE j_ID='ksj';

--SELECT * FROM TAB;
--PURGE RECYCLEBIN;