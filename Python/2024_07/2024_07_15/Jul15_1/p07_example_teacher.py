from random import randint

def generate_numbers():
    numbers = []
    while len(numbers) < 3:
        num = randint(0,9)
        if num not in numbers:#중복처리
            numbers.append(num)
    return numbers

def get_userAns():
    userAns = input("답 입력 : ") #int 로 바꾸면 백의 자리 0 못가져옴
    if len(userAns)!=3:
        print("무조건 3자리 숫자만")
        return get_userAns()
    elif ( (userAns[0] == userAns[1]) or
            (userAns[0] == userAns[2]) or
            (userAns[1] == userAns[2])):
        print("중복된 숫자 입력입니다")
        return get_userAns()
    
    return userAns

def check(gn, ua):
    strike, ball = 0,0
    for i in range(0,3):
        for j in range(0,3):
            if gn[i] == int(ua[j]):
                if i == j:
                    strike +=1
                else:
                    ball += 1
    return strike, ball # 멍청아 리턴값 다중리턴 가능하자나...

def playGame():
    gn = generate_numbers()
    turn = 0
    s = 0
    b = 0
    print(gn)
    while( s!=3):
        userAns = get_userAns()
        s, b = check(gn, userAns)
        turn += 1
        if s == 3:
            print("정답! %d 번만에 맞췄습니다!" %turn)
            print("정답은", end=" ")
            for a in gn:
                print(a, end="")
            print("입니다!!!")
################
playGame()