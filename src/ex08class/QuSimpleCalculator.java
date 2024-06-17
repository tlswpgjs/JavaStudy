package ex08class;

class CalculatorEx {

    // 멤버변수
    int addCount, minCount, mulCount, divCount;

    // 멤버변수 초기화 메소드
    void init() {
        addCount = 0;
        minCount = 0;
        mulCount = 0;
        divCount = 0;
    }

    // 사칙연산 수행 메소드
    double add(double a, double b) {
        addCount++;
        return a + b;
    }

    double min(double a, double b) {
        minCount++;
        return a - b;
    }

    double mul(double a, double b) {
        mulCount++;
        return a * b;
    }

    double div(double a, double b) {
        divCount++;
        return a / b;
    }

    // 연산의 횟수를 출력하는 메소드
    void showOpCount() {
        System.out.println("덧셈횟수 : " + addCount);
        System.out.println("뺄셈횟수 : " + minCount);
        System.out.println("곱셈횟수 : " + mulCount);
        System.out.println("나눗셈횟수 : " + divCount);
    }
}

public class QuSimpleCalculator {

    public static void main(String[] args) {
        CalculatorEx cal = new CalculatorEx();
        cal.init();

        System.out.println("1 + 2 = " + cal.add(1, 2));
        System.out.println("10.5 - 5.5 = " + cal.min(10.5, 5.5));
        System.out.println("4.0 * 5.0 = " + cal.mul(4.0, 5.0));
        System.out.println("100 / 25 = " + cal.div(100, 25));
        System.out.println("10.0 * 3.0 = " + cal.mul(10.0, 3.0));
        cal.showOpCount();
    }

}
