package com.kim.may23_1.main;

import com.kim.may23_1.cat.Cat;

//원하는 객체 하나 생성
//이름, 나이, 별명
//출력

//객체가 유일한 객체가 되려면?
//프로그램 디자인 패턴 : 싱글톤 패턴(Singleton Pattern)
//	클래스가 최초 한번만 메모리를 할당하고(static 영역)
//	그 메모리에 객체를 만들어서 사용하는 디자인 패턴
//	고정된 메모리 영역을 얻으면서, 하나의 객체를 사용하기 때문에 메모리 낭비가 상대적으로 덜함
public class SMain1 {
	
	public static void main(String[] args) {
		
		Cat butter = new Cat("버터",7,"버터");
		butter.print_Cat();
		System.out.println(butter);
		
		Cat butter2 = new Cat("버터",7,"버터");
		butter2.print_Cat();
		System.out.println(butter2);
		
		//singleton style
		Cat single = Cat.getCat();
		single.print_Cat();
		System.out.println(single);
		
		Cat single2 = Cat.getCat();
		single2.print_Cat();
		System.out.println(single2);
	}
	
}
