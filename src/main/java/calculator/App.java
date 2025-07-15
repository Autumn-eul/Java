package calculator;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();
        ArrayList<Integer> totalResult = cal.getTotal();

        boolean run = true;
        while (run) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            try {
                int result = cal.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
                continue;
            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String delete = sc.next();
            cal.removeResult(delete);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String end = sc.next();

            if (end.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                run = false;
            }
        }
    }
}