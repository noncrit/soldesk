import matplotlib.pyplot as plt

# 한글 폰트 설정
plt.rcParams["axes.unicode_minus"] = False
plt.rcParams["font.family"] = "Malgun Gothic"

# 데이터 파일 경로
path = "C:/Users/sdedu/Desktop/Subway_data/Jul25_Subway_inout.csv"

# 데이터를 저장할 딕셔너리들
prnDict, frnDict, panDict, fanDict = {}, {}, {}, {}

# 데이터 파일 읽기 및 처리
with open(path, "r", encoding="UTF-8") as f:
    for line in f.readlines():
        line = line.replace("\n", "").split(",")
        
        when = line[0]
        prn = int(line[3])
        frn = int(line[4])
        pan = int(line[5])
        fan = int(line[6])
        
        if when in prnDict:
            prnDict[when] += prn
            frnDict[when] += frn
            panDict[when] += pan
            fanDict[when] += fan
        else:
            prnDict[when] = prn
            frnDict[when] = frn
            panDict[when] = pan
            fanDict[when] = fan

# 그래프를 그리기 위한 데이터 추출
whens = list(prnDict.keys())
prns = list(prnDict.values())
frns = list(frnDict.values())
pans = list(panDict.values())
fans = list(fanDict.values())

# 그래프 출력
plt.figure(figsize=(10, 6))

plt.plot(whens, prns, color="#EF9A9A", label="유임승차")
plt.plot(whens, frns, color="blue", label="무임승차")
plt.plot(whens, pans, color="#90CAF9", label="유임하차")
plt.plot(whens, fans, color="black", label="무임하차")

plt.legend()
plt.title("월별 지하철 유/무임 승차 정보")
plt.xlabel("날짜")
plt.ylabel("승차 인원 수")
plt.xticks(rotation=45)  # x 축 눈금 레이블 회전
plt.grid(True)  # 그리드 표시

plt.tight_layout()
plt.show()