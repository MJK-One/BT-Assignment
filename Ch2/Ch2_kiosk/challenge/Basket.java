package Ch2.Ch2_kiosk.challenge;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<BasketItem> basketItems;

    public Basket() {
        this.basketItems = new ArrayList<>();
    }

    // 장바구니 추가
    public void addItem(MenuItem menuItem, int quantity) {
        basketItems.add(new BasketItem(menuItem, quantity));
    }

    // 장바구니 확인
    public void printBasket() {
        double total = 0;
        System.out.println("[ Orders ]");
        for (BasketItem basketItem : basketItems) {
            System.out.printf("%s | W %.1f | 수량: %d\n", basketItem.getMenuItem().getName(), basketItem.getMenuItem().getPrice(), basketItem.getQuantity());
            total += basketItem.getMenuItem().getPrice() * basketItem.getQuantity();
        }
        System.out.println("[ Total ]");
        System.out.printf("W %.1f \n", total);
    }

    // 장바구니 초기화
    public void clear() {
        basketItems.clear();
    }

    // basketItems에 요소가 확인
    public boolean Confirm() {
        return basketItems.isEmpty();
    }

    // 가격 계산 메서드
    public double getTotal() {
        double total = 0;
        for (BasketItem basketItem : basketItems) {
            total += basketItem.getMenuItem().getPrice() * basketItem.getQuantity();
        }
        return total;
    }
}
