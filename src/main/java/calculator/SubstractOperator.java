package calculator;

public class SubstractOperator implements OperatorInterface{
    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
