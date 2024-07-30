#pip install pandas

#Pandas -> 데이터 처리, 분석에 특화된 라이브러리

import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
import pandas as pd

#음수 부호(마이너스 값) 안나오는 것 방지
plt.rcParams["axes.unicode_minus"] = False

fontFile = "C://Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)


path = "C:/Users/sdedu/Desktop/Subway_data/Jul25_Subway_inout.csv"
#pandas의 csv 읽기
#pandas dataframe - 2차원 행렬
#테이블 헤더를 지정해줘야함
df = pd.read_csv(path,
                 names=["언제","호선","역","prn","frn","pan","fan"])
# print(df)

#groupby() -> 집단, 그룹별로 데이터를 집계
df2 = df.groupby("언제").sum()
# print(df2)

#언제 부분이 df2의 인덱스로 지정되있는 상태, 12달 x 5년치 = 60개의 행이 x축 값으로 들어감
plt.plot(range(df2.index.size),df2["prn"],color="#EF9A9A")
plt.plot(range(df2.index.size),df2["frn"],color="blue")
plt.plot(range(df2.index.size),df2["pan"],color="#90CAF9")
plt.plot(range(df2.index.size),df2["fan"],color="black")

#연월을 표시하려면 x의 해당 축에 해당 값을 넣어주면 ㅇㅋ
plt.xticks(range(df2.index.size), df2.index)

plt.legend(["유임승차","무임승차","유임하차","무임하차"])
plt.title("월별 지하철 유/무임 승차 정보")
plt.show()