# UP/DOWN 게임 (함수)
# 유저의 이름을 입력받고 환영하는 인사를 출력
# (컴퓨터) 1~100 사이의 랜덤한 숫자를 하나 뽑아서
#유저에게 정답을 입력하게 했을 때
#저 범위의 숫자가 아니면 다시 입력하도록
#입력한 숫자가 정답보다 작으면 UP, 크면 DOWN 출력
#정답을 맞췄을 때는 몇 번 만에 맞췄는지 출력 + 종료
#정답 기회는 총 10번

import random

def UPDOWN():
    a = input("이름 입력 : ")
    print("환영합니다")

    rand_num = random.randint(1,100)

    b = getNum() # Call the function to get the user input
    tries = 0
    while(tries<11):
        decider = decideNum(b,rand_num)
        tries+=1
        if decider==1:
            print("정답입니다!")
            print(tries, "번 시도만에 맞추셨습니다")
            break # Exit the loop after winning
        else:
            if b<rand_num:
                print("UP")
            elif b>rand_num:
                print("DOWN")
            b = getNum() # Get new input for the next try

def getNum():
    b = input("숫자를 입력해주세요 1~100")
    if b<1 or b>100:
        print("입력 범위를 벗어난 숫자입니다.")
        getNum()
    return int(b)
def decideNum(user_input,computer_num):
    if user_input == computer_num:
        return 1
    else:
        return 0

########################

UPDOWN()