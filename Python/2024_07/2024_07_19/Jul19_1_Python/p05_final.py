from cx_Oracle import connect
from datetime import datetime

#메뉴만들기(함수)
#1. 학생 등록
#2. 강의장 테이블 조회
#3. 학생 정보 조회
#4. 학생들의 정보를 파일로 내보내기
#0. 프로그램 종료

#강의장 조회 : 1강의장 - 6층 복도 오른쪽 요런형식(name, location)
#학생 조회 : 학생 이름, 생년 월일(연-월-일 (요일)), 나이-계산해서 알려주기, 소속 강의장, 중간 고사 점수, 평균 점수
#파일로 내보내기 : 학생의 전체 정보를 csv 파일로 내보내기

def register():
    print("학생 등록을 시작합니다.\n")
    con = connect("jin/asd321@localhost:1521/xe")
    cur = con.cursor()
    
    s_name = input("학생의 이름을 입력해주세요\n")
    s_birth = input("학생의 생년월일을 입력해주세요. ex)19990521\n")
    classroom = input("학생의 소속 강의장 번호를 입력해주세요 ex) 1강의실인 경우 1\n")
    score_midterm = input("중간 고사 점수를 입력해주세요 (숫자만 입력)\n")
    score_finalterm = input("중간 고사 점수를 입력해주세요 (숫자만 입력)\n")
    
    sql = f"insert into jul19_final_student values("
    sql +=f"jul19_final_student_seq.nextval, '{s_name}',to_date('{s_birth}','YYYY-MM-DD'),"
    sql +=f"'{classroom}강의실',{score_midterm},{score_finalterm})"
    
    cur.execute(sql)
    
    if cur.rowcount==1:
        print("학생 등록 성공\n")
        con.commit()
        
    else:
        print("학생 등록 실패\n")
       
    con.close()
      
def classroomInfo():
    print("전체 강의장 정보를 표시합니다.\n")
    con = connect("jin/asd321@localhost:1521/xe")
    cur = con.cursor()
    
    sql = f"select * from jul19_final_classroom"
    
    cur.execute(sql)
    
    data = cur.fetchall()
    for a,b in data:
        print(f"{a} - {b}")
    
    con.close()
        
def studentInfo():
    print("전체 학생 정보를 표시합니다.")
    con = connect("jin/asd321@localhost:1521/xe")
    cur = con.cursor()
    
    sql = f"select * from jul19_final_student order by s_no"
    
    cur.execute(sql)
    
    data = cur.fetchall()
    #나이 계산을 위한 값
    #그냥 .year 사용해도 상관 없음 datetime.today().year 단, 날짜 자료형 상태여야 사용가능
    now = int(datetime.strftime(datetime.today(),"%Y"))
#학생 조회 : 학생 이름, 생년 월일(연-월-일 (요일)), 나이-계산해서 알려주기, 소속 강의장, 중간 고사 점수, 평균 점수
    #필요 없는 것은 for 파라미터 _ 처리하면 데이터 가져오는 것을 생략 할 수 있음
    for s_no, name, birth, classroom, score_mid, score_final  in data:
        
        # print(datetime.strftime(birth,"%Y"))
        # print(type(int(datetime.strftime(birth,"%Y") ) ) )
        s_no = s_no
        name = name
        birth = f"{birth: %Y-%m-%d} ({birth:%A})"
        s_birth = int(birth[0:5])
        #now는 for 루프 바로 위쪽에 있음
        age =  now - s_birth
        classroom = classroom
        score_mid = int(score_mid)
        score_final = int(score_final)
        score_avg =( int(score_mid) + int(score_final) ) / 2
        
        print("--------------------")
        print(f"{s_no}번\n{name}, {birth}, {age}세, {classroom}")
        print(f"[시험 점수]\n중간고사 : {score_mid}점\n기말고사 : {score_final}점\n평균 : {score_avg}점")
        
    con.close()   
    
def makeCSV():
    print("학생 정보를 csv 파일로 내보냅니다.")
    con = connect("jin/asd321@localhost:1521/xe")
    cur = con.cursor()
    
    sql = f"select * from jul19_final_student"
    cur.execute(sql)
    
    data = cur.fetchall()
    print("DB 데이터 가져오기 성공")
    file = open("C:\\Users\\sdedu\\Desktop\\Python_lib\\file_test/final.csv", "w",  encoding="UTF-8")
    
    for s_no, name, birth, classroom, score_mid, score_final  in data:
        file.write(f"{s_no},{name},{birth},{classroom},{score_mid},{score_final}\n")
             
    print("쓰기 성공")   
    file.close()
    con.close()

def play_main():
    #루프 가동을 위한 상태 표기변수
    state = 1;

    while state!=0:
        print("-----------------")
        print("학원 관리 프로그램")
        print("1. 학생 등록")
        print("2. 강의장 테이블 조회")
        print("3. 학생 정보 조회")
        print("4. 학생들의 정보를 파일로 내보내기")
        print("0. 프로그램 종료")
        print("-----------------")
        
        user_input =int( input("동작 할 메뉴 번호를 입력해주세요\n"))
        
        if user_input==0:
            state=0
            break
        elif user_input==1:
            register()
        elif user_input==2:
            classroomInfo()
        elif user_input==3:
            studentInfo()
        elif user_input==4:
            makeCSV()

#--------------------------
play_main()
    
    
