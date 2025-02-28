package org.skypro.skyshop;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();  //создание корзины

        Product apple = new SimpleProduct("Яблоко", 100);  //создание яблока
        basket.addProduct(apple);  //добавление яблока

        Product banana = new DiscountedProduct("Банан", 90, 30);
        basket.addProduct(banana);

        Product orange = new FixPriceProduct("Апельсин");
        basket.addProduct(orange);

        Product pear = new SimpleProduct("Груша", 70);
        basket.addProduct(pear);

        Product grape = new DiscountedProduct("Виноград", 60, 20);
        basket.addProduct(grape);

        Product peach = new FixPriceProduct("Персик");
        basket.addProduct(peach);  //добавление в заполненную корзину

        basket.printBasketContent();  //печать содержимого корзины

        int totalCost = basket.getTotalCost();  //получение общей стоимости корзины
        System.out.printf("Общая стоимость корзины: %d\n", totalCost);

        basket.hasProduct();  //поиск продукта в корзине

        basket.clearBasket();  //очистка корзины
        basket.printBasketContent();  //печать содержимого корзины

        totalCost = basket.getTotalCost();  //получение общей стоимости
        System.out.printf("Общая стоимость корзины: %d\n", totalCost);

        basket.hasProduct();  //поиск продукта в корзине


    }
}
