package Ch2.Lv_1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ���� ���� : 'exit'�� �Է��� ������ ��� ����
        while (true) {
            System.out.print("ù ��° ���ڸ� �Է��ϼ���: ");
            int num1 = sc.nextInt();
            
            System.out.print("�� ��° ���ڸ� �Է��ϼ���: ");
            int num2 = sc.nextInt();

            System.out.print("��Ģ���� ��ȣ�� �Է��ϼ��� (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            int result = 0; // ���
            boolean validOperation = true; // ���� ��ȿ�� = true

            // ����
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
                    // ���������� �и� 0���� Ȯ��
                    if (num2 == 0) {
                        System.out.println("������ ���꿡�� �и�(�� ��° ����)�� 0�� �Էµ� �� �����ϴ�.");
                        validOperation = false; // ��ȿ���� ���� ���� = false
                    } else {
                        result = num1 / num2; // ������
                    }
                    break;
                default:  // ���� �� ó��
                    System.out.println("�߸��� ���� ��ȣ�Դϴ�.");
                    validOperation = false;
                    break;
            }

            // ��ȿ�� �����̾��� ��� ��� ���
            if (validOperation) {
                System.out.println("���: " + result);
            }

            // ��� �� ���� �ǻ� ����
            System.out.println("�� ����Ͻðڽ��ϱ�? (exit �Է� �� ����)");
            String exitCommand = sc.next();
            if (exitCommand.equals("exit")) {
                break; // 'exit' �Է� �� ���� ����
            }
        }

        System.out.println("���α׷��� �����մϴ�."); // ���α׷� ����
    }
}