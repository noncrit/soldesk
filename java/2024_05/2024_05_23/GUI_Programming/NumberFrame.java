package com.kim.may_23_4.frame;
// ?????
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;

//JFrame 생성(500,500)
//JPenel 안에 1~30까지의 숫자가 랜덤한 위치에 나오게 출력하려함

//숫자를 여러 개 뽑으려면 >>반복문
//숫자 담으려면 array[]
//글자가 표현되게하려면 =>jLabel

//set~~
//배경색 바꾸기 or 글자색 바꾸기 등등

public class NumberFrame extends JFrame{
	
	JPanel j1 = new JPanel();	//객체 선언을 먼저 해줘야 아래 생성자에서 set 연산이 제대로 들어감

	Random r = new Random();
	
	JLabel[] l =new JLabel[30];
	
	int[] a = new int [30];
	int x=0;
	int y=0;
	int rr=0;
	int gg=0;
	int bb=0;
	Color c;
	
	public NumberFrame() {
		j1.setLayout(null);
		setSize(500,500);
		setTitle("랜덤숫자 버튼 출력");
		//j1.setLocation(x, y);
		//j1.setBounds(r.nextInt(500), r.nextInt(500), 500, 500);
		
		for (int i = 0; i < 30; i++) {
			
			l[i]=new JLabel(""+(i + 1));
			x=r.nextInt(500)+1;
			y=r.nextInt(500)+1;
			rr=r.nextInt(256);
			gg=r.nextInt(256);
			bb=r.nextInt(256);
			
			c=new Color(rr,gg,bb);
			
			l[i].setForeground(c);
			
			l[i].setSize(50,50);
			l[i].setLocation(x, y);
//			l[i].setBounds(x, y, 50, 50);

			j1.add(l[i]);
		
		} // end for

		add(j1);
		setSize(500,500);
		setVisible(true);
	}

}
