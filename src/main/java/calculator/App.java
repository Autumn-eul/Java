package calculator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> totalResult = new ArrayList<>();  // 리스트 선언

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

            totalResult.add(result);  // 리스트에 연산 결과 저장

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String delete = sc.next();

            if (delete.equals("remove")) {
                totalResult.remove(0);  // 0번째 인덱스 값 삭제
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String end = sc.next();

            if (end.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                run = false;
            }
        }
        for (int i = 0; i < totalResult.size(); i++) {
            System.out.println("연산 결과: " + totalResult.get(i));
        }
    }
}