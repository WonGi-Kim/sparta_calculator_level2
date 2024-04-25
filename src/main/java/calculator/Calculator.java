package calculator;

import java.util.LinkedList;
import java.util.Queue;

/** level2 요구사항 4
 *  가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현
 */

public class Calculator {
    /* 연산 결과를 저장하는 컬랙션 타입 필드 선언 및 생성 */
    int result; // 캡슐화
    private Queue<Integer> resultQueue= new LinkedList<>(); // 연산결과를 저장하는 컬렉션 타입

    public Calculator() {}

    // 결과값을 반환하는 메서드
    public void calculate(String operator, int firstNumber, int secondNumber) throws
            DivisionByZeroException, InvalidOperatorException{

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
        setResultQueue(resultQueue);
    }

    public void setResultQueue(Queue<Integer> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public Queue<Integer> getResultQueue() {
        return resultQueue;
    }

    public void removeResultQueue() {
        resultQueue.remove();
    }
}
