package org.skypro.skyshop;

public class SimpleProduct extends Product{

    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        try {
            if (price > 0) {
                this.price = price;
            } else {
                throw new IllegalArgumentException("Цена должна быть больше 0");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}
