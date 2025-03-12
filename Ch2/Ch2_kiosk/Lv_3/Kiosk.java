package Ch2.Ch2_kiosk.Lv_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {

    ArrayList<MenuItem> burgers;

    // 생성자
    public Kiosk(ArrayList<MenuItem> burgers) {
        this.burgers = burgers;
    }


    // Kiosk start 메서드
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 메뉴 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < burgers.size(); i++) {
                MenuItem burger = burgers.get(i);
                System.out.printf("%d. %s | W %.1f | %s\n", i + 1, burger.name, burger.price, burger.description);
            }
            System.out.println("0. 종료 | 종료");

            // 번호 입력
            System.out.print("번호를 선택하세요: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice > 0 && choice <= burgers.size()) {
                MenuItem selectedBurger = burgers.get(choice - 1);
                System.out.printf("메뉴: %s | 가격: %.1f | 설명: %s\n", selectedBurger.name, selectedBurger.price, selectedBurger.description);
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
