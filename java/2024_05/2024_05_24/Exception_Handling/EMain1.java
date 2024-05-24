package com.kim.may_24_1.main;

import java.util.Scanner;

//어떤 프로그램을 실행하게 되었을 때 콘솔창에 경고문 뜨는거 -> 에러/경고문/예외 케이스

//Error
//	Java의 문법에 맞지 않는 코드를 발견, 컴파일이 불가능한 상태 =>개발자가 문법을 잘못 썼기 때문
//	컴파일이 안되니 구동도 안됨
//	ex) in i ="asdf";

//Warning
//	취약점 or 위험한 코드일때(지저분한 코드)일 때 경고 메세지가 나옴
//	컴파일 가능, 프로그램 실행 자체도 가능함
//	이클립스에서 친절하게 고치라고 알려줌
//	ex)변수나 객체 만들고 한번도 안쓰는 경우

//Exception
//	프로그램 자체는 100% 완성이 되었다 가정
//	실행할 때 외부적 요인으로 코드의 작동이 제대로 되지 않는 경우
//	개발자의 잘못은 아님
//	개발자의 입장 => 개발자가 상황을 예측해서 대책은 세워놓자...
public class EMain1 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int x;
		int y;
		System.out.println("x,y를 입력해주세요.");
		x=sc.nextInt();
		y=sc.nextInt();
		
		int sum=x+y;
		int abstraction=x-y;
		int product=x*y;
		//double divide=-1;	
		
		//Exception 처리 - try catch
		//try 안쪽 구문을 먼저 실행, 만일 exception이 발생하면 catch 쪽 블록이 실행됨
		//이때, catch 쪽 파라미터로 Exception(예외 유형명 변수명)을 받음
		//try쪽에서 exception 발생 없이 정상적으로 코드 실행이 끝난 경우 catch 블록은 그냥 생략됨
		//catch 여러 개로 여러 유형의 엑셉션 처리 가능
		//finally{... } => exception 발생 여부에 상관없이 finally 안쪽 블록은 무조건 실행됨
		//***finally는 return 보다 실행 우선순위가 높음***
		//Exception 각각의 경우에 대한것은 알아서 잡아내야함
		System.out.println("x+y = "+sum);
		System.out.println("x-y = "+abstraction);
		System.out.println("x*y = "+product);
		/*
		try {
			double divided=x/y;
			int[] ar = {1,2,3};
			System.out.println(ar[x]);
			System.out.println("x/y = "+divided);
		} catch (ArithmeticException ae) {
			System.out.println("Divide by zero");
		} catch (ArrayIndexOutOfBoundsException array_e) {
			System.out.println("Out of array index bound");
		}
		*/
		
		// x  y
		// 2  0	// 2nd cath
		// 10 1	// 51,52,53(exception) ->3rd catch
		// 2  1	// 1st try
		//즉, 먼저 발생한 exception에 해당하는 catch가 먼저 실행된다.
		//Java의 입장에서는 실행 중지 발생후 즉시 해당 exception에 해당하는 catch로 즉시 브랜치
		
		//Exception 객체 : 자바에 존재하는 모든 Exception을 받을 수 있음(귀찮으면 이거 쓰기)
		try {
			double divided=x/y;
			int[] ar = {1,2,3};
			System.out.println(ar[x]);
			System.out.println("x/y = "+divided);
		} catch (Exception e) {
			System.out.println("편 안");
			e.printStackTrace();	//err스트림 출력(개발용)
		} finally {
			System.out.println("ㅋㅋㅋㅋㅋㅋㅋ");
		}

	}//end of main
	
}
