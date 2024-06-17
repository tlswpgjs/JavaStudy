package ex15usefulclass;

/*
equals() 메서드
-자바에서 인스턴스의 내용 비교를 위해 비교연산자(==)를 사용하는 것은
단순히 참조값에 대한 비교를 하는 것이므로, 실제 내용에 대한 비교가
이루어지지 않는다.
-인스턴스간의 내용 비교를 위해서는 equals()를 각 클래스에 맞게
오버라이딩 하여 사용해야 한다.
-String과 같은 기본 클래스는 별도의 오버라이딩 없이도 내용 비교가
가능하다.
 */
class IntNumber2 {
    int num;

    public IntNumber2(int num) {
        this.num = num;
    }

    /*
     * equals() 메서드가 어떻게 인스턴스간의 내용을 비교하는지 설명하기 위한
     * 메서드 정의
     */
    // 비교를 위해 IntNumber2 타입의 인스턴스를 매개변수로 받은 후..
    public boolean myEquals(IntNumber2 numObj) {
        // 전달된 인스턴스의 멤버변수와 값을 비교하여..
        if (this.num == numObj.num) {
            // 동일한 값이면 true를 반환
            return true;
        } else {
            // 다른 값이면 false를 반환
            return false;
        }
    }
}

public class E04Object2MyEqual {

    public static void main(String[] args) {

        /*
         * String과 같은 기본클래스는 별도의 오버라이딩 없이도
         * 내용 비교가 가능하다.
         */
        String str1 = new String("Java개발자");
        String str2 = "Java개발자";
        if (str1.equals(str2)) {
            System.out.println("같은 문자열입니다."); // 결과출력
        } else {
            System.out.println("다른 문자열입니다.");
        }

        // 정의한 클래스를 통해 인스턴스를 생성
        IntNumber2 num1 = new IntNumber2(10);
        IntNumber2 num2 = new IntNumber2(20);
        IntNumber2 num3 = new IntNumber2(10);

        /*
         * 개발자가 직접 정의한 myEquals() 메서드를 통해
         * 내용비교를 한다.
         */
        if (num1.myEquals(num2)) {
            System.out.println("num1과 num2는 동일한 정수");
        } else {
            System.out.println("num1과 num2는 다른 정수"); // 결과출력
        }

        /*
         * 인스턴스간의 비교를 할 때는 단순히 참조변수에 대한 비교를 하면
         * 안되고, 실제 내용에 대한 비교를 해야한다.
         */
        if (num1.myEquals(num3)) {
            System.out.println("num1과 num3는 동일한 정수"); // 결과출력
        } else {
            System.out.println("num1과 num3는 다른 정수");
        }
    }

}
