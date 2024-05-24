package com.kim.may_24_2.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExampleMain1 {
		//어떤 학생의 (이름/생년월일(yyyy.mm.dd)/국어/수학/영어) 입력받아서
		//학생의 나이, 총점, 평균 점수 값을출력
		//split 으로 쓸 예정
		public static void main(String[] args) {
			
			String input = "KIM/1997.04.12/100/100/95";
			
			String[] a = input.split("/");
			
			System.out.printf("이름 : %s\n",a[0]);
			
			System.out.printf("생년월일 : %s\n",a[1]);
			
			System.out.printf("국어점수 : %s\n",a[2]);
			System.out.printf("수학점수 : %s\n",a[3]);
			System.out.printf("영어점수 : %s\n",a[4]);
			
			Integer convert = Integer.parseInt(a[2]);
			Integer convert1 = Integer.parseInt(a[3]);
			Integer convert2 = Integer.parseInt(a[4]);
			
			int sum=0;
			sum=convert.intValue()+convert1.intValue()+convert2.intValue();
			System.out.printf("평균 : %.2f\n", (double) sum/3);
		}
		
}
