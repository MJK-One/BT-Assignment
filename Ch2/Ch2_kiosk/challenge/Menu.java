package Ch2.Ch2_kiosk.challenge;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String categoryName;
    private final List<MenuItem> menuItems;

    // 생성자
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    // MenuItem 추가
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    // getter
    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(menuItems); // 방어적 복사
    }

}
