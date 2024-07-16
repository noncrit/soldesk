
#OOP : 파이썬에서의 객체 지향 구현
#캡슐화, 객체 단위로 기능 구분
#JAVA 에서는 하나의 파일이 하나의 클래스였음 => 코드 재사용이 편리했음
#JAVA는 Python에 비해 완전한 객체지향 언어
#파일 하나가 곧 클래스이고, 클래스명은 항상 대문자!

#Python에서는? - Hybrid 느낌의 OOP
#Python File을 이용해 구현(Module) => 모듈 파일 하나에 클래스가 여러 개가 존재 할 수 있음
#클래스명은 무조건 대문자로 고정하라는 컨벤션은 없지만, 그냥 익숙해졌으니까 통일시켜서 대문자로 써주자
#접근 제어자(public, private ...) 없음 -> 캡슐화 없음
#static 멤버변수 선언 불가 / 대신 static method는 선언 가능
#----------------------------------------------

class Shop():
    def showInfo(self): #메소드 - 클래스 내부에서 사용
        print(self.name, self.floor)
        
        
class Dog:
    name = "asdf"   #의미 없음, 단순한 기본값 처리용, name에 아무것도 안들어오면 이 텍스트가 기본값
                    #우리가 사용하던 멤버 변수는 생성자에서 만들어줄 것
    
    
    def bark(self): # 클래스 내부 메소드에 self는 필수적임 - Why? 아래에 설명
        print("wallllllllrrrrrr")
        
    def printInfo(self):
        #Java : this.name => this. 은 생략이 가능했음(해당 객체 내부에 선언했으니까)
        #Python : this의 기능을 self가 대신함, 대신 self는 생략이 불가능함
        print(self.name, self.age)
    
    #Python은 오버로딩 불가능!    
    def printInfo2(self, c):
        
        for _ in range(c):  #변수 선언 생략으로 단순 반복문 구현
            print(self.name, self.age)
     
    #Annotation을 통해 static method 선언, 객체를 생성하지 않아도 사용 가능한 메소드
    #파이썬에서는 @를 decorator 라고 부름   
    @staticmethod   
    def staticMethodTet():
        print("개개개개ㅐㄱ")
####
Dog.staticMethodTet()

s = Shop()
s.name="카페"
s.floor = 1
s.showInfo()
print("------------------")

d = Dog()
d.name="댕댕이"
#41 라인에서 d.name으로 넣은 값이 Dog에 선언한 name에 담기지 않음
d.age = 1982
print(d, type(d))
d.printInfo()

d.bark()    #첫 번째 메소드 호출 방법
Dog.bark(d) #두 번째 메소드 호출 방법
print("------------------")
d.printInfo2(3)