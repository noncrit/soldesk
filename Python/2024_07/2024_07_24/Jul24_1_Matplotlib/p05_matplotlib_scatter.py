import matplotlib.pyplot as plt
import numpy as np

#scatter 그래프 (분포도)

#동일한 순서로 난수를 발생시키기 위해 'seed'

np.random.seed(0)

n = 50
# 0~1 사이 랜덤한 수를 50개 생성
x = np.random.rand(n)
y = np.random.rand(n)

##########################
#<기본>
#x,y를 순서대로 scatter() 함수에 입력을 하면
#해당 위치에 마커가 표시됨

# plt.scatter(x,y)
# plt.show()

###########################
# #마커 크기, 색상 지정
# area = (30 * np.random.rand(n)) ** 2
#
# #RGB, HexCode 에 대한 색상 지정을 난수로
# #0~1 까지의 숫자를 임의의 색으로 지정하게 됨
# colors = np.random.rand(n)
#
# #s(scale), c(color)
# plt.scatter(x,y,s=area, c=colors)
# plt.show()

############################
# 투명도(alpha) : 0~1, 컬러맵(cmap) : 일종의 테마, 컬러맵에 해당하는 문자열 지정했음
# area = (30 * np.random.rand(n)) ** 2
# colors = np.random.rand(n)
#
# import matplotlib.cm
#
# print(matplotlib.cm._colormaps)
#
# plt.scatter(x,y,s=area, c=colors, alpha=0.5, cmap="Spectral")
# plt.colorbar()
# plt.show()

#############################

#다차원 랜덤 배열 생성
np.random.seed(0)
#8행 100열의 랜덤 배열
arr = np.random.standard_normal((8,100))
    
# 2x2 사이즈 중에서 1번째
plt.subplot(2,2,1)
plt.scatter(arr[0],arr[1],c=arr[1])
plt.spring()
plt.title("Spring")

plt.subplot(2,2,2)
plt.scatter(arr[0],arr[3],c=arr[3])
plt.summer()
plt.title("Summer")

plt.subplot(2,2,3)
plt.scatter(arr[4],arr[5],c=arr[5])
plt.autumn()
plt.title("Autumn")

plt.subplot(2,2,4)
plt.scatter(arr[6],arr[7],c=arr[7])
plt.winter()
plt.title("Winter")

#자동으로 여백에 관련되 피라미터를 조정
plt.tight_layout()

plt.show()





