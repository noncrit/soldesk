package com.kim.may_24_2.main;

//Wrapper Class : 자료형 중 기본형들의 객체형 형태 우리말로는 포장 객체라 부름
//	Integer (int의 객체형), Double, Long, Void, Boolean ...
//	기본 자료형을 객체로 다루기 위해서 사용하는 Class
//	Java의 기본형 => 포장 객체로 값을 가지고 있는 객체 생성이 가능함
//	기본형이 가지고 있는 값을 내부에 두고 그 위를 객체로 포장하는 방식

//	1. 객체나 클래스가 제공해주는 메소드를 사용 할 때 
//	2. 클래스가 제공하는 상수에 대한 값을 사용 할 때(최대값, 최소값)
//	3. 숫자나 문자로 형변환을 할 때(*주로 쓰게 될 이유*)


public class WMain1 {

	public static void main(String[] args) {
		
		int a = 10;
		String a1 = "100";
//		double bb = (double) a;
//		double bbb = (double) a1;
		
		//Integer 객체 생성 = > 거기에 String 정수값을 넣어서 int 형으로 return
		Integer b = new Integer(a1);
		
		System.out.println(b.getClass());
		//정수값으로 리턴
		
		b.intValue();
		System.out.println(b);
		System.out.println(b.TYPE);
	
		//기본형 => 객체형(Boxing)
		//예시
		double c=12.345;
		Double d = new Double(c);

		
		//객체형 => 기본형 (Unboxing)
		//예시
		Boolean e = new Boolean(true);
		boolean f = e.booleanValue();
		//객체형 -> 기본형
		//근데 자바에서는 이걸 자동으로 해줌 (Auto Unboxing)
		Integer g = 10;
		
		//기본형 => 객체형 자동 버전 (Auto Boxing)
		int h = g;
		
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		int min = Integer.MIN_VALUE;
		System.out.println(min);
		
		//Int 의 자료형을 String 으로 바꿔보기
		String num1 = Integer.toString(321);
		
		//String -> 기본형(다이렉트로는 힘들고, 객체형을 한 번 거쳐야함)
		// String -> 객체형 -> 기본형
		String k = "345.67";
		Double k2 = Double.parseDouble(k);
		double k3 = k2.doubleValue();	//생략 가능 요거 빼면 그냥 Auto unboxing 이랑 같음
		
	}
	
}
