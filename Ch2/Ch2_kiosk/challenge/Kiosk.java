package Ch2.Ch2_kiosk.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
    private final Basket basket;

    // 생성자
    public Kiosk(List<Menu> menus) {
        this.menus = new ArrayList<>(menus);
        this.basket = new Basket();
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

            // 장바구니에 추가할지 확인
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");
            int addChoice = sc.nextInt();

            if (addChoice == 1) { // 확인
                System.out.print("수량을 입력하세요: ");
                int quantity = sc.nextInt();
                basket.addItem(selectedItem, quantity); // 장바구니에 추가
                System.out.printf("%s 이 %d 개 장바구니에 추가되었습니다.\n", selectedItem.getName(), quantity);
            } else if (addChoice == 2) { // 취소
                System.out.println("장바구니 추가가 취소되었습니다.");
            } else {
                System.out.println("잘못된 선택입니다.");
            }

            // 주문 메뉴 출력
            if (!basket.Confirm()) {
                orderMenu(); // 주문 메뉴 호출
            }
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }

    private void orderMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");

        System.out.print("번호를 선택하세요: ");
        int choice = sc.nextInt();

        if (choice == 4) {
            if (basket.Confirm()) {
                System.out.println("장바구니가 비어 있습니다.");
            } else {
                basket.printBasket();
                System.out.println("1. 주문      2. 메뉴판");
                int orderChoice = sc.nextInt();
                if (orderChoice == 1) {
                    System.out.println("주문이 완료되었습니다. 금액은 W " + basket.getTotal() + " 입니다.");
                    basket.clear();
                }
            }
        } else if (choice == 5) {
            System.out.println("주문이 취소되었습니다.");
            basket.clear();
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }
}
