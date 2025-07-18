package calculator;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> total;
    private ArrayList<Double> area;  // 원 넓이를 저장하기 위한 리스트를 외부에서 접근할 수 없도록 private 으로 생성
    final static double PI = 3.141592;
    // 인스턴스마다 값이 중복 저장되는것을 방지하기 위해 static 을 사용함

    public Calculator() {
        this.total = new ArrayList<>();
        this.area = new ArrayList<>();
    }

    public int calculate(int num1, int num2, char operator) {
        int result = 0;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            if (num2 > num1) {
                throw new IllegalArgumentException("두 번째 숫자가 첫 번째 숫자보다 커서 연산을 진행할 수 없습니다.");
            } else {
                result = num1 - num2;
            }
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            } else {
                result = num1 / num2;
            }
        } else {
            throw new IllegalArgumentException("잘못된 연산자입니다.: " + operator);
        }
        total.add(result);
        return result;
    }

    public ArrayList<Integer> getTotal() {
        return this.total;
    }

    public void setTotal(ArrayList<Integer> total) {
        this.total = total;
    }

    public void removeResult(String str) {
        if (str.equals("remove")) {
            total.remove(0);
        }
    }

    public void inquiryResults(String str) {
        if (str.equals("inquiry")) {
            System.out.println("저장된 연산 결과");
            for (int i : total) {
                System.out.println("연산 결과: " + i);
            }
        }
    }

    public double calculateCircleArea(int r) {
        double result = r * r * PI;
        area.add(result);
        return result;
    }

    public void savedArea() {
        for (double i : area) {
            System.out.println("원넓이: " + i);
        }
    }

    public ArrayList<Double> getArea() {
        return this.area;
    }

    public void setArea(ArrayList<Double> area) {
        this.area = area;
    }
}
