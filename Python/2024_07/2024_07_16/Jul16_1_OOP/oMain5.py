class Avengers:
    def __init__(self, realName):
        self.realName = realName
        
    def attack(self):
        print("무찐 공격!")
    
    def printInfo(self):
        print(self.realName)

##########################################

class Human:
    def __init__(self, age):
        self.age = age
    
    def eat(self):
        print("쩝쩝박사")
    
    def attack(self):
        print("데미지 1짜리 발차기")
    
    def printInfo(self):
        print(self.age)

##########################################

#Java : 다중 상속 불가능 (대신 그 기능을 interface에 담아서 간접적으로 사용하는 식으로 다중 상속 구현)
#Python : 클래스의 다중 상속 가능
#상속 받는게 중복되면(생성자, attack() ) 먼저 상속받은 대상을 불러온다
#Human의 method를 불러오고 싶다면? -> 직접 입력해야함 
#아래 코드는 Avengers를 상속받게 됨

class Ironman(Avengers, Human):
    def __init__(self, realName, age):
        Avengers.__init__(self, realName)
        Human.__init__(self, age)
        
    def attack(self):
        Avengers.attack(self)
        Human.attack(self)
        
    def printInfo(self):
        Avengers.printInfo(self)
        Human.printInfo(self)

#########################################

if __name__ =="__main__":
    i = Ironman("토니 스타크", 40)
    i.attack()
    i.eat()
    i.printInfo()
