//Java의 GUI 구현한 간단한 예시
//대표적인 GUI 라이브러리 : AWT, Swing, JavaFX
//AWT : 자바 초창기에 출시된 라이브러리, 운영체제에 따라 모양들이 다름, 종류도 상당히 제한적이었음
//Swing : AWT 다음으로 등장한 라이브러리
//	윈도우 프로그램은 자바로 안만든다... 오히려 더 최적화된 c,c++등의 라인업이 더 빠르기 때문
//	윈도우 프로그램들 잘 안만든다...
//	요 친구도 그닥...
//	안드로이드 app 구조 이해하는데 도움은 된다.
//JavaFX : 
//		: swing의 느린 처리속도를 개선해서 등장
//		: 따로 외관을 꾸미는것도 가능
//		: 여전히 웹이나 앱 쪽에서 쓰긴함

package com.kim.may23_3.main;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kim.may23_3.avengers.Hawkeye;

public class OMain2 {
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("지구");
		JButton jb = new JButton("KIM");
		jf.add(jb);
		
		//호크아이 ->actionPerfomred()가 반드시 필요
		
		Hawkeye h = new Hawkeye();
		
		// x가 전담 영웅으로 호크아이를 골랐고, 도움을 요청할것임
		
		jb.addActionListener(h);
		
		// 크기, 눈에 보이게
		jf.setSize(500, 500);
		jf.setVisible(true);
	}
}
