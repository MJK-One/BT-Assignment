package Ch2.Ch2_calc.Lv_2;

import java.util.Scanner;

public class App {
    private static Calculator calculator = new Calculator();
    private static Scanner sc = new Scanner(System.in);

    // 결과 수정 기능 메서드
    public void modify() {
        System.out.println("결과를 수정할까요? (yes / no)");
        String modifyCommand = sc.next();
        if(!calculator.getResults().isEmpty()) {
            if (modifyCommand.equals("yes")) {
                System.out.println("새로운 결과 목록을 입력하세요:");
                int newResults = sc.nextInt();
                calculator.setResult(newResults); // 새 결과 목록 설정
                System.out.println("새로운 결과 목록: " + calculator.getResults());
            }
        } else if ( modifyCommand.equals("no")) {
        } else {
            System.out.println("결과 목록이 없습니다.");
        }
    }

    // 결과 삭제 기능 메서드
    public void remove() {
        // 결과 삭제 기능 추가
        System.out.println("결과를 삭제하시겠습니까? (yes / no)");
        String deleteCommand = sc.next();
        if (!calculator.getResults().isEmpty()) {
            if (deleteCommand.equals("yes")) {
                System.out.println("몇 번째 결과를 삭제하시겠습니까?");
                int deleteCount = sc.nextInt();
                calculator.removeResult(deleteCount - 1); // 결과 삭제
                System.out.println("결과 삭제 후 목록: " + calculator.getResults());
            }
        } else if (deleteCommand.equals("no")) {
        }else {
            System.out.println("결과 목록이 없습니다.");
        }
    }

    public static void main(String[] args) {
        App app = new App();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            calculator.calculate(num1, num2, operator); // 계산 실행

            // 결과 확인
            System.out.println("현재 결과 목록: " + calculator.getResults());

            // 결과 값 수정
            app.modify();

            // 계산 후 종료 의사 묻기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitCommand = sc.next();
            if (exitCommand.equals("exit")) {
                break; // 'exit' 입력 시 루프 종료
            }
        }

        // 결과 값 삭제
        app.remove();
    }
}