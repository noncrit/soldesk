package com.kim.jun251.calc;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
		
	public void calculate(HttpServletRequest request) {
		
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int add=x+y;
		int sub=x-y;
		int mul=x*y;
		double divide=x/(double)y;
		String divide2=String.format("%.2f", divide);
		
		request.setAttribute("add", add);
		request.setAttribute("sub", sub);
		request.setAttribute("mul", mul);
		request.setAttribute("divide", divide2);
		
	}

}
