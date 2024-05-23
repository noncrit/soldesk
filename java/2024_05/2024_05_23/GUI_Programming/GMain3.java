package com.kim.may_23_4.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.kim.may_23_4.frame.TempFrame;

//화씨 온도 -> 섭씨 온도 변환기
public class GMain3 {
	
	public static void main(String[] args) {
		
		JFrame jf = new JFrame();	//메인 프레임
		JPanel jp = new JPanel();	// 보조 프레임
		jf.add(jp);
		
		JLabel label1 = new JLabel("화씨온도 : ");
		JTextField field1= new JTextField(15);
		
		JLabel label2 = new JLabel("섭씨온도 : ");
		JTextField field2= new JTextField(15);
		
		JButton button = new JButton("변환");	//변환 버튼 생성
		
		//순서 중요 위->아래, 왼쪽->오른쪽 순
		jp.add(label1);
		jp.add(field1);
		jp.add(label2);
		jp.add(field2);
		jp.add(button);
		
		TempFrame tFrame = new TempFrame(field1,field2);
		button.addActionListener(tFrame);
		
		jf.setSize(300,150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("온도 변환기");
		jf.setVisible(true);
		
	}

}
