package calculator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int i = 0;

        boolean run = true;
        while (run) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            /*
            next 라는 스캐너의 메소드는 String 을 반환하기 때문에 그냥 char operator 하면 에러 발생
            charAt(idx): char 타입으로 반환하고자 하는 문자열의 위치(index)를 매개변수로 받아 char 타입으로 변경
            */

            int result = 0;
            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                if (num2 > num1) {
                    System.out.println("두 번째 숫자가 첫 번째 숫자보다 커서 연산을 진행할 수 없습니다.");
                } else {
                    result = num1 - num2;
                }
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("분모에 0이 입력될 수 없습니다.");
                } else {
                    result = num1 / num2;
                }
            } else {
                System.out.println("잘못된 접근입니다.");
            }
            System.out.println("결과: " + result);

            if (i < 10) {
                arr[i] = result;
                i++;
            } else {
                int j = 0;
                while (j < 9) {
                    arr[j] = arr[j + 1];  // 앞으로 하나씩 당기기
                    j++;
                }
                arr[9] = result;  // 마지막 위치에 새 결과 저장
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String str = sc.next();

            if (str.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                run = false;
            }
        }
        for (int k = 0; k < i; k++) {
            System.out.println("연산 결과: " + arr[k]);
        }
    }
}
