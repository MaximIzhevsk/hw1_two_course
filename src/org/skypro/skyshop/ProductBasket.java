package org.skypro.skyshop;

import java.util.*;



public class ProductBasket {

    private Map<String, List<Product>> productsMap;


    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    //добавление в корзину, и проверка на заполненность
    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getName(), k-> new ArrayList<>()).add(product);
    }

    //общая стоимость корзины



    public int getTotalCost() {
        int sum = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    //печать корзины
    public void printBasketContent() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        // Проходим по каждому элементу карты вручную
        Iterator<Map.Entry<String, List<Product>>> iterator = productsMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Product>> entry = iterator.next();
            String name = entry.getKey();
            List<Product> productsList = entry.getValue();

            // Проходим по списку продуктов вручную
            for (Product product : productsList) {
                System.out.println(product.toString());
            }
        }

        // Подсчет специальных товаров вручную
        int specialCount = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }



    //проверка наличия продукта в корзине
    public boolean containsProduct(String name) {
       return productsMap.containsKey(name);
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
        productsMap.clear();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> result = new ArrayList<>();

        // Проверяем наличие ключа в мапе
        if (!productsMap.containsKey(name)) {
            return Collections.emptyList(); // Если товар отсутствует, возвращаем пустой список
        }

        // Получаем список продуктов по указанному ключу
        List<Product> productsToRemove = productsMap.get(name);

        // Копируем продукты перед удалением
        result.addAll(productsToRemove);

        // Удаляем сам список продуктов из мапы
        productsMap.remove(name);

        return result;
    }







}
    

