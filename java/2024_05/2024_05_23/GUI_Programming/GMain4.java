package com.kim.may_23_4.main;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kim.may_23_4.frame.BMIFrame;


//계산
//swing에서 받아온 값은 무조건 문자열 ->Double.parseDouble로 바꿔주기

//BMI : xx.xx 이고, 당신은 xxx입니다.
//printf처럼 => String.format(); 사용하기

public class GMain4 {
	
	public static void main(String[] args) {
		
		//제목이 BMI 검사인 JFrame
		JFrame jf = new JFrame("BMI 검사");
		Font font = new Font("맑은 고딕",Font.BOLD,30);
		
		//3행 2열짜리 GridLayout
		GridLayout gl = new GridLayout(3,2);
		
		//jf의 레이아웃 속성을 gl로 사용
		jf.setLayout(gl);
		
		JLabel label1 = new JLabel("키(cm) : ");
		JTextField field1= new JTextField();
		label1.setFont(font);
		jf.add(label1);
		jf.add(field1);
		
		JLabel label2= new JLabel("몸무게(kg) : ");
		JTextField field2= new JTextField();
		jf.add(label2);
		jf.add(field2);
		
		JLabel label3= new JLabel("결과 : ");
		//JTextField field3= new JTextField();
		jf.add(label3);
		
		JButton button = new JButton("확인");	//확인 버튼 생성
		jf.add(button);
		/*
		JPanel jp = new JPanel();
		jp.add(label1);
		jp.add(field1);
		
		jp.add(label2);
		jp.add(field2);
		
		jp.add(field3);
		
		jp.add(button);
		*/
		
		BMIFrame bf= new BMIFrame(field1, field2, label3);
		
		button.addActionListener(bf);
		
		jf.setSize(500,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("BMI");
		jf.setVisible(true);
		
	}
	
}
