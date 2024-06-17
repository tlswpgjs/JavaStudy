package ex05method;

public class QuFindPrimeNumberT {

    public static boolean isPrimeNumber(int n) {
        // 1은 소수가 아니므로 확인절차 없이 false반환
        if (n == 1)
            return false;
        /*
         * 만약 7이라면 1과 7로는 나눠서 떨어지므로 확인이 필요없다.
         * 2~6까지만 나눠보면 되므로 n-1까지만 확인한다.
         */
        for (int x = 2; x < n; x++) {
            /*
             * 만약 나눠서 떨어지는 것이 발견되었다면 소수가 아니므로 뒷부분은
             * 확인할 필요가 없다. 따라서 즉시 false를 반환하고 메서드를 종료한다.
             */
            if (n % x == 0) {
                return false;
            }
        }

        // 위 반복문을 벗어났다면 소수이므로 true반환
        return true;
    }

    public static void main(String[] args) {

        // 1~100까지의 정수 중 소수인지 판단하기 위해 반복호출
        for (int i = 1; i <= 100; i++) {
            // 소수인지 판단하여 boolean값을 반환
            boolean result = isPrimeNumber(i);
            // 소수인 경우에만 콘셀에 출력
            if (result) {
                System.out.printf("소수= %d%n", i);
            }
        }
    }

}
