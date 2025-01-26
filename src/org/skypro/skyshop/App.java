package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();  //создание корзины

        Product apple = new Product("Яблоко", 100);  //создание яблока
        basket.addProduct(apple);  //добавление яблока

        Product banana = new Product("Банан", 90);
        basket.addProduct(banana);

        Product orange = new Product("Апельсин", 80);
        basket.addProduct(orange);

        Product pear = new Product("Груша", 70);
        basket.addProduct(pear);

        Product grape = new Product("Виноград", 60);
        basket.addProduct(grape);

        Product peach = new Product("Персик", 50);
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

        //создаём ещё одну корзину
        ProductBasket basket1 = new ProductBasket();

        Product table = new Product("Стол", 500);
        Product chair = new Product("Стул", 300);
        Product bed = new Product("Кровать", 800);
        basket1.addProduct(table);
        basket1.addProduct(chair);
        basket1.addProduct(bed);
        basket1.printBasketContent();
    }
}
