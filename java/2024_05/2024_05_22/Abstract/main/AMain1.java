package com.kim.may22_5.main;

import com.kim.may22_5.animal.Bird;
import com.kim.may22_5.animal.*;

public class AMain1 {

		public static void main(String[] args) {
			//추상화(Abstraction) : 공통의 속성이나 기능을 묶어서 이름을 붙이는 것
			//c.f : 프로그램 사용 영역에서 사용자가 알 필요 없는 정보를 적절하게 숨기는 것도 abstraction
			
			Bird b = new Bird("새",93,3);
			b.print_info();
			b.roar();
			b.bite();
		}
}
