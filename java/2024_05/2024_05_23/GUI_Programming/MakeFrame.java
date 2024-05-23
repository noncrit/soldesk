package com.kim.may_23_4.frame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//JFrame : Swing 에서 윈도우(창)을 나타내는 클래스
//	JPanel, JButton, JtextField

//Layout : 
//flowLayout : 왼쪽에서 오른쪽까지 일렬 배치
//BOrderlayout: 상하에서 프레임을 보여주겠다
//Greed layout : 격자 형태 정렬지원
//setLocation, setBounds - 위치 임의로 지정

public class MakeFrame extends JFrame{
	//버튼 10개에 각각 번호를 붙여서 (1~10 가운데 정렬)
	
	JPanel pl;
	
	public MakeFrame() {
		
		setSize(500,500);
		setTitle("GUI연습");
		pl = new JPanel();
		pl.setLayout(new FlowLayout());
		
		for (int i = 0; i <= 10; i++) {
			pl.add(new JButton("버튼"+i)); // pl에 버튼을 넣은 상태
			
		}
		add(pl);
		setVisible(true);
	}



}


