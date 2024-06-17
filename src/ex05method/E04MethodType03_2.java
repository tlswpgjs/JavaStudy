package ex05method;

import java.util.Scanner;

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

public class E04MethodType03_2 {

    public static void inputGugudan(int sNum, int eNum) {
        // 첫번째 입력받는 수가 더 큰 경우에 대한 예외처리
        if (sNum > eNum) {
            System.out.println("첫번째 숫자는 두번째 숫자보다 작아야 합니다.");
            return;
        }
        // 시작 숫자부터 끝 숫자까지 반복
        for (int i = sNum; i <= eNum; i++) {
            // 각 숫자에 대해 1부터 9까지 곱한 결과를 출력
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %2d | ", i, j, i * j);
            }
            // 각 숫자의 구구단이 끝날 때마다 구분선 출력
            System.out.println(" ");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("첫번째 숫자를 입력하세요: ");
        int sNum = scanner.nextInt();

        System.out.printf("두번째 숫자를 입력하세요: ");
        int eNum = scanner.nextInt();

        inputGugudan(sNum, eNum);
    }

}
