package calculator;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> total = new ArrayList<>();

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
}
