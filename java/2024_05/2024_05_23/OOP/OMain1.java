package com.kim.may23_3.main;
import com.kim.may23_3.planet.Planet;
import com.kim.may23_3.avengers.Ironman;
import com.kim.may23_3.human.Human;

//게임을 개발 중
//행성 (이름, 행성의 크기, 보이는지 안보이는지)
//사람 (이름)
//이름이 '지구'인 생성 하나 생성
//이름이 ???인 사람 생성
//이 행성에 사람이 입주했다를 출력하기

public class OMain1 {
	
	public static void main(String[] args) {
		
		Planet earth = new Planet("지구",111,false);
		
		Human a = new Human("???");
		
		Ironman i = new Ironman();
		
		earth.getHuman(a);
		a.print();
		
		//interface는 부사수를 제어하는 용도로도 자주 쓰임
		//들어올 수 있는 입력이 제한적이라서!!
		
		//iron맨 객체 만들어서 attatck() 구현하기
		//사람이 아이언맨을 자신의 전담 영웅으로 고름
		//그리고 사람이 도와달라고 소리침 -> 그러면 아이언맨이 공격
		//행성 사이즈 1000으로 수정
		//행성 보이게 변경
		a.pick(i);
		
		a.need_help();
		
		a.print();
	}
}
