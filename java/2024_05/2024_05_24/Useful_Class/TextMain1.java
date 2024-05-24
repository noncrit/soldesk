package com.kim.may_24_2.main;

import java.lang.String;
import java.util.StringTokenizer;

public class TextMain1 {
	public static void main(String[] args) {
		
		String s1 = "으아아아ㅏ아";	//정식버전? 아님 약식 표현형태임
		
		String s2 = new String("곧 있으면 점심! 너무 신나요");	//정식 버전
		
		//외우지 말고 찾아보기
		
		//s2에서 2번째에 있는 글자만 출력
		String s3 = s2.substring(2,3);
		System.out.println(s3);
		
		char s4 = s2.charAt(2);
		System.out.println(s4);
		
		//s2는 총 몇 글자인지 출력
		System.out.printf("총 %d글자\n",s2.length());
		
		//s2는 곧 이라는 단어로 시작하는지
		System.out.printf("곧 으로 시작하나 : %b\n",	s2.startsWith("곧"));
		
		//s2에 너무 라는 단어가 있는지
		System.out.println("-=-=-=-=-=-");
		System.out.printf("너무 라는 글자가 있나? : %b\n", s2.matches("[너무]") ); // 얘는 정규표현식 써야함
		System.out.printf("너무 라는 글자가 있나? : %b\n", s2.contains("너무") );
		
		//s2에서 점심을 회식으로 바꿔서 출력
		s3 =s2.replace("점심", "회식");
		System.out.println(s3);
		
		//s2에서 2~5에 있는 글자만 출력
		s3 = s2.substring(2, 5);
		System.out.println(s3);
		
		//String 객체를 생성하는데 형식을 잡아서 생성하고 싶다.
		String s5 = String.format("무게 : %.2fkg", 123.4567);
		System.out.println(s5);
		
		//s2에 글자를 추가
		s2 = s2 + "올해에는 모두 ~~~";
		System.out.println(s2);
		s2+="모두 부자되세요";
		System.out.println(s2);
		
		//String 대량으로 추가
		StringBuffer sb = new StringBuffer(s2);
		sb.append("일은 적게 하되 돈은 많이 벌게 해주세요!");
		sb.append("ㅋㅋㅋㅋㅋㅋㅋ");
		sb.append("근데 일이 너무 많아요...");
		System.out.println(sb.getClass());
		
		String s6 = sb.toString();
		System.out.println(s6);
		
		//String 분리
		String s7 = "김비버,박비버,최비버,저스틴비버";
		
		System.out.println();
		//1. split
		String[] s7Ar = s7.split(",");
		System.out.println(s7Ar[3]);
		
		//2.StringTokenizer - 편한데?
		StringTokenizer st = new StringTokenizer(s7, ",");
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		//속도면에서는 토크나이저 쓰는게 낫고, 데이터에 변수가 많으면 split
		
	}
}
