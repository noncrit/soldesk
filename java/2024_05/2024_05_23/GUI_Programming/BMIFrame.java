package com.kim.may_23_4.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class BMIFrame implements ActionListener {
	
	private JTextField field1; 	//키(cm)
	private JTextField field2;	//몸무게
	private JLabel rlb;	//BMI 결과
	
	public BMIFrame() {
	// TODO Auto-generated constructor stub
	}
	


	public BMIFrame(JTextField field1, JTextField field2, JLabel rlb) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.rlb = rlb;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		double height_m = Double.parseDouble( field1.getText() );
		height_m=(height_m / 100);
		
		double weight = Double.parseDouble( field2.getText());
		
		double BMI = weight/(height_m*height_m);
		String result;
		if(BMI<18.5) {
			result="저체중";
		}
		else if(BMI<=23) {
			result="정상";
		}
		else if(BMI<25) {
			result="과체중";
		}
		else if(BMI>=25) {
			result="비만";
		}
		else result = "에이";
		
		String fianlResult=String.format("BMI : %.2f, 당신은 %s입니다."
											,BMI, result);
		rlb.setText(fianlResult);
		
		//String c = new DecimalFormat("##.####").format(BMI);
		//field3.setText(String.format("당신의 BMI : %s, %s입니다.",c,result));
		//System.out.println(String.format("당신의 BMI : %s, %s입니다.",c,result) );
	}
	
	
}
