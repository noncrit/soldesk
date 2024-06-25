package com.kim.jun251.jstlc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class JSTLCDataMaker {
	public void make(HttpServletRequest request) {
		
		int[] ar = {123,456,78,91,234};
		request.setAttribute("ar", ar);
		
		ArrayList<Kim> al = new ArrayList<Kim>();
		
		al.add(new Kim("김",3,50.5, 10.1));
		al.add(new Kim("석",4,54.2, 21.1));
		al.add(new Kim("진",5,43.8, 13.1));
		al.add(new Kim("김석진",7,50.5, 3.3));
		request.setAttribute("al", al);
		
	}

}
