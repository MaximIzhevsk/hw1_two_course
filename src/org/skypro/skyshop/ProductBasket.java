package org.skypro.skyshop;

import java.util.Objects;

public class ProductBasket {
    private static final int MAX_PRODUCTS = 5;
    private Product[] products;
    private int countProducts;

    public ProductBasket() {
        this.products = new Product[MAX_PRODUCTS];
        this.countProducts = 0;
    }

    public void addProduct(Product product) {
        if (countProducts >= MAX_PRODUCTS) {
            System.out.println("Корзина заполнена");
            return;
        }

        products[countProducts++] = Objects.requireNonNull(product);
    }


}
    

