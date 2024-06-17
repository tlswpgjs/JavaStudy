package ex05method;

public class QuSymmetry {

    public static void main(String[] args) {

        /*
         * 문제6) 다음과 같은 회전대칭 모양의 출력결과를 보이는 프로그램을 while문과 for문으로 작성하시오.
         * 단, 메서드로 작성해야 한다.
         * 메서드명 : rotationSymmetry()
         * 0 0 0 1
         * 0 0 1 0
         * 0 1 0 0
         * 1 0 0 0
         */

        rotationSymmetry();
    }

    static void rotationSymmetry() {

        System.out.println("###for문으로 작성###");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i + j == 3) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        System.out.println("###while문으로 작성###");
        int i = 0;

        while (i < 4) {
            int j = 0;
            while (j < 4) {
                if (i + j == 3) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
                j++;
            }
            System.out.println();
            i++;
        }
    }

}
