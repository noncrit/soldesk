import matplotlib.font_manager as fm
import matplotlib.pyplot as plt

#파이썬 데이터 시각화 라이브러리 - matplotlib
#pip install matplotlib

name = list([])
count = list([])

path ="C:/Users/sdedu/Desktop/Python_lib/ThreeKingdoms/ThreeKingdoms/result.csv"

file = open(path,"r",encoding="UTF-8")

#readlines로 가져와서 1줄씩 처리 -> 데이터 담기도 가능(읽어온 리스트 0번째 인덱스는 이름, 1번째는 횟수가 들어가도록)
data = file.read()
data = data.replace("\n", ",").split(",")
length = len(data)
data.pop(length-1)
print(data)

index_counter = 0
for d in data:
    if index_counter%2==0:
        name.append(d)
    else:
        count.append(int(d))
    index_counter+=1

print("-----------")
print(name)
print(count)

file.close()

fontfile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontfile, size=50).get_name()
plt.rc("font", family=fontName)

c = ['blue', '#B2CCFF', '#FFA7A7']

#막대 그래프 - 절대적인 값 비교

# plt.bar(name, count, width=0.4, color=c)
# plt.title("Three Kingdoms")
# plt.xlabel("name")
# plt.ylabel("count")
#
# #x축 눈금 설정
# plt.xticks(range(len(name)), name)
#
# #그리기, 숫자 데이터 확실하게 숫자형으로 들어가는지 확인해야함 안그러면 그래프 이상해짐
# plt.show()

#파이차트 (원 그래프) - explode -> 원점으로부터 각 항목이 튀어나오는 정도
plt.pie(count, labels=name, colors=c, shadow=True, explode=(0.0,0.1,0.2))
plt.title("Three Kingdoms")
plt.show()



    
