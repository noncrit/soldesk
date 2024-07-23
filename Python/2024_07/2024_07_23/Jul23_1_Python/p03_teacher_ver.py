import matplotlib.font_manager as fm
import matplotlib.pyplot as plt
#카카오톡 대화 파일 가져온 것에서 대화 내용만 정제
# ㅋ : ?, ㅎ: ? , ㅠ:?, ?:?, !:?
# 나온 횟수를 구해서 pie 차트로 나타내기

path = "C:/Users/sdedu/Desktop/Python_lib/kakao.txt"

file = open(path, "r", encoding="UTF-8")

t_symbol = {"ㅋ":0, "ㅎ":0, "ㅠ":0, "?":0, "!":0}

for line in file.readlines():
    line = line.replace("\n","")
    if " : " in line:
        lines = line.split(" : ", 1)    #첫번째 " : " 에서만 분리하겠다는 의미
        if len(lines)==2:
            dialog = lines[-1]
            for w in dialog:    #한글자씩 판단하기
                if w in t_symbol:
                    t_symbol[w]+=1
            
        

word = []
count = []

for k,v in t_symbol.items():
    word.append(k)
    count.append(int(v))

print(t_symbol)
plt.rcParams['font.family'] ='Malgun Gothic'
plt.rcParams['axes.unicode_minus'] =False

c = ['blue', 'green', 'red', 'gray', 'black']
w = {"width":0.7, "edgecolor":"black", "linewidth":5}
plt.pie(count, labels=word, autopct="%.2f%%", wedgeprops=w) #wedgeprops : 테두리
plt.show()





