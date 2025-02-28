package org.skypro.skyshop;

import java.util.Objects;
import java.util.Scanner;

public class ProductBasket {
    private static final int MAX_PRODUCTS = 5;  //макс размер корзины
    private Product[] products;  //массив из продуктов класса Product
    private int countProducts;  //счетчик продуктов в корзине

    //конструктор создает массив из 5 объектов класса Product
    public ProductBasket() {
        this.products = new Product[MAX_PRODUCTS];
        this.countProducts = 0;
    }

    //добавление в корзину, и проверка на заполненность
    public void addProduct(Product product) {
        if (countProducts >= MAX_PRODUCTS) {
            System.out.println("Невозможно добавить продукт");
            return;
        }

        products[countProducts++] = Objects.requireNonNull(product);  //проверяем, что добавляемый объект не null,
                                                                      //добавляем его и увеличиваем счетчик на 1
    }

    //общая стоимость корзины
    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < countProducts; i++) {
            totalCost += products[i].getPrice();
        }
        return totalCost;
    }

    //печать корзины
    public void printBasketContent() {
        if (isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        for (int i = 0; i < countProducts; i++) {
            System.out.println(products[i].toString());

            if (products[i].isSpecial()){
                specialCount++;
            }
        }

        System.out.printf("Итого: %d\n", getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    //проверка наличия продукта в корзине
    public boolean containsProduct(String name) {
        for (int i = 0; i < countProducts; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //проверка с печатью на наличие продукта в корзине
    public void hasProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название продукта для поиска");
        String searchProduct = scanner.nextLine();
        if (containsProduct(searchProduct)) {
            System.out.println(searchProduct + " есть в корзине");
        } else {
            System.out.println(searchProduct + " нет в корзине");
        }
    }

    //очистка корзины
    public void clearBasket() {
        for (int i = 0; i < countProducts; i++) {
            products[i] = null;
        }
        countProducts = 0;
    }

    //проверка, является ли корзина пустой
    private boolean isEmpty() {
        return countProducts == 0;
    }

}
    

