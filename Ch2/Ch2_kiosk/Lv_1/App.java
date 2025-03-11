package Ch2.Ch2_kiosk.Lv_1;

import java.util.ArrayList;
import java.util.Scanner;

class Burger {
    String name;
    double price;
    String description;

    public Burger(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Burger> burgers = new ArrayList<>();

        burgers.add(new Burger("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new Burger("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new Burger("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new Burger("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while(true) {
            // 메뉴 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < burgers.size(); i++) {
                Burger burger = burgers.get(i);
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
                Burger selectedBurger = burgers.get(choice - 1);
                System.out.println("선택한 버거: " + selectedBurger.name);
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }
}