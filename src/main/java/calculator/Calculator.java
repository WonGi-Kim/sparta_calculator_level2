package calculator;

import java.util.LinkedList;
import java.util.Queue;

/** level2 요구사항 6
 * Calculator 인스턴스를 생성(new)할 때 생성자를 통해
 * 연산 결과를 저장하고 있는 컬렉션 필드가 초기화 되도록 수정합니다.
 */

public class Calculator {

    int result; // 캡슐화
    private Queue<Integer> resultQueue= new LinkedList<>(); // 연산결과를 저장하는 컬렉션 타입

    public Calculator() {
        resultQueue.clear();
        System.out.println("resultQueue clear!: " + resultQueue);
    }

    // 결과값을 반환하는 메서드
    public void calculateOperation(String operator, int firstNumber, int secondNumber) throws
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

    public void inquiryResultQueue() {
        for(int value : getResultQueue()) {
            System.out.print(value + " ");
        }
    }
}
