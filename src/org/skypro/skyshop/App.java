package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
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

        basket.hasProduct("Яблоко");  //поиск продукта в корзине

        //basket.clearBasket();  //очистка корзины
        basket.printBasketContent();  //печать содержимого корзины

        totalCost = basket.getTotalCost();  //получение общей стоимости
        System.out.printf("Общая стоимость корзины: %d\n", totalCost);

        basket.hasProduct("Киви");  //поиск продукта в корзине

        //Создайте один объект типа
        //SearchEngine
        // и добавьте в него все товары, которые создаются для проверки других методов.

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(pear);
        searchEngine.add(grape);
        searchEngine.add(peach);

        //Создайте несколько объектов типа
        //Article
        // и добавьте их в
        //Search Engine

        Article table = new Article("Стол", "Стол кухонный раздвижной обеденный.");
        Article chair = new Article("Стул", "Коричневый деревянный стул идеально впишется.");

        searchEngine.add(table);
        searchEngine.add(chair);

        // Выполняем поиск по запросу "яблоко"
        System.out.println("=== Результаты поиска по 'банан' ===");
        Map<String, Searchable> searchResults = searchEngine.search("банан");

        // Перебираем результаты поиска вручную
        for (Map.Entry<String, Searchable> entry : searchResults.entrySet()) {
            String name = entry.getKey();          // Имя элемента
            Searchable searchable = entry.getValue();// Объект результата поиска

            // Выводим информацию о каждом элементе
            System.out.println(searchable.getStringRepresentation());   // Строковое представление
            System.out.println(searchable.getSearchTerm());              // Поисковый термин
            System.out.println("---");                                  // Разделительная линия между элементами

//        String searchQuery = "Банан";
//        System.out.print("Поиск /" +  searchQuery + "/ ");
//        printSearchResult(searchEngine.search(searchQuery));
//
//
//        String searchQuery1 = "Апельсин";
//        System.out.println("Поиск /" +  searchQuery1 + "/ " + searchEngine.search(searchQuery1));
//
//        String searchQuery2 = "Манго";
//        System.out.println("Поиск /" +  searchQuery2 + " /" + searchEngine.search(searchQuery2));

            //Создайте несколько продуктов и нарочно заполните их поля неправильно.

            try {
                Product mouse = new SimpleProduct("Mouse", 0);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            try {
                Product cat = new DiscountedProduct("Cat", 3, 101);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            try {
                Product dog = new FixPriceProduct(" ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            //Продемонстрируйте в методе main новый метод поиска в двух сценариях:
            //когда нужный объект существует,
            //когда метод выбрасывает исключение.


            try {
                Searchable mostRelevant = searchEngine.findMostRelevant("Апельсин");
                System.out.println("Наиболее подходящий " + mostRelevant.getSearchTerm());
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }

            try {
                Searchable mostRelevantEx = searchEngine.findMostRelevant("hfbfgh");
                System.out.println("Наиболее подходящий " + mostRelevantEx.getSearchTerm());
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }

            //домашка по List

            System.out.println("Домашка по спискам");
            basket.printBasketContent(); //печать содержимого корзины

            List<Product> removedProducts = basket.removeProductByName("Яблоко");  //удаление яблока
            if (removedProducts.isEmpty()) {
                System.out.println("Список пуст");
            } else {
                System.out.println("Удалённые продукты: " + removedProducts);  //список удалённых яблок
            }

            System.out.println("Корзина после удаления яблока:");
            basket.printBasketContent();

            removedProducts = basket.removeProductByName("Дуриан");  //удаление несуществующего
            if (removedProducts.isEmpty()) {
                System.out.println("Список пуст");
            } else {
                System.out.println("Удалённые продукты: " + removedProducts);
            }

            basket.printBasketContent();  //корзина после удаления несуществующего


        }
    }
}
