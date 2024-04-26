package calculator;

public class MultiplyOperator implements OperatorInterface {
    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
