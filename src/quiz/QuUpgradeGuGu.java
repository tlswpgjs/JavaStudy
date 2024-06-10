package quiz;

public class QuUpgradeGuGu {

    public static void main(String[] args) {
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                StringBuilder String = new StringBuilder();
                for (int k = 1; k <= j; k++) {
                    if (k > 1) {
                       String.append(" X ");
                    }
                   String.append(i);
                }
                int result = (int) Math.pow(i, j);
                System.out.println(String.toString() + " = " + result);
            }
        }
    }
}