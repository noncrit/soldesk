#상속
#파이썬에는 추상 클래스/메소드 모두 존재하지 않음

#Java : 생성자 상속 불가능
#Python : 생성자 상속 가능 -> 멤버 변수를 생성자에서 결정
#단, 생성자를 상속해주지 않으면 당연히 멤버 변수 역시 상속이 불가능함

class Avengers:
    def __init__(self,name, age):
        print("Avengers Assemble")
        self.name = name
        self.age = age
        
    def attack(self):
        print("공~~~~격")
    
    def printInfo(self):
        print(self.name)
        print(self.age)
        
#---------------------------------
#이게 상속을 했다는 표현

class Ironman(Avengers):
    
    #overloading   : 메소드명은 같지만, 파라미터는 다르게 
    #overriding    : 상속을 받은 메소드의 기능을 바꾸기
    #아래쪽 생성자 -> 오버라이딩
    def __init__(self, name, age, suitType):
        Avengers.__init__(self, name, age)
        self.suitType = suitType
    
    #super() -> 한 단계 상위 클래스
    def attack(self):
        #Avengers.attack(self)
        super().attack()
        print("탈모빔 발4~~~")
    
    def printInfo(self):
        Avengers.printInfo(self)
        print(self.suitType)
        
#--------------------------------------
#헐크 : 어벤져스 소속 / 이름, 나이, 바지 사이즈/ 공격 함 / 정보 출력

class Hulk(Avengers):
    
    def __init__(self, name, age, pantsSize):
        Avengers.__init__(self, name, age)
        self.pantsSize = pantsSize
    
    def attack(self):
        Avengers.attack(self)
        print("부 순 다")
        
    def printInfo(self):
        Avengers.printInfo(self)
        print(self.pantsSize)
        
#--------------------------------------
if __name__ == "__main__":
    i = Ironman("토니 스타크", 1, "mk-50")
    i.attack()    
    i.printInfo()
    print("-----------")
    
    h = Hulk("브루스 배너", 2, 194)
    h.attack()
    h.printInfo()