package org.skypro.skyshop;

import java.util.*;


public class ProductBasket {
    private static final int MAX_PRODUCTS = 5;  //макс размер корзины
    private List<Product> products;  //массив из продуктов класса Product
    private int countProducts;  //счетчик продуктов в корзине

    //конструктор создает массив из 5 объектов класса Product
    public ProductBasket() {
        this.products = new LinkedList<>();
        //this.countProducts = 0;
    }

    //добавление в корзину, и проверка на заполненность
    public void addProduct(Product product) {
        products.add(product);
        countProducts++;
//        if (countProducts >= MAX_PRODUCTS) {
//            System.out.println("Невозможно добавить продукт");
//            return;
//        }
//
//        products[countProducts++] = Objects.requireNonNull(product);  //проверяем, что добавляемый объект не null,
//        //добавляем его и увеличиваем счетчик на 1
    }

    //общая стоимость корзины
    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < countProducts; i++) {
            totalCost += products.get(i).getPrice();
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
            System.out.println(products.get(i).toString());

            if (products.get(i).isSpecial()) {
                specialCount++;
            }
        }

        System.out.printf("Итого: %d\n", getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    //проверка наличия продукта в корзине
    public boolean containsProduct(String name) {
        for (int i = 0; i < countProducts; i++) {
            if (products.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //проверка с печатью на наличие продукта в корзине
    public void hasProduct(String searchProduct) {
        if (containsProduct(searchProduct)) {
            System.out.println(searchProduct + " есть в корзине");
        } else {
            System.out.println(searchProduct + " нет в корзине");
        }
    }

    //очистка корзины
    public void clearBasket() {
        for (int i = 0; i < countProducts; i++) {
            products.set(i, null);
        }
        countProducts = 0;
    }

    //проверка, является ли корзина пустой
    private boolean isEmpty() {
        return countProducts == 0;
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removeProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removeProducts.add(product);
                iterator.remove();
                countProducts--;
            }
        }

        return removeProducts;

    }

}
    

