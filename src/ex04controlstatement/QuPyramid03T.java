package ex04controlstatement;

public class QuPyramid03T {

    public static void main(String[] args) {
	
	int num = 5;

        for (int i = 0; i < num; i++) {
            // 공백 출력하기
            for (int j = 1; j <= (num - i); j++) {
        	//i가 증가함에 따라 j의 반복은 감소함
                System.out.print(" ");
            }
            // *출력하기. 조건의 일반식에 의해 1,3,5,7..이 생성됨
            for (int k = 0; k < (i * 2 + 1); k++) {
                System.out.print("*");
            }
            // 한 행 출력후 줄바꿈
            System.out.println();
        }
    }

}