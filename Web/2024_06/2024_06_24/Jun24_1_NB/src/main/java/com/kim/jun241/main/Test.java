package com.kim.jun241.main;

import java.util.Random;

public class Test {
	
	//001 ~ 011 불가
	
	//988 ~ 999까지 불가
	
	//012~987 이 정답범위
	
	public static String pickAns() {
		
		int a = new Random().nextInt(976)+12; // 12 ~987
		String ans = String.format("%03d", a);
		
		if(ans.charAt(0) == ans.charAt(1)
			||ans.charAt(0) == ans.charAt(2)
			||ans.charAt(1) == ans.charAt(2)) {
			//equals는 String에만 사용가능
			//charAt은 char가 반환됨, 해당 인덱스 위치 문자 하나 반환
			//char 자료형은 아스키 코드값으로 사용하기 때문에 == 로 비교함
			
			return pickAns();
		}
		return ans;
		
		
	}
	
}
