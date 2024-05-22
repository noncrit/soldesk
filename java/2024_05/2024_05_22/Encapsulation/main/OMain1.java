package com.kim.may22_4.main;

import javax.swing.JFrame;

import com.kim.may22_4.coffee.Coffee;
import com.kim.may22_4.person.Person;

//캡슐화(Encapsulation)
//멤버변수에 접근할 수 있는 경로를 제한하기!
//외부에 노출할 필요가 없는 정보를 숨기는 기능(abstraction)

public class OMain1 {
	
	public static void main(String[] args) {
		/*
		//타이틀이 ㅋㅋㅋ 인 JFrame
		JFrame f = new JFrame("ㅋㅋㅋ");
		//사이즈를 300, 500 수정
		f.setSize(300,500);
		//타이틀을 ㅎㅎㅎ로 수정
		f.setTitle("ㅎㅎㅎ");
		//보이게 하고 싶음
		f.setVisible(true);
		*/
		//커피에 대한 객체
		//아메리카노, 3000원
		//출력까지
		
		Coffee c = new Coffee("아메리카노",3000);
		c.printInfo();
		System.out.println("-=-=-=-=-=-=-=-=-");
		
		
		//왜 get set을 써야할까? ->set으로 값 집어넣기, get으로 받아오기(return) 멤버 변수의 접근 루트 제어
		//private 으로 선언한 뒤 get, set으로만 데이터 주고 받는 방법으로 변수에 대한 직접 접근을 차단
		//setXXX : 외부의 접근이 제한된 XXX를 수정 가능
		//나이에는 음수가 없으니 set 부분에서 나이값 판정 부분을 추가하면 해결
		Coffee c1 = new Coffee();
		c1.setName("아메리카노");
		c1.setPrice(3000);
		
		//사람
		//이름 나이 몸무게 출력
		Person p = new Person();
		p.setName("김");
		p.setAge(31);
		
		System.out.println(p.getName());
		p.print_info();
		System.out.println("-=-=-=-=-=-=-=-");
		
	}

}
