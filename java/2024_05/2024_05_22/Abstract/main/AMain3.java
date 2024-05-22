package com.kim.may22_5.main;
//다형성(Polymorphism)
//Poly(많은) + Morph(모양)
//상위 타입의 변수에 하위 타입 객체를 담는 것이 가능 -> 같은 형태로 다른 기능을 하는게 가능
//Override 와 아주 밀접한 관련이 있음

import com.kim.may22_5.avengers.Avengers;
import com.kim.may22_5.avengers.Ironman;

public class AMain3 {

		public static void main(String[] args) {
			//아이언맨 담는 그릇 i에 아이언맨 만들어 넣음
			Ironman i = new Ironman("A",123,123123);
			
			//어벤져스 담는 그릇 a에 아이언맨 만들어 넣음
			Avengers a = new Ironman("B",456,456456);
			//다형성을 통해서 위와 같은 코드를 통해 코드의 유연성, 확장성 증가(?)
			//근데 이게 직관적이냐...?
			
			a.attack();
			//a는 avengers 타입인데, 실제로는 Ironman의 객체를 참조하고 있음
			//Ironman 클래스에서 오버라이딩 되어있는 attack() 메소드를 호출->정상적으로 빔 출력
		}
}
