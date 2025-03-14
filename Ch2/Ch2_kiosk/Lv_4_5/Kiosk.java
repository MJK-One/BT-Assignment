package Ch2.Ch2_kiosk.Lv_4_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
//    // 캡슐화 X
//    public List<Menu> menus;
//
//    생성자
//    public Kiosk(List<Menu> menus) {
//        this.menus = menus;
//    }
    private final List<Menu> menus;

    // 생성자
    public Kiosk(List<Menu> menus) {
        this.menus = new ArrayList<>(menus);
    }

    // Kiosk start 메서드
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 메인 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                Menu menu = menus.get(i);
                System.out.printf("%d. %s\n", i + 1, menu.getCategoryName());
                // 캡슐화 X
                // System.out.printf("%d. %s\n", i + 1, menu.categoryName());
            }
            System.out.println("0. 종료 | 종료");

            // 번호 입력
            System.out.print("번호를 선택하세요: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice > 0 && choice <= menus.size()) {
                Menu selectedMenu = menus.get(choice - 1);
                MenuItemsBoard(selectedMenu);
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private void MenuItemsBoard(Menu menu) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[ " + menu.getCategoryName() + " MENU ]");
        List<MenuItem> items = menu.getMenuItems();

        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.printf("%d. %s | W %.1f | %s\n", i + 1, item.getName(), item.getPrice(), item.getDescription());
            // 캘슐화 X
            // System.out.printf("%d. %s | W %.1f | %s\n", i + 1, items.name, items.price, items.description);
        }
        System.out.println("0. 뒤로가기");

        // 메뉴 아이템 선택
        System.out.print("번호를 선택하세요: ");
        int choice = sc.nextInt();

        if (choice == 0) {
            return; // 뒤로가기
        } else if (choice > 0 && choice <= items.size()) {
            MenuItem selectedItem = items.get(choice - 1);
            System.out.printf("선택한 메뉴: %s | W %.1f | %s\n", selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());
            // 캡슐화 X
            // System.out.printf("선택한 메뉴: %s | W %.1f | %s\n", selectedItem.name(), selectedItem.price(), selectedItem.description());
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }
}