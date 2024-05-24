package com.kim.may_24_2.main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TextMain2_teacher {
	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		System.out.println("문자열 입력!!(1/2/3/3/ 요런식");
		String s = k.next();
		
		
		StringTokenizer st = new StringTokenizer(s,"/");
		
		int n=0;
		int sum=0;
		int count=0;
		
		while (st.hasMoreTokens()) {
			try {
				n=Integer.parseInt(st.nextToken());
				count++;
				sum +=n;	
				
			} catch (Exception e) {
				//DO nothing, go next loop
			}

			
		}// end of while
		
		System.out.printf("총합 : %d\n",sum);
		System.out.printf("평균 : %.2f\n",(double)sum/count);
		
		
	}//end of main
}
