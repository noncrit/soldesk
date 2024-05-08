/*재귀함수 recursive call
 * 자기 자신을 반복적으로 호출하는 함수
 * 함수를 호출하는 것 -> 시스템적으로 느린작업
 * 재귀함수를 다루는 이유? >> 재귀함수를 이용한 알고리즘 짤일이 있음
 *fac_test 함수에 질문했던거 적혀있음->외부에 변수 선언 안하고 재귀 함수 안쪽에서 처리하는법! 
 */
public class FMain5 {
	//등차수열 만들기- 정수를 하나 집어넣으면 해당하는 숫자까지 다 더한 값을 구하는 함수(재귀를 이용해 만들기)
	
	public static void main(String[] args) {
		int total=0;
		//arith_seq2(1000,total);
		//System.out.println(fac(5));
		System.out.println(fibonachi(7));
	}
	
	//등차수열 함수(내가 짠 버전)
	public static int arith_seq(int input,int total) {
		
		if(input>0){total=total+input; 
					System.out.print("(+"+input+")");
					System.out.println(total);
					arith_seq(input-1,total);
					}
		return total;
	}
	
	//등차수열 간단한 버전 오...
	public static int add(int x) {
		int answer = (x==1)?1:(x+add(x-1));
		return answer;
	}
	//정수 하나 받아서 팩토리얼 구현
	public static int fac(int x) {
		int answer = (x==1)?1:(x*fac(x-1));
		return answer;
	}
	//***********외부에 answer 선언안하고 삼항연산자처럼 써먹을순 없나?-확인!-모든 조건문에 return 적으면 똑같음********
	public static int fac_test(int x) {
		if(x==1) {
			int answer=1;
			return answer;
		}
		else {
			int answer=x*fac_test(x-1);
			return answer;
		}
	}
	
	//피보나치 수열 정수를 하나 넣으면 해당 위치에 나올 숫자값 구하기
	public static int fibonachi(int x) {
		int total=(x==1||x==2)?1:(fibonachi(x-1)+fibonachi(x-2));
		return total;
	}
}
