import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
import numpy as np

#음수 부호(마이너스 값) 안나오는 것 방지
plt.rcParams["axes.unicode_minus"] = False

fontFile = "C://Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

xData = np.array([1,2,3,4])
yData = np.array([12,31,7,24])
yData2 = np.array([1,51,23,10])

c = ['#FFB2D9', '#D941C5', '#B5B2FF', '#FFC19E']

# plt.bar(xData, yData, width=0.5, edgecolor="#670000", linewidth=5, color=c)

# plt.show()

#하나의 데이터에 여러 항목 표현하기
# plt.bar(xData, yData, color="#FFC19E", width=0.3, align="edge")
#
# #data에 음수 붙이면 바로 위 그래프의 옆으로 이동
# plt.bar(xData-0.3, yData2, color="#FFB209", width=-0.3, align="edge")

#겹친 그래프 분리하려면? width 조절
#edge 정렬 : 막대의 기본 x축 위치에서 한쪽 끝에 눈금 표시
#width 값에 음수를 붙이면 바 그래프의 정렬이 오른쪽 기준으로 하도록 바뀜


#누적합
plt.bar(xData, yData, color="#B5B2ff")
plt.bar(xData, yData, color="FFC19E",bottom=yData)
plt.show()