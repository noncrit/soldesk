# 기상청 데이터 -> 각 시간별 기온(temp), 습도(reh)를 선 그래프로 표현(RSS는 3시간 단위 )

import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
# 음수 부호(마이너스 값) 안나오는 것 방지
plt.rcParams["axes.unicode_minus"] = False
fontFile = "C:/Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

# 방금 만든 csv 파일 활용
# 연월에 맞춰서 -> 유임승차, 무임승차, 유임하차, 무임하차
# 선 그래프로 나타내기

path = "C:/Users/sdedu/Desktop/Subway_data/Jul25_Subway_inout.csv"

with open(path, "r", encoding="UTF-8") as file:
    # dict for yearMM index
    year_mm = {}
    for line in file.readlines():
        a_data = line.replace("\n", "").split(",")
        
        if len(a_data) == 7:
            year = a_data[0]
            prn = int(a_data[3])
            frn = int(a_data[4])
            pan = int(a_data[5])
            fan = int(a_data[6])
            
            if year not in year_mm:
                year_mm[year] = {
                    "prn": 0,
                    "frn": 0,
                    "pan": 0,
                    "fan": 0
                }
            
            year_mm[year]["prn"] += prn
            year_mm[year]["frn"] += frn
            year_mm[year]["pan"] += pan
            year_mm[year]["fan"] += fan

# 그래프를 그리기 위한 데이터 추출
year_mm_list = list(year_mm.keys())
d1 = [year_mm[year]["prn"] for year in year_mm_list]
d2 = [year_mm[year]["frn"] for year in year_mm_list]
d3 = [year_mm[year]["pan"] for year in year_mm_list]
d4 = [year_mm[year]["fan"] for year in year_mm_list]

# 그래프 설정
plt.figure(figsize=(12, 8))  # 새로운 figure 생성

color = ["r", "b", "g", "y"]
x_legend = ["유임승차", "무임승차", "유임하차", "무임하차"]

# 각 선 그래프 그리기
plt.plot(year_mm_list, d1, color=color[0], linestyle="--", label=x_legend[0])
plt.plot(year_mm_list, d2, color=color[1], linestyle="--", label=x_legend[1])
plt.plot(year_mm_list, d3, color=color[2], linestyle="--", label=x_legend[2])
plt.plot(year_mm_list, d4, color=color[3], linestyle="--", label=x_legend[3])

# 축 범위 설정 (선택적)
plt.axis([None, None, 0, 1700000])

# 범례 추가
plt.legend()

# 그래프 출력
plt.show()
