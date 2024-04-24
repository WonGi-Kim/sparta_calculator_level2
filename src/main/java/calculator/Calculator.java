package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    /* 연산 결과를 저장하는 컬랙션 타입 필드 선언 및 생성 */
    int result;
    Queue<Integer> resultQueue= new LinkedList<>(); // 연산결과를 저장하는 컬렉션 타입

    // 결과값을 반환하는 메서드
    public int calculate(String operator, int firstNumber, int secondNumber) throws
            DivisionByZeroException, InvalidOperatorException{
        /** 요구사항 1
         * 양의 정수 2개와 연산 기호를 매개변수로 받아 사칙 연산 기능을 수행한 후 결과 값을 반환
         * 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘못 들어온 경우 Exception 클래스를 생성하여 throw
         */
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
        resultQueue.offer(result);
        return result;
    }

}
