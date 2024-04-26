package calculator;

//  Calculator Class 를 추상화 하고 여기랑 Circle에 extends
//  그럼 여기서 연산 메서드 final?

import java.util.Queue;

public class ArithmeticCalculator extends Calculator {
    @Override
    public void calculateOperation (String operator, int firstNumber, int secondNumber) throws
            DivisionByZeroException, InvalidOperatorException {
        result = 0;

        if (operator.equals("+")) {
            result = firstNumber + secondNumber;
            System.out.println("결과는 : " + result);
        } else if (operator.equals("-")) {
            result = firstNumber - secondNumber;
            System.out.println("결과는 : " + result);
        } else if (operator.equals("*")) {
            result = firstNumber * secondNumber;
            System.out.println("결과는 : " + result);
        } else if (operator.equals("/")) {
            if (secondNumber == 0) {
                // Exception
                throw new DivisionByZeroException("분모에 0이 들어올 수 없습니다.");
            }
            result = firstNumber / secondNumber;
            System.out.println("결과는 : " + result);
        } else {
            throw new InvalidOperatorException("잘못된 연산자 입니다.");
        }
        Queue<Integer> tempQueue = getResultQueue();
        tempQueue.offer(result);
        setResultQueue(tempQueue);
    };

    @Override
    public void calculateRadius (double radius) {
        throw new UnsupportedOperationException("ArithmeticCalculator does not support radius calculation.");
    } ;


}
