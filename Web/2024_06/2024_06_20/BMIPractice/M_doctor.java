package com.kim.jun202.main;

import javax.servlet.http.HttpServletRequest;

public class M_doctor {
	
	public double calcBMI(double weight, double height) {
		double height_meter=height/100;
		double bmi= weight / (height_meter*height_meter);
		bmi=Math.round(bmi);
		return bmi;
	}
	
	public String bmi_result(double BMI) {
		
		String result = null;
		
		if(BMI<18.5) {
			result="저체중";
		}
		else if(BMI<25) {
			result="정상";
		}
		else if(BMI<30) {
			result="과체중";
		}
		else if(BMI<35) {
			result="경도비만";
		}
		else if(BMI<40) {
			result="중증도 비만";
		}
		else if(BMI>=40) {
			result="고도비만";
		}
		
		return result;
	}
	
}
