import matplotlib.font_manager as fm
import matplotlib.pyplot as plt
#카카오톡 대화 파일 가져온 것에서 대화 내용만 정제
# ㅋ : ?, ㅎ: ? , ㅠ:?, ?:?, !:?
# 나온 횟수를 구해서 pie 차트로 나타내기

path = "C:/Users/sdedu/Desktop/Python_lib/kakao.txt"

file = open(path, "r", encoding="UTF-8")

data = file.read().split("\n")

#대화내용.replace("\n","")split(" : ") 으로도 대화내용 추출 가능할듯
# for i in data:
    # if '' in i:
        # data.remove(i)

data.pop(0)

text_list = list([])

data_new = []

for d in data:
    arg = d.split(",")
    for i in arg:
        if "2024년" not in i and ", " not in i:
            data_new.append(i)

data_new.pop(len(data_new)-1)

t_symbol = {"ㅋ":0, "ㅎ":0, "ㅠ":0, "물음표":0, "느낌표":0}

for s in data_new:
    if "ㅋ" in s:
        t_symbol["ㅋ"]+=s.count("ㅋ")
    if "ㅎ" in s:
        t_symbol["ㅎ"]+=s.count("ㅎ")
    if "ㅠ" in s:
        t_symbol["ㅠ"]+=s.count("ㅠ")
    if "?" in s:
        t_symbol["물음표"]+=s.count("?")
    if "!" in s:
        t_symbol["느낌표"]+=s.count("!")
        
print(t_symbol)

print(data_new)

name = list(t_symbol.keys())
count=[]

for a,b in t_symbol.items():
    count.append(int(b))

print(name)
print(count)

fontfile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontfile, size=50).get_name()
plt.rc("font", family=fontName)

c = ['blue', 'green', 'red', 'gray', 'black']

plt.bar(name, count, width=0.4, color=c)
plt.title("Kakao Talk")
plt.xlabel("name")
plt.ylabel("count")

#x축 눈금 설정
plt.xticks(range(len(name)), name)

#그리기, 숫자 데이터 확실하게 숫자형으로 들어가는지 확인해야함 안그러면 그래프 이상해짐
plt.show()




