package calculator;

public class AddOperator implements OperatorInterface{
    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
