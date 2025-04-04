package org.skypro.skyshop;

public class FixPriceProduct extends Product{

    private static final int FIX_PRICE = 99;

    public FixPriceProduct(String name) throws IllegalArgumentException {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIX_PRICE;
    }
}
