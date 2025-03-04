package Ch2.Lv_1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 무한 루프 : 'exit'를 입력할 때까지 계속 실행
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            int result = 0; // 결과
            boolean validOperation = true; // 연산 유효성 = true

            // 계산기
            switch (operator) {
                case '+':
                    result = num1 + num2; // 덧셈
                    break;
                case '-':
                    result = num1 - num2; // 뺄셈
                    break;
                case '*':
                    result = num1 * num2; // 곱셈
                    break;
                case '/':
                    // 나눗셈에서 분모가 0인지 확인
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        validOperation = false; // 유효하지 않은 연산 = false
                    } else {
                        result = num1 / num2; // 나눗셈
                    }
                    break;
                default:  // 조건 외 처리
                    System.out.println("잘못된 연산 기호입니다.");
                    validOperation = false;
                    break;
            }

            // 유효한 연산이었을 경우 결과 출력
            if (validOperation) {
                System.out.println("결과: " + result);
            }

            // 계산 후 종료 의사 묻기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitCommand = sc.next();
            if (exitCommand.equals("exit")) {
                break; // 'exit' 입력 시 루프 종료
            }
        }

        System.out.println("프로그램을 종료합니다."); // 프로그램 종료
    }
}