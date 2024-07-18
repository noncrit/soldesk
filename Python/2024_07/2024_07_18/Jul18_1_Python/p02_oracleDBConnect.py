#p02_oracleDBConnect
from cx_Oracle import connect

# 오라클DB와 연동이 되는 Java : InstantClient에 있는 ojdbc8.jar을 사용했음
# 오라클DB와 연동이 되는 Python: cx_Oracle.py 활용(Instant Client를 사용하게 해줌)

#기본적으로 Python에는 OracleDB에 대한 연결 기능이 존재하지 않음
#시작 - cmd - >pip install cx_oracle
#설치 후 pip list 명령으로 설치 확인

#sqlplus로 접속할 때 주소가 하나 필요함
#sqlplus [ID]/[PW]@[ip:address]:[Port]/[SID]
#sqlplus jin/asd321@localhost:1521/xe

#cx_oracle의 connect
try:
    c = connect("jin/asd321@localhost:1521/xe")
    print("연결 성공")
    
except Exception as e:
    print(e)
    
c.close()