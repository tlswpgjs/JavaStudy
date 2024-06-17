package ex07string;

import java.util.Scanner;

public class E02StringMethod4Practice {

    public static void main(String[] args) {

        juminNumber();
        emailCheck();
        juminGender();
        fileCheck();
    }

    static void juminNumber() {
        /*
         * 시나리오1] 주민등록번호를 이용하여 성별을 판단하는
         * 프로그램을 charAt()을 이용해서 작성하시오.
         * 190419-3000000 => 남자
         * 190419-4000000 => 여자
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("### 시나리오1 ###");
        System.out.print("주민번호를 입력하세요: ");
        String juminNum = scanner.nextLine();

        // 주민번호 입력시 -를 입력했을 경우를 대비하여 -를 제거한다.
        if (juminNum.contains("-")) {
            juminNum = juminNum.replace("-", "");
        } else {
            System.out.println("주민번호 형식이 올바르지 않습니다.");
            return;
        }

        // 주민번호를 이용해서 성별을 판단하는 로직
        if (juminNum.charAt(6) == '1' || juminNum.charAt(6) == '3') {
            System.out.println("남자입니다.");
        } else if (juminNum.charAt(6) == '2' || juminNum.charAt(6) == '4') {
            System.out.println("여자입니다.");
        } else if (juminNum.charAt(6) == '5' || juminNum.charAt(6) == '6') {
            System.out.println("외국인입니다.");
        } else {
            System.out.println("주민번호가 잘못되었습니다.");
        }
    }

    static void emailCheck() {
        /*
         * 시나리오2] 해당 문자열이 이메일 형식인지 검사하는
         * 프로그램을 contains()를 이용해서 작성하시오.
         * hong@daum.net => 이메일형식임
         * not@naver => 이메일형식이아님
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("### 시나리오2 ###");
        System.out.print("이메일주소를 입력하세요: ");
        String email = scanner.nextLine();

        if (email.contains("@") && email.contains(".")) {
            System.out.println("이메일형식임");
        } else {
            System.out.println("이메일형식이아님");
        }
    }

    static void juminGender() {
        /*
         * 시나리오3]주민등록번호로 성별을 구분하는 프로그램을 indexOf()와 charAt()을
         * 이용해서 작성하시오.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("### 시나리오3 ###");
        System.out.print("주민번호를 입력하세요: ");
        String juminGen = scanner.nextLine();

        // 성별을 판단하는 로직
        if (juminGen.indexOf("-") != -1) {
            juminGen = juminGen.substring(0, juminGen.indexOf("-"));
        } else {
            System.out.println("주민번호 형식이 올바르지 않습니다.");
            return;
        }

        if (juminGen.charAt(6) == '1' || juminGen.charAt(6) == '3') {
            System.out.println("남자입니다.");
        } else if (juminGen.charAt(6) == '2' || juminGen.charAt(6) == '4') {
            System.out.println("여자입니다.");
        } else if (juminGen.charAt(6) == '5' || juminGen.charAt(6) == '6') {
            System.out.println("외국인입니다.");
        } else {
            System.out.println("주민번호가 잘못되었습니다.");
        }
    }

    static void fileCheck() {
        /*
         * 시나리오4] 다음 파일명에서 확장자를 잘라내는 프로그램을
         * 작성하시오.
         * 파일명 : my.file.images.jpg
         */

        String filename = "my.file.images.jpg";
        System.out.println("### 시나리오4 ###");
        int beginIndex = filename.lastIndexOf(".") + 1;
        System.out.println("파일의 확장자는: " + filename.substring(beginIndex));
    }
}
