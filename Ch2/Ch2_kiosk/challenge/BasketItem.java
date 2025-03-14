package Ch2.Ch2_kiosk.challenge;

class BasketItem {
    private final MenuItem menuItem;
    private final int quantity;

    public BasketItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    // getter
    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }
}