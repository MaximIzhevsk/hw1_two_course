package org.skypro.skyshop;

public class DiscountedProduct extends Product{

    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);

        try {
            if (basePrice > 0) {
                this.basePrice = basePrice;
            } else {
                throw new IllegalArgumentException("Цена должна быть больше 0");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (discount >= 0 && discount <= 100) {
                this.discount = discount;
            } else {
                throw new IllegalArgumentException("Процент скидки должен быть от 0 до 100");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public int getPrice() {
        return (int)(basePrice * (1 - discount/100.0));
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
