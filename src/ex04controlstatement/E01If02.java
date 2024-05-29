package ex04controlstatement;

public class E01If02 {

	public static void main(String[] args) {
		
		//120을 2로 나누면 나머지가 0이므로 짝수로 판단
		int num = 120;
		if(num%2 == 0) {
			System.out.println("짝수입니다.");
		}
		else {
			System.out.println("홀수입니다.");
		}
		
		/*
		 상향연산자(조건연산자)
		 : if~else문과 동일하지만 짧은 코드로 표현이 가능하므로 실무에서
		 자주 사용된다.
		 형식]
		 	변수 = (조건식) ? 참일때 : 거짓일때 ;
		 */
		String numberResult = (num%2==0) ? "짝수임":"홀수임";
		System.out.println("숫자 "+num+"은 "+ numberResult);
		
		/*
		 시나리오] 숫자를 홀/짝인지 먼저 판단한 후 100 이상인지를
		 	판단하는 프로그램을 if~else문으로 작성하시오.
		 */
		int num2 = 120;
		if(num2%2 == 0) { //짝수일때..
			if(num2>100) {
				System.out.println("짝수이면서 100이상");
			}
			else {
				System.out.println("짝수이면서 100미만");
			}
		}
		else { //홀수일때..
			// 포함된 문장이 1문장이므로 중괄호를 생략할수있다.
			if(num2>=100)
				System.out.println("홀수이면서 100이상");
			else
				System.out.println("홀수이면서 100미만");
		}
	}

}



