
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
import numpy as np
from matplotlib.lines import lineStyles

#Numpy : 다차원 배열, 행렬 연산

fontFile = "C://Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

#Matplolib 에서는 일반적으로 Numpy에 있는 Array를 이용함
#Numpy를 사용하지 않았어도, 모든 시퀀스는 내부적으로 Numpy Array로 변환되어 사용됨

yData = np.array([12,31,1,2]) #Numpy의 배열
xData = [1,2,3,4] # Numpy array 선언을 안했지만, 나중에 그래프에 사용 할 때 자동 변환됨

#선 그래프 그리기
# plt.plot(yData)
# plt.show()

#x,y 지정하기
# plt.plot(xData, yData)
# plt.show()

#축 관련 설정
# plt.plot(xData, yData)
# plt.xlabel("x축")
# plt.ylabel("y축")
# plt.axis([0,10,0,50])   #축에 표시할 x의 최소 최대 / y의 최소 최대 지정 가능 [xMin, xMax, yMin, yMax]
# plt.show()

#제목 관련 설정
#plt.plot(xData,yData)
#f = {"fontsize":15, "fontweight":"light"}   #폰트의 형식을 dict로 선언해서 넘겨줌
#plt.title("ㅋㅋ", loc="left",fontdict=f)    #파라미터 : loc = 제목 위치, fontdict = 폰트 설정이 담긴 dict를 받음

#style(선 스타일)
#색, 선의 모양, 마커의 모양 3가지를 건드렸음

# b:blue, r:red, g:green, k : black, y: yellow w:white, c : cyan -내장 색상들
#plot함수의 color 옵션으로  RGB 값 지정도 가능함
#맨앞 c- : cyan

#-. : 선의 모양
# ':' -> 점선 / '-' -> 실선 / '--' -> dashed line / '-.' -> 실선 + 점선
#plot 함수의 linestyle이라는 옵션으로 지정하는 것이 가능

#마커의 모양
#'.' : 점 / 'o' : 동그라미 / 'v' : 아래를 향하는 삼각형 / '^' : 위를 향하는 삼각형
#'<', '>' : 왼쪽, 오른쪽을 향하는 삼각형 / 's' : 사각형 / 'p' : 오각형
#'h' : 육각형 / '*' : 별 / '+' : + 모양 / 'x' : x 모양
#plot 함수의 marker 옵션으로 지정하는 것이 가능
# plt.plot(xData,yData, color="cyan", linestyle="--", marker="h"
         # ,linewidth=5, markersize="30")
# plt.show()

#그리드(Grid)
# plt.plot(xData,yData)
# plt.grid(axis = "both", color="#997700", linestyle="-.")
# plt.show()

#눈금
# plt.plot(xData, yData)
# plt.xticks(xData, ["일", "이", "삼", "사"])
# plt.yticks(np.arange(0, 41, 10), ["ㄱ","ㄴ", "ㄷ", "ㄹ", "ㅁ"])
# #눈금디자인 - tick_params / 파라미터 axis = x,y,both    direction = in, out, inout
# plt.tick_params(axis="x", direction="inout", length=10, pad=15,
                # color="r", labelsize=20, labelcolor="#F15F5F")
# plt.show()

#선
# plt.plot(xData, yData)
#
# #실제 y 값 / xmin, xMax => 지정한 점을 따라서 수평선 그리기 가능
# plt.hlines(31, 1, 2, colors="r", linestyles="--")
#
# #실제 x값 ,ymin, ymax => 지정한 점을 따라서 수직선
# plt.vlines(1,31,12, color="r", linestyles="--")
# plt.show()

#선 여러 개 그리기
xData = [1,2,3,4]
yData = np.array([12,31,1,2])
# # yData2 = [5,66,1,10]
# #데이터 편차가 큰 경우, x 그래프가 일직선에 가까워짐
# yData2 = [500,600,100,1000]
#
# plt.plot(xData, yData, "r-")
# plt.plot(xData, yData2, "g:")
# #그래프 선언된 순서대로 적으면 그 순서 따라 범주로 표시됨
# plt.legend(["빨강 데이터", "초록 데이터"])
# plt.show()

#선 여러 개 (y축을 나눠서 그리기)
yData2 = [500,600,100,1000]

x1 = plt.subplot()  #여러 그래프들을 동시에 시각화
p1 = x1.plot(xData, yData, "r-")
x1.set_xlabel("X축")
x1.set_ylabel("Y축")

#twinx - x축을 공유하는 그래프
x2 = x1.twinx()
p2 = x2.plot(xData, yData2, "g:")
x2.set_ylabel("Y축2")
#p1 + p2 는 범주 합치기
x1.legend(p1 + p2, ["Red", "Green"])
plt.show()

