package com.kim.may22_3.main;

import com.kim.may22_3.dog.Dog;

//접근제어자(Access Modifier)
//	멤버 변수 or 클래스에서 사용
//	이클립스 외부에서 멤버 변수나 클래스에 접근하지 못하도록 제한하는 역할
//	private < default < protected < public
public class AMain1 extends Dog {
	//AMain1(하위) Dog(상위)
	public static void main(String[] args) {
/*		
		Dog dog = new Dog();
		
		dog.a=1;
		dog.b=2;	//proctected => 이상한데?
		dog.c=3;
		dog.d=4;
*/		
		AMain1 amain = new AMain1();
		amain.a=1;	// public -> 접근 가능
		amain.b=2;	// protected -> AMain(하위), Dog(상위) 이므로 하위 클래스 객체 amain에서 Dog(상위) 참조 가능
		amain.c=3;	// 'c'는 default, Dog와 AMain은 서로 다른 패키지에 있으므로 접근 불가
		amain.d=4;	// 'd'는 private, 같은 클래스 내부에서만 접근 가능 /Dog와 AMain은 서로 다른 패키지에 있는 클래스들이므로 접근 불가
	}
}
