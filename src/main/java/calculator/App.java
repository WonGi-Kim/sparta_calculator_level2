package calculator;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

/** level2 요구사항 3
 * main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 캡슐화
 * 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현 Getter 메서드
 * 간접 접근을 통해 필드에 접근하여 수정올 수 있도록 구현 Setter 메서드
 */
public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String finish = new String();
        String stopQueue = new String();
        String printQueue = new String(); //요구사항 8 inquiry를 받을 문자열

        int a; // 첫 번째 숫자
        int b; // 두 번째 숫자
        String operand; // 연산자
        int result = 0; // switch 문 밖에서 선언하고 초기화

        Calculator calculator = new Calculator();

        while (!finish.equals("exit")) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            a = in.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            operand = in.next();

            System.out.print("두 번째 숫자를 입력하세요: ");
            b = in.nextInt();

            try {
                calculator.calculate(operand,a,b);
            } catch (DivisionByZeroException e) {
                throw new RuntimeException(e);
            } catch (InvalidOperatorException e) {
                throw new RuntimeException(e);
            }

            if(calculator.getResultQueue().size() >= 2) { // remove는 큐가 비어있는 경우 예외가 발생하므로 예외 처리를 먼저 해줘야 함
                System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력시 삭제)");
                stopQueue = in.next();
                if (stopQueue.equals("remove")) {
                    calculator.getResultQueue().remove();
                }
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력시 조회)");
            printQueue = in.next();
            if (printQueue.equals("inquiry")) {
                for(int value : calculator.getResultQueue()) { // 요구사항 8 향상된 for문을 사용하여 출력
                    System.out.print(value + " ");
                }
                System.out.println();
            }

            System.out.print("더 계산하시겠습니까? (계속 계산하시려면 아무키나 입력해주세요. exit 입력 시 종료됩니다.)");
            finish = in.next();
            if(finish.equals("exit")) {
                break;
            } else {
                continue;
            }
        }
    }
}

