package Ch2.Lv_2;

import java.util.Scanner;

public class App {
    private static Calculator calculator = new Calculator();
    private static Scanner sc = new Scanner(System.in);

    // ��� ���� ��� �޼���
    public void modify() {
        System.out.println("����� �����ұ��? (yes / no)");
        String modifyCommand = sc.next();
        if(!calculator.getResults().isEmpty()) {
            if (modifyCommand.equals("yes")) {
                System.out.println("���ο� ��� ����� �Է��ϼ���:");
                int newResults = sc.nextInt();
                calculator.setResult(newResults); // �� ��� ��� ����
                System.out.println("���ο� ��� ���: " + calculator.getResults());
            }
        } else {
            System.out.println("��� ����� �����ϴ�.");
        }
    }

    // ��� ���� ��� �޼���
    public void remove() {
        // ��� ���� ��� �߰�
        System.out.println("����� �����Ͻðڽ��ϱ�? (yes / no)");
        String deleteCommand = sc.next();
        if(!calculator.getResults().isEmpty()) {
            if (deleteCommand.equals("yes")) {
                System.out.println("�� ��° ����� �����Ͻðڽ��ϱ�?");
                int deleteCount = sc.nextInt();
                calculator.removeResult(deleteCount-1); // ��� ����
                System.out.println("��� ���� �� ���: " + calculator.getResults());
            }
        } else {
            System.out.println("��� ����� �����ϴ�.");
        }
    }

    public static void main(String[] args) {
        App app = new App();

        while (true) {
            System.out.print("ù ��° ���ڸ� �Է��ϼ���: ");
            int num1 = sc.nextInt();

            System.out.print("�� ��° ���ڸ� �Է��ϼ���: ");
            int num2 = sc.nextInt();

            System.out.print("��Ģ���� ��ȣ�� �Է��ϼ��� (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            calculator.calculate(num1, num2, operator); // ��� ����

            // ��� Ȯ��
            System.out.println("���� ��� ���: " + calculator.getResults());

            // ��� �� ����
            app.modify();

            // ��� �� ���� �ǻ� ����
            System.out.println("�� ����Ͻðڽ��ϱ�? (exit �Է� �� ����)");
            String exitCommand = sc.next();
            if (exitCommand.equals("exit")) {
                break; // 'exit' �Է� �� ���� ����
            }
        }

        // ��� �� ����
        app.remove();
    }
}