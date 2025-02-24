package com.kim.may22_3.dog;

//접근제어자(Access Modifier)
//멤버 변수 or 클래스에서 사용
//이클립스 외부에서 멤버 변수나 클래스에 접근하지 못하도록 제한하는 역할

public class Dog {

	public int a;		//접근 제한이 전혀 없음
	protected int b;	//같은 패키지 안쪽 or 다른 패키지라면 하위 클래스에서 접근 가능 + 정확히는 하위 클래스의 객체를 통해 접근 가능
	/*default*/ int c;	//같은 패키지 내에서 접근 가능	//접근 제어자를 따로 명시하지 않은 경우
	private int d;		//같은 클래스 내부에서만 접근 가능 //해당 클래스 외부에서는 접근 불가능	
}
