#main 메소드 처럼 구현하기
#이 모듈을  실행했을 때, 동작해라가 가능한 조건
#프로그램의 시작점이라는 뜻
#추가적으로 이 모듈이 import를 당했을 때, 아무작업도 하지 않겠다
#실제 이 모듈에서 코드가 실행되었을 때만 동작함
#실질적인 main 역할 수행이 가능함

if __name__ == "__main__": #Java의 main 과 유사한 기능
    from animal.pet import Puppy
    d = Puppy('고양이', 2)
    d.printPuppy()
    
if __name__=="__main__":
    #여기에서 야생동물 클래스 하나 만들고, 객체 만들고, 출력까지
    class Tiger():
        
        def __init__(self, name, age):
            self.name = name
            self.age = age
        
        def printWilds(self):
            print(self.name, self.age)
#########################
w = Tiger("tiger",9)
w.printWilds()