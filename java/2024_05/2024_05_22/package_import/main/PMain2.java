package com.kim.may222.main;

//import로 가져오는 경우 PMain.2 java에서 경로를 명시하지 않은 Scanner는 모두 해당 패키지의 Scanner로 간주하겠다는 선언
import java.util.Scanner;

// 패키지 : 나중에 배포된 파일 받고, 배포하고 할 때 클래스 이름이 중복되는 경우가 있음. 이럴 때 구별을 위한 namespace 구현 방식
// 앞으로 모든 클래스는 패키지 따로 만들어서 넣어주자

//what if? 패키지명이 중복되면??? => 방법이 없음
//세계적으로 패키지 이름짓는 방식을 관습 비슷하게 해놓은게 있음
//인터넷 주소의 역순(소문자)
//com.회사명.프로그램명.카테고리(소분류)
//kr.co.회사명.프로그램명.카테고리 등등

//객체
//패키지경로.클래스명 변수명 = new 패키지경로.생성자();

//객체 만들 때 패키지명 생략 가능한 경우 => java.lang 소속이면 생략가능(기본으로 import 되어있음) String, syso 등등

//What if =>같은 패키지에 소속되어 있는 경우? -> 같은 공간이라 import 필요 없음
//다른 패키지인 경우 경로를 명시하거나, import를 꼭 해줘야 함

//ctrl + shift + O =>import 부분 자동 정리

public class PMain2 {
	
	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		
		com.kim.may222.product.Scanner k2 = new com.kim.may222.product.Scanner();
		
		//What if =>같은 패키지에 소속되어 있는 경우? -> 같은 공간이라 import 필요 없음
		
		//경로 명시
		com.kim.may222.main.Tmp b = new com.kim.may222.main.Tmp();
		
		//그냥 자동완성
		Tmp c = new Tmp();
		
		//다른 패키지인 경우
		
		//1. 경로 명시
		com.kim.may222.product.Computer ck = new com.kim.may222.product.Computer();
		
		//2. 아니면 import
		
	}
	
}
