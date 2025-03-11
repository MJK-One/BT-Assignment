package Ch2.Ch2_calc.Lv_2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> resultArr; // 연산 결과 저장 컬렉션
    private boolean validOperation; // 연산 유효성 체크

    // 생성자
    public Calculator() {
        resultArr = new ArrayList<>(); // 결과 저장 리스트 초기화
    }

    public int calculate(int num1, int num2, char operator) {
        validOperation = true; // 매번 계산 시 유효성 초기화
        int result = 0; // 결과 초기화

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
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    validOperation = false; // 유효하지 않은 연산
                } else {
                    result = num1 / num2; // 나눗셈
                }
                break;
            default:
                System.out.println("잘못된 연산 기호입니다.");
                validOperation = false;
                break;
        }

        if (validOperation) {
            resultArr.add(result); // 결과를 저장
            System.out.println("결과: " + result);
        }

        return result;
    }

    // 결과를 가져오기
    public List<Integer> getResults() {
        return resultArr;
    }

    // 결과 값 수정하기
    public void setResult(int newResult) {
        if (!resultArr.isEmpty()) {
            this.resultArr.remove(resultArr.size() -1); // 기존 결과를 지우고
            this.resultArr.add(newResult); // 새 결과를 추가
        } else {
            System.out.println("수정할 값이 없습니다.");
        }
    }

    // 사용자가 원하는 데이터를 삭제
    public void removeResult(int removeIndex) {
        if (!resultArr.isEmpty()) {
            resultArr.remove(removeIndex); // 계산 결과 삭제
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }
}