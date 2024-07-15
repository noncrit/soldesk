#Java의 (NULL) = Python None

#가위바위보 (함수) => 총 몇번 이겼는지 출력(질때까지 함)

import random
import time

def rps(a):
    #가위 바위 보 1 2 3
    #Win 1, -2 =>+2 3,0
    #lose -1, 2 =>+2 1,4
    computer = random.randint(1,3)
    decide = int(a)-computer
    if decide==0: #무승부
        return 0
    elif (decide+2)%3==0: #승리
        return 1
    elif (decide+2)%3==1: #패배
        return 2

def printResult(input):
    if int(input)==0:
        print("무승부!")
    elif int(input)==1:
        print("승리")
    elif int(input)==2:
        print("패배")

def wincounting(wincount):
    wincount+=1
    print("현재 승수:",wincount)
    

def main(wincount):
    print("가위 1, 바위 2, 보 3")
    user_input = int(input())
    result = rps(user_input)
    printResult(result)
    if result==2:
        print("총 승리수", wincount)
    elif result==0:
      main(wincount)
    elif result==1:
      wincount+=1
      main(wincount)
##############
wincount=0;
main(wincount)

print("=================")


#############강사님 코드
from random import randint
import time

handTable = [None, "가위","바위","보"]

def printRule():
    print("-----------")
    for i,h in enumerate(handTable):
        if (i!=0):
            print("[%d] %s" %(i,h)) # 1 가위 2 바위 3보
    print("-----------")

def comFire():
    return randint(1,3)

def userFire():
    print("-------")
    uh = int(input("뭐 낼까? : "))
    print("-------")
    if ( 1 <=uh <=3):
        return uh
    else:
        print("다시 입력해주세오")
        userFire()

def printHand(uhuh, chch):
    print("유저 : %s" % handTable[uhuh])
    print("컴퓨터 : %s" % handTable[chch])

def judge(uhuh, chch):
    t =uhuh-chch
    if t ==0:
        print("무승부")
        return 0
    elif t ==-1 or t==2:
        print("패배")
        return 999
    else:
        print("승리")
        return 1
    
def playGame():
    printRule()
    win = 0
    while(True):
        uHand = userFire()
        cHand = comFire()
        printHand(uHand,cHand)
        result = judge(uHand, cHand)
        if result == 999:
            print("-=-=-=-=-=-=-=-")
            print("패배!")

            if win >=10:
                time.sleep(1) #Java의 Thread.sleep
                print(".", end="")
                time.sleep(1) #Java의 Thread.sleep
                print(".", end="")
                time.sleep(1) #Java의 Thread.sleep
                print(".", end="")
                time.sleep(1) #Java의 Thread.sleep
                print("개고수...")
            elif win>=5:
                time.sleep(1) #Java의 Thread.sleep
                print(".", end="")
                time.sleep(1) #Java의 Thread.sleep
                print(".", end="")
                time.sleep(1) #Java의 Thread.sleep
                print(".", end="")
                time.sleep(1) #Java의 Thread.sleep
                print("좀 치네...")
            else:
                time.sleep(1) #Java의 Thread.sleep
                print(".", end="")
                time.sleep(1) #Java의 Thread.sleep
                print(".", end="")
                time.sleep(1) #Java의 Thread.sleep
                print(".", end="")
                time.sleep(1) #Java의 Thread.sleep
                print("삭제해라 애송이")


            break
        win += result
    print("%d 승으로 종료!" %win)

#######################
playGame()