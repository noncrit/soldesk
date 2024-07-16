from random import randint


#패캐지에 존재하는 클래스를 불러오려함

# import animal.pet   #import 패키지명.모듈명 => 써먹을 수 있게 불러온 것
                    #pet.py 모듈의 코드가 여기로 넘어온 셈
# d = animal.pet.Puppy("댕댕이", 11) #패키지명.모듈명.클래스명(...)
# d.printPuppy()
###############################


# import animal.pet as ap # import 패키지명.모듈명 as
# d = ap.Puppy("멈뭄",13)
# d.printPuppy()

from animal.pet import Puppy    #import 패지키명.모듈명 클래스명

#####################

from animal.pet import Puppy as pp  
d =pp("댕댕e",6)
d.printPuppy()

#####################################

"""
Java
전 세계적으로 많이 사용됨
자신의 작업물을 오픈 소스로 공개하는 문화가 있음 => maven
작업물이 워낙 많아서 클래스의 이름이 중복되는 일이 잦음
클래스명이 중복일 때, 구분하는 수단 : Package
패키지명까지 중복되는 경우가 있을 수 있음 => 패키지명이 전세계적으로 유일하도록
com(kr).회사명.프로그램명.주제 형식으로 사용하는 관습이 있음

패키지명.클래스 로 사용헸음 => 어떤 조건을 충족하면 굳이 패키지명을 쓰지 않아도 상관 없었음
(같은 패키지 내부에 있거나, 해당 클래스가 java.lang 소속이거나, imoort를 미리 해뒀거나)

java.util.Random r = new java.tuil.Ranom()

풀 패키지로 끌고오면 import를 쓸 필요가 없는 경우도 있음



Python
오픈 소스 작업물 공유 => pip
클래스명이 중복일 때, 구분하는 수단 : Package
패키지명 이름 지을 때 규칙이 없음 => 중복나면? ㅁ?ㄹ
클래스를 꼭 패키지에 넣는것도 아님
다른 파일을 불러온다면 import가 필수!!!

"""
##################################

import animal.pet as ap

class Puppy:
    def punch(self):
        print("댕댕펀치")

#animal.pet의 puppy 가져온 d
d = ap.Puppy("댕댕",1)

#클래스명이 중복되는 경우 => 제일 가까운 클래스를 기준으로 삼음 -> 바로 위의 클래스가 가져와짐
#위에 있는 
d2 = Puppy()
d2.punch()
