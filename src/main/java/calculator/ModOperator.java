package calculator;

public class ModOperator implements OperatorInterface {
    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber % secondNumber;
    }
}
