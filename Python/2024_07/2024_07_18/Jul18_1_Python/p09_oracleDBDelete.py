#select 번호순으로 조회 - 콘솔에 출력
#해당 커피의 번호를 입력하면 해당 데이터가 삭제
#999를 입력하면 프로그램 종료 => 그 전까지 반복

from cx_Oracle import connect

con = connect("jin/asd321@localhost:1521/xe")

sql = "select * from jul18_coffee order by c_no asc"

print("----프로그램 실행중-------")
target = 0
while target!=999:
    
    cur = con.cursor()
    cur.execute(sql)

    for no,menu,price,bean in cur:
        print(f"{no}번 : {bean} {menu} {price}원 ")
        
    target = int(input("삭제할 메뉴의 번호를 입력해주세요, 999를 입력하면 프로그램을 종료합니다.\n"))
    sql2 = f"delete from jul18_coffee where c_no = {target}"
    cur.execute(sql2)
    if cur.rowcount ==1:
        con.commit()
        print(f"--{target}번 메뉴 삭제됨--")
    
    if target==999:        
        print("--프로그램을 종료합니다.--")

con.close()