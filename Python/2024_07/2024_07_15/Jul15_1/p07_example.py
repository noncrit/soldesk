#숫자 야구, 3자리 숫자, 함수 사용
#각 자릿수의 숫자는 중복되어서는 안됨
# 012 ~ 987 중에 랜덤한 숫자가 정답
#정답을 받아올 때 각 자리의 값들은 리스트에 [0, 1, 2 ] 요런식으로
#자릿수와 값까지 같으면 S, 자릿수는 다른데 값이 같으면 B, 다 틀리면 OUT
#S가 3개 나오면 정답

from random import randint

def Computer():
    rand_set = set()
    while(len(rand_set)<3):
        rand_set.add(randint(0,9))
    print("랜덤 셋 생성 테스트:",list(rand_set))
    return list(rand_set)


def getUserInput():
    print("012 ~ 987 사이의 3 자리수를 입력해주세요")
    userInput=str(input())
    a =[]
    for i in userInput:
        a.append(i)
    num1 = int(a[2])
    num10 = int(a[1])
    num100 = int(a[0])

    if(isSame(num100,num10,num1)):
        print("중복된 숫자가 있습니다. 다시 입력해주세요")
        getUserInput()
    else:
        userInput = list([num100,num10,num1])
        return userInput

def isSame(a,b,c):
    judge = (a-b)*(b-c)*(c-a)
    if judge==0:
        return True
    else:
        return False   

def judge(userList, computerList):
    judge_dic = {"strike":0,"ball":0}
    index = 0
    while(index<3):
        if int(userList[index]) == computerList[index]:
            judge_dic["strike"]+=1
        elif int(userList[index]) in computerList:
            judge_dic["ball"]+=1
        index+=1
    print("현재 카운트 : \n%d Strike \n%d Ball" %(judge_dic["strike"],judge_dic["ball"]))
    return judge_dic

def gameResult(judge):
    if judge["strike"]>=3:
        print("승리하셨습니다!")
        print(judge)
        return False
    else:
        print("아쉽네요, 다시 시도!")
        return True
    
def gameStart():
    userInput = getUserInput()
    computerInput = Computer()
    result = judge(userInput,computerInput)
    while(gameResult(result)):
        userInput = getUserInput()
        result = judge(userInput,computerInput)
    

################
gameStart()