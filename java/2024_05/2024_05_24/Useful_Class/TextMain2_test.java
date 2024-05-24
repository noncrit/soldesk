package com.kim.may_24_2.main;

public class TextMain2_test {
	//main 에 뭔가를 입력받을 예정
	// a/b/c/d/e...
	// 1/2/3/....=>총합 / 평균값 구하기
	// 숫자라면 =>총합 / 평균값 구하기
	// 글자 부분은 넘기기
	
	// / 외의 문자도 처리 할 수 있게 짜는중
	//이렇게 짜면 한 자리수 밖에 입력 못받음...
	//*************십의 자리수 이상인 수를 어떻게 표현할 것인가???????******************
	public static void main(String[] args) {
		
		String a = new String("1?asdf2,3,/5/6asdfawe/2asd/diobcai8");	
		printer(a);
	}
	
	public static void printer(String a) {
		
		int length = a.length();
		int counter = 0;
		int counter_int = 0;
		int counter_inner=0;
		int sum=0;
		String tmp1;
		String tmp2;
		int tmp_int;
		
		//tmp1.matches("[0-9]*") 안쪽으로 루프문(while) 하나 더 돌려서 substring 2번째 파라미터
		//범위를 점점 늘리다가 while 탈출하면 해당 substring을 통째로 int로 바꾼뒤 sum에 더하는식으로 구현해보자!
		//마지막 글자에서 안쪽 루프가 마지막 글자 +1 의 인덱스를 참조해 exception 발생하는데 이거를 처리해야함!!
		//+한 글자 받으면 그냥 루프돌면 끝나지만, 두 자리수 이상의 수를 받으려면 이미 처리한 문자열은 건너 뛰어야함...
		while(counter<length && counter>=0) {
			
			tmp1 = a.substring(counter,counter+1);
			System.out.printf("%s ",tmp1);
			counter_inner=counter;
			
			for (int i = 1; i < length-1; i++) {
				tmp2=a.substring(i,i+1);
				
				if( tmp2.matches("[0-9]*") ) {
					tmp1=a.substring(counter,counter+1+i);
				}
			}
			Integer convert = Integer.parseInt(tmp1);
			tmp_int=convert.intValue();
			sum+=tmp_int;
			
			counter++;
		}//end of while
		System.out.println();
		
		double expectation=((double)sum/counter_int);
		
		System.out.printf("숫자의 총합 : %d\n",sum);
		System.out.printf("숫자의 평균 : %.2f\n",expectation);
		

	}
	
}