
public class Doctor {

		String name;
		int age;
		double bmi;
		String bmi_result;
		
		public void print_doc() {	
			System.out.println("의사 이름 : "+this.name);
			System.out.println("나이 : "+this.age);
		}
		
		public String doctor_guest_in(String guest_name) {
			
			System.err.printf("%s 환자분 들어오세요\n",guest_name); //우선순위 있음
			System.out.println("[환자 이름을 입력해주세요.]");
			return guest_name;
		}
		
		public boolean is_guest_in(int is_in) {
			
			if(is_in==0) {
				System.err.println("키와 몸무게를 말씀해주세요.");
				return true;
			}
			else return false;
		}
		
		public double doctor_BMI_calc(double height, double weight) {
			
			
			double height_meter=(height/100);
			double bmi=weight/(height_meter*height_meter);
			
			return bmi;	
		}
		
		
		public void doctor_BMI_result(double bmi) {
			
			if(bmi>=40) {
				System.err.printf("BMI 지수 : %.3f 고도비만입니다.",bmi);			
			}
			else if(bmi>=35) {
				System.err.printf("BMI 지수 : %.3f 중증도비만입니다.",bmi);			
			}
			else if(bmi>=30) {
				System.err.printf("BMI 지수 : %.3f 비만입니다.",bmi);			
			}
			else if(bmi>=25) {
				System.err.printf("BMI 지수 : %.3f 과체중입니다.",bmi);			
			}
			else if(bmi>=18.5) {
				System.err.printf("BMI 지수 : %.3f 정상체중입니다.",bmi);			
			}
			else if(bmi<18.5) {
				System.err.printf("BMI 지수 : %.3f 저체중입니다.",bmi);
			}
			
		}
		
}
