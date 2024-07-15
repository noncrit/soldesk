
#for(int i =0 ; ...) : X 이렇게는 못씀
#for (int il : i ) : 0 (Java 의 foreach)

l = [123,45,6,78,910]
for ll in l:    #for(int) (int ll : l) 과 같은 문장
    print(ll) #123 \n 45 \n 6 \n 6 ... 출력


 # ㅋ을 10번 출력
zz = ["ㅋ"]
counter = 0
for z in zz:
    if counter<10:
        counter+=1
        print(z)

for z in range(10):
    print("ㅋ")

#1 ~ 20 까지의 정수 중 홀수만 출력

counter2 = {"cc":0}
for i in counter2:
    if (counter2 % 2) != 0 and (counter2.cc<21):
        print(counter2.cc)
        counter2.cc+1

for tt in range(1, 21 ,2): #(int tt =1; zz < 21; tt +=2)
    print(tt)
print()


#################################
#while 문 ( O 있음)
while True:
    y = int(input("y : "))
    if y%2 == 0:
        print("짝수")
        break
#근데 do while은 없다

#enumerate : 반복문을 사용 할 때 몇 번 반복되었는지 확인이 필요할 때
#(인덱스, 값 ) 형태 tuple을 리턴해줌
ll  = ["컴퓨터", "모니터", "키보드", "마우스"]

for i, v in enumerate(ll):
    print(i + 1, v)
print("---------")
#1 컴퓨터
#2 모니터
#3 키보드
#4 마우스

score = [10, 54, 56, 70, 70, 87,65 ,99, 91, 88]
# 1등 학생은 몇번째에? / 점수는 몇번인지 출력
tmp = 0
tmpc =0
for c, p1 in enumerate(score):
    tmp = p1
    if tmp<p1:
        tmp = p1
        tmpc= c

print("1등 학생 : ",c,"번째")
print("점수 : ", tmp)
print(score.index(tmp)) #tmp의 값과 같은 인덱스 번호 출력 : 7

