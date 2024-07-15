import random

i = random.randint(1,10)

#로또 번호 뽑기 (1~45 중 정수 6개) = > 중복 없이 => 출력

lotto = {}

while(lotto.count<=6):
    lotto.append(random.radint(1,45))
print(lotto)


##강사님 코드
num_list = []
count = 0

while count < 6:
    ran_num = random.randint(1,45)
    if ran_num not in num_list: # 뽑은 숫자가 list에 안들어있다면
        num_list.append(ran_num)
        count +=1

for n in num_list:
    print(n, end=' ')

##강사님 코드