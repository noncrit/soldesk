

#파일로부터 데이터를 읽어와서 프로그램에서 활용하기 위함
#프로그램에서 만든 데이터를 파일형태로 저장하기 위함

#파일 열기 -> 작업(읽기, 쓰기) -> 파일 닫기(필수)

#.txt 파일 / .csv(Comma Seperated Value) 파일

#1. 파일에 내용 작성(write)
#파일 저장을 위한 디렉토리는 존재해야함 / 파일이 존재하지 않아도 프로그램 실행시 알아서 해당 파일명으로 파일 작성됨
#C:\Users\sdedu\Desktop\Python_lib\file_test

#파라미터
#file: 경로 표기시 백슬래시 2개 or 그냥 슬래시로 통일
#mode: 모드 지정 "w" 쓰기 - 이름이 같으면 덮어쓰기
#encoding : 인코딩 방식

# file = open("C:\\Users\\sdedu\\Desktop\\Python_lib\\file_test/test.txt", "w",  encoding="UTF-8")
# file.write("오늘 비가 겁나 오네요 ㅜㅜ")
# print("쓰기 완료")
#
# #닫는거 필수!!!
# file.close()

#2. 파일에 내용 추가하고 싶을 때(append)
# file = open("C:\\Users\\sdedu\\Desktop\\Python_lib\\file_test/test.txt", "a",  encoding="UTF-8")
# file.write("\n비도 오고 그래서 \n네 생각이 나서")
# print("작성 완료")
# file.close()



#3-1 파일 전체 읽기
# file = open("C:\\Users\\sdedu\\Desktop\\Python_lib\\file_test/test.txt", "r",  encoding="UTF-8")
# data = file.read()
# print(data)
# file.close()

#3-2 파일 한줄씩 읽기 - 루프로 줬기 때문에 프로그램이 계속 돌아감
file = open("C:\\Users\\sdedu\\Desktop\\Python_lib\\file_test/test.txt", "r",  encoding="UTF-8")
while True: #파일 내용이 언제 끝날지 모르니까 그냥 True로
    data = file.readline() #한 줄씩 읽는 함수
    print(data, end="")
    #realine()의 마지막 실행 결과가 ""인 상황 - EOF 도달    
    if data=="":
        break
file.close()


