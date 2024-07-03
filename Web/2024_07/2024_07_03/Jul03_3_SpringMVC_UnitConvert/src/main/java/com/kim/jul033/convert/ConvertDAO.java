package com.kim.jul033.convert;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class ConvertDAO {
	
	private double result;
	
	public void convert(HttpServletRequest request) throws UnsupportedEncodingException {
	
		request.setCharacterEncoding("UTF-8");
		
		int input = Integer.parseInt(request.getParameter("num"));
		request.setAttribute("input", input);
		
		int option=Integer.parseInt(request.getParameter("option"));
		request.setAttribute("option", option);
		
		if(option==1) {
			result = cmToinch(input);
		}
		else if(option==2) {
			result = mmToPyeong(input);
		}
		else if(option==3) {
			result = CelciusToFahrenheit(input);
		}
		else if(option==4) {
			result = mileTokilo(input);
		}
		
		System.out.println(input);
		System.out.println(result);
		request.setAttribute("result", result);
		
		
	}
	
	public void convert2(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		
		int input = Integer.parseInt(request.getParameter("num"));
		request.setAttribute("input", input);
		
		String option=request.getParameter("option");
		request.setAttribute("option", option);
		
		if(option.equals("length")) {
			result = cmToinch(input);
		}
		else if(option.equals("area")) {
			result = mmToPyeong(input);
		}
		else if(option.equals("temp")) {
			result = CelciusToFahrenheit(input);
		}
		else if(option.equals("speed")) {
			result = mileTokilo(input);
		}
		System.out.println(option);
		System.out.println(input);
		System.out.println(result);
		request.setAttribute("result", result);
		
		
	}
	
	public double cmToinch(int a) {
		return Math.round(((double)a / 2.54) * 100)/100.0;
	}
	
	public double mmToPyeong(int a) {
		return Math.round( ((double)a / 3.306)*1000 )/ 1000.0;
	}
	
	public double CelciusToFahrenheit(int a) {	
		return Math.round( ( ( (double)a * 1.8) + 32) * 1000 )/ 1000.0;
	}
	
	public double mileTokilo(int a) {
		return Math.round( ((double) a * 1.609)*1000)/1000.0;
	}

}
