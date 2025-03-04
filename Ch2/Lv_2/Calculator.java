package Ch2.Lv_2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> resultArr; // ���� ��� ���� �÷���
    private boolean validOperation; // ���� ��ȿ�� üũ

    // ������
    public Calculator() {
        resultArr = new ArrayList<>(); // ��� ���� ����Ʈ �ʱ�ȭ
    }

    public int calculate(int num1, int num2, char operator) {
        validOperation = true; // �Ź� ��� �� ��ȿ�� �ʱ�ȭ
        int result = 0; // ��� �ʱ�ȭ

        switch (operator) {
            case '+':
                result = num1 + num2; // ����
                break;
            case '-':
                result = num1 - num2; // ����
                break;
            case '*':
                result = num1 * num2; // ����
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("������ ���꿡�� �и�(�� ��° ����)�� 0�� �Էµ� �� �����ϴ�.");
                    validOperation = false; // ��ȿ���� ���� ����
                } else {
                    result = num1 / num2; // ������
                }
                break;
            default:
                System.out.println("�߸��� ���� ��ȣ�Դϴ�.");
                validOperation = false;
                break;
        }

        if (validOperation) {
            resultArr.add(result); // ����� ����
            System.out.println("���: " + result);
        }

        return result;
    }

    // ����� ��������
    public List<Integer> getResults() {
        return resultArr;
    }

    // ��� �� �����ϱ�
    public void setResult(int newResult) {
        if (!resultArr.isEmpty()) {
            this.resultArr.remove(resultArr.size() -1); // ���� ����� �����
            this.resultArr.add(newResult); // �� ����� �߰�
        } else {
            System.out.println("������ ���� �����ϴ�.");
        }
    }

    // ����ڰ� ���ϴ� �����͸� ����
    public void removeResult(int removeIndex) {
        if (!resultArr.isEmpty()) {
            resultArr.remove(removeIndex); // ��� ��� ����
        } else {
            System.out.println("������ ����� �����ϴ�.");
        }
    }
}