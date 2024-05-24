package com.kim.may_24_1.Per_gram;

import java.util.Scanner;

import javax.xml.bind.TypeConstraintException;

public class Per_gram {
	private int price;
	private int weight;
	private double result;
	
	public Per_gram() {
		// TODO Auto-generated constructor stub
	}

	public Per_gram(int price, int weight) {
		super();
		this.price = price;
		this.weight = weight;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
/*
	public double calc_price_per_gram()  {
		//***finally는 return 보다 실행 우선순위가 높음***
		//이 방식의 try-catch-fianlly => 여기에서 아예 끝장을 보자는 방식 =>몬가 쓰는 방식이 잘못됨
		
		try {
			result = (this.price) / (this.weight);
			return result;
		} catch (ArithmeticException ae) {
			System.out.println("Divde by zero");
			return -0;
		} catch (TypeConstraintException te) {
			System.out.println("Wrong type");
			return -1;
		} catch (Exception e) {
			System.out.println("Exception!!!");
			return -999;
		}
	}
*/	//미루기 방식(throws)
	//작업을 수행하다가 Exception이 발생하면 해당 객체를 호출한 쪽에서 해결하라!
	//보통 메인쪽으로 다 밀어버림
	//메인 메소드 말고 다른쪽에서 try-catch 사용하면 월권행위 느낌
	//메인 아닌 메소드에서 throws로 메인쪽으로 넘겨주자
	public double calc_price_per_gram()  throws Exception {
		//***finally는 return 보다 실행 우선순위가 높음***
		//이 방식의 try-catch-fianlly => 여기에서 아예 끝장을 보자는 방식 =>몬가 쓰는 방식이 잘못됨
		
		try {
			result = (this.price) / (this.weight) + (this.price)%(this.weight);
			return result;
		} catch (ArithmeticException ae) {
			System.out.println("Divde by zero");
			return -0;
		} catch (TypeConstraintException te) {
			System.out.println("Wrong type");
			return -1;
		} catch (Exception e) {
			System.out.println("Exception!!!");
			return -999;
		}
	}
	
	public void start() throws Exception {
		//	정상실행시 : 73에서 종료
		//	무게값으로 0 : 71에서 exception 발생 ->43번줄 catch에 걸림
		Scanner sc =new Scanner(System.in);
		
		System.out.println("물건의 가격을 입력해주세요");
		setPrice(sc.nextInt());
		while(this.price<0) {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			setPrice(sc.nextInt());
		}
		
		System.out.println("물건의 무게를 입력해주세요 (g 단위)");
		setWeight(sc.nextInt());
		while(this.weight<0) {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			setWeight(sc.nextInt());
		}
		
		try {
			result = calc_price_per_gram();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("계산 결과");
		System.out.println("g당 가격 : "+result+"원");
		
	}
}
