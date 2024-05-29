package ex05method;

import java.util.Scanner;

public class E04MethodType03_2 {
	/*
	연습문제] 사용자로부터 2~9사이의 숫자중 2개를 입력받아 이에 해당하는 구구단을 출력하는 메서드를 작성하시오. 무조건 첫번째 입력받는수가 작아야한다.
	입력예]
		첫번째숫자 : 3
		두번째숫자 : 12
		3*1=3 3*2=6........
		........
		...................12*9=108
	메서드명 : inputGugudan(int sNum, int eNum)
	 */
	public static void main(String[] args) {
		
		static void inputGugudan(int sNum, int eNum) {
			int dan = sNum;
			while(dan<=eNum) {
				int su = 1;
				while(su<=9) {
					System.out.printf("%-2d*%-2d=%2d", dan, su, (dan*su));
					System.out.print(" ");
					su++;
				}
				System.out.println();
				dan++;
			}
		}
	}

		
//
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.print("첫번쨰숫자:");
//		int sNum = scanner.nextInt();
//		System.out.print("두번째 숫자:");
//		int eNum = scanner.nextInt();
//		myWantSum(sNum, eNum);
//	}
//	
//	static void myWantSum(int sNum, int eNum) {
//		int sum = 0;
//		for(int i=sNum ; i<=eNum ; i++) {
//			for(int j= 1; j <= 9; j++) {
//				System.out.printf("%d * %d = %d\t", i, j, i * j);
//			}
//			System.out.println();
//		}
//		
//	}
//	
//}