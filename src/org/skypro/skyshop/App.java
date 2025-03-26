package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

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

        basket.hasProduct("Яблоко");  //поиск продукта в корзине

        basket.clearBasket();  //очистка корзины
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

        String searchQuery = "Банан";
        System.out.print("Поиск /" +  searchQuery + "/ ");
        printSearchResult(searchEngine.search(searchQuery));


        String searchQuery1 = "Апельсин";
        System.out.println("Поиск /" +  searchQuery1 + "/ " + Arrays.toString(searchEngine.search(searchQuery1)));

        String searchQuery2 = "Манго";
        System.out.println("Поиск /" +  searchQuery2 + " /" + Arrays.toString(searchEngine.search(searchQuery2)));

        //Создайте несколько продуктов и нарочно заполните их поля неправильно.

        Product mouse = new SimpleProduct("Mouse", 0);
        Product cat = new DiscountedProduct("Cat", 23, 101);
        Product dog = new FixPriceProduct(" ");

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



    }

    public static void printSearchResult( Searchable[] searchables) {
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                System.out.println(searchable);
            }
        }
    }
}
