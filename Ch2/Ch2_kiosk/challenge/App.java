package Ch2.Ch2_kiosk.challenge;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // 메뉴 객체 생성
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinkMenu = new Menu("Drinks");
        drinkMenu.addMenuItem(new MenuItem("Coke", 1.5, "코카콜라"));
        drinkMenu.addMenuItem(new MenuItem("Cider", 1.5, "사이다"));

        Menu dessertMenu = new Menu("Desserts");
        dessertMenu.addMenuItem(new MenuItem("Salad", 7.0, "다양한 야채가 조합"));

        // Kiosk 객체 생성
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(burgerMenu);
        menus.add(drinkMenu);
        menus.add(dessertMenu);

        Kiosk kiosk = new Kiosk(menus); // Kiosk 객체 생성
        kiosk.start(); // Kiosk start~
    }
}