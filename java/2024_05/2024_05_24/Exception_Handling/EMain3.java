package com.kim.may_24_1.main;

import com.kim.may_24_1.Per_gram.Per_gram;

//Java
//	예외처리가 강제 => 무조건 해야함
//Python
//	예외처리를 자율에 맡겨놨음 =>안해도 됨

public class EMain3 {
	
	public static void main(String[] args) throws Exception {
		// 가격/무게(g)을 입력 받아서 (정수)
		// g당 가격이 얼마인지 값을 구해 메인에 출력
		// class 만들어서
		
		//***finally는 return 보다 실행 우선순위가 높음***
		//이 방식의 try-catch-fianlly => 여기에서 아예 끝장을 보자는 방식 =>몬가 쓰는 방식이 잘못됨
		
		//throw -> try-catch보다 많이 쓸거고, 훨씬 자연스러움
		
		Per_gram p = new Per_gram();
		
		p.start();
	}
}
