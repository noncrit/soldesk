package com.kim.may22_5.main;

import com.kim.may22_5.avengers.Avengers;
import com.kim.may22_5.avengers.Ironman;

public class AMain2 {
	//	어벤져스 클래스
	//	이름, 나이, 속성
	//	공격하기 기능
	public static void main(String[] args) {
		
		//Avengers로부터 상속받은 클래스명은 뭔지 모르는 내부에 만들어놓은 클래스
		//익명 내부 클래스(Anonymous inner class)
		//단 한번만 사용 될 수 있음, 오직 하나의 객체만을 사용할 수 있는 일회용 클래스
		Avengers a = new Avengers("파커",19) {
			//여기 중괄호 안쪽 부분이 익명 내부 클래스
			@Override
			public void attack() {
				System.out.println("거미줄 발사!");		
			}
		};
		a.print_Avenger();
		a.attack();
		System.out.println("-=-=-=-=-=-");
		
		//아이언맨은 어벤져스
		//속성으로 재산
		//공격은 빔
		//흡연
		//운전
		
		Ironman i = new Ironman();
		i.setAge(35);
		i.setName("스타크");
		i.setProperty(100000000);
		
		i.print_Avenger();
		i.attack();
		i.smoke();
		i.drive();
		
	}
}
