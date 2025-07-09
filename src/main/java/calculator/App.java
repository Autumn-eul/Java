package calculator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
    }
}
