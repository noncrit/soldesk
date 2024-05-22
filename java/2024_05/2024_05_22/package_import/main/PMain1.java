package com.kim.may222.main;//폴더 관리 개념

import com.kim.may222.product.*; //import로 땡겨오거나 아니면 패키지 경로로 직접 객체를 끌어와야함

// 매직스테이션, 800000원, i5-1234, 8GB, 500GB 인 컴퓨터

// 멀티익스프레스, 500000 인 스캐너

public class PMain1 {
	
	public static void main(String[] args) {
		
		// 패키지 경로를 명시해 직접 객체를 끌어온 예시
		com.kim.may222.product.Computer c1 = new Computer("매직스테이션",800000,"컴퓨터","i5-1234",8,500);
		
		//Computer c1=new Computer("매직스테이션",800000,"컴퓨터","i5-1234",8,500);
		c1.print_Product();
		
		Scanner s1 = new Scanner("멀티익스프레스",500000,"스캐너");
		s1.print_Product();
	}
	

}
