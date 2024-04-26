package calculator;

public class DivideOperator {
    public int divide(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Divide by zero");
        } else {
            return firstNumber / secondNumber;
        }
    }
}
