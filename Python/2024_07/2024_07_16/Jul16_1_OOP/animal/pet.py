#애완동물에 대한 모듈
#강아지 : 이름, 나이
#출력 기능ㅎ까지

class Puppy():
    def __init__(self, name, age):
        self.name = name
        self.age = age
    def printPuppy(self):
        print(self.name, self.age)
        
#----------------
p = Puppy("dd",7)
p.printPuppy()

#여기서는 못불러왔음 - Tiger가 main 영역에 있기에, import가 불가능
if __name__ == "__main__":
    from animal.wild import Tiger
    a = Tiger("냥발", 2)
    a.printWilds()