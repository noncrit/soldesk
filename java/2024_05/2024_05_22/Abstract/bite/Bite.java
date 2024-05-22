package com.kim.may22_5.bite;

//클래스 : 멤버 변수, 메소드 등등

//추상 메소드 : 멤버 변수, 메소드, 추상 메소드 // 단점 : 객체 생성 불가능!!!

//인터페이스 : 추상 메소드, 멤버 상수 // 객체 생성 불가능
// implements 로 선언함

public interface Bite {
	
	//private int a;  //변수 선언 불가
	public static final int B =3;	//상수 선언 가능
	
	//일반 메소드 선언 불가
	//System.out.println();
	
	//추상 메소드 선언  가능
	public abstract void bite();
}
