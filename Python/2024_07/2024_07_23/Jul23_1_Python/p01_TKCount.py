
sss = list(["ㅋㅋㅋ","ㅁㅁㅁ", "ㅂㅂㅂ", "ㅎㅎㅎ", "ㅁㅁㅋㅋㅋ", "ㄹㄹㄹ"])

#find
#찾는 문자열이 존재하는 경우 리스트 상에서 해당 문자열의 인덱스 번호를 리턴하고, 없다면 -1을 리턴함

# for s in sss:
    # print(s.find("ㅋㅋㅋ"))
    # print(s.find("ㅊㅊㅊ"))
    # print("-------------")
    


#조조(맹덕), 유비(현덕), 손권(중모)
#삼국지 1~10 권을 훑어보면서 => 위의 인물들이 몇 번 언급되었는지 카운팅하기
#인물 , 언급 횟수의 형태로 하나의 csv 파일에 저장하기

def count_jojo(s):
    temp_count=0
    for j in s:
        if j.find("조조")!=-1 or j.find("맹덕")!=-1:
            temp_count+=1
    return temp_count

def count_yubi(s):
    temp_count=0
    for j in s:
        if j.find("유비")!=-1 or j.find("현덕")!=-1:
            temp_count+=1
    return temp_count

def count_son(s):
    temp_count=0
    for j in s:
        if j.find("손권")!=-1 or j.find("중모")!=-1:
            temp_count+=1
    return temp_count

#C:\Users\sdedu\Desktop\Python_lib\ThreeKingdoms\ThreeKingdoms

################################
jojo_count = 0
yubi_count = 0
son_count =0
#이거를 dict 형식으로 처리해도 상관 없음

count_list = {"조조":0,"유비":0,"손권":0}

#%02d.txt %i
#1~10권 처리
#포맷팅 익숙해지기!
for i in range(0,10):
    path = "C:/Users/sdedu/Desktop/Python_lib/ThreeKingdoms/ThreeKingdoms/ThreeKingdoms%02d.txt"%(i+1)
    # print(path)
    file = open(path, encoding="UTF-8")
    data = file.read().replace("\n","").split(" ")
    print(f"-----{i+1}권---------")
    # print(data)
    jojo = count_jojo(data)
    yubi = count_yubi(data)
    son = count_son(data)
    
    jojo_count += jojo
    count_list["조조"]+=jojo
    
    yubi_count += yubi
    count_list["유비"]+=yubi
    
    son_count += son
    count_list["손권"]+=son
    
    
    print(f"조조 {i+1}권 등장 수 : ", jojo)
    print(f"유비 {i+1}권 등장 수 : ", yubi)
    print(f"손권 {i+1}권 등장 수 : ", son)
      
write_path = "C:/Users/sdedu/Desktop/Python_lib/ThreeKingdoms/ThreeKingdoms/result.csv" 
file = open(write_path, "w", encoding="UTF-8")
file.write(f"조조,{jojo_count}\n")
file.write(f"유비,{yubi_count}\n")
file.write(f"손권,{son_count}\n")
    
file.close()   

