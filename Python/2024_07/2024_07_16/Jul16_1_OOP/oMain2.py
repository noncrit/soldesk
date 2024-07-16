from pickle import NONE


class Book:
    #init이 기본 생성자의 역할을 함
    #def __init__(self):
    #    print("기본 생성자")
        
    #생성자 : 객체가 메모리상에 만들어질 때 호출하는 메소드
    #Overloading이 안되니 => 생성자를 하나만 만들어서 써야하는 상황
    
    def __init__(self, title, price):
        print("오버로딩은 불가능~~")
        self.title = title  #보통은 이렇게 생성자에서 멤버 변수를 만들어서 결정함
        self.price = price
        
    def printInfo(self):
        print(self.title, self.price)
        
    #소멸자(destructor) : 객체가 메모리상에서 사라질 때 호출하는 메소드
    def __del__(self):
        print("책 객체 삭제")
#------------------------------
#사람에 대한 클래스 : 이름, 나이
#메소드 : 속성을 출력하는 기능, 생성자, 소멸자
#객체는 2개정도

class Human:
    
    def __init__(self, name, age):
       
        self.name = name
        self.age = age
        print("객체 생성")
        
    def printHuman(self):
        print(self.name, self.age)
        
    def __del__(self):
        print(self.name, " 객체 사라짐")




#------------------------------
#b1 = Book()
b2 = Book("요리책", 7000)
b2.printInfo()
print("-------------")
#------------------------------
#확인해보려 하는 것 : Garbage Coleector 객체 가르키는 변수가 없으면 힙에서 공간 회수
h1 = Human("kim", 29)
h2 = Human("lee", 33)
h3 = h1

h1.printHuman()
h2.printHuman()

print(id(h1))
print(id(h2))
print(id(h3))

#h1 = None #h3가 영향받음
#h3.printHuman() #h3는 살아있음

h3 = NONE
print("ansindpp")
