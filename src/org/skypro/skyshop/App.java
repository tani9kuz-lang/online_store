package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.search.BestResultNotFound;
import org.skypro.skyshop.product.search.SearchEngine;
import org.skypro.skyshop.product.search.Searchable;

import java.util.List;


public class App {
    public static void main(String[] args) throws BestResultNotFound {
        ProductBasket productBasket1 = new ProductBasket();
        SimpleProduct product1 = new SimpleProduct("Планшет", 23567);
        SimpleProduct product2 = new SimpleProduct("Зарядное устройство", 1500);
        SimpleProduct product3 = new SimpleProduct("Защитное стекло для планшета", 980);
        SimpleProduct product4 = new SimpleProduct("Чехол для планшета", 1050);
        SimpleProduct product5 = new SimpleProduct("Наушники безпроводные", 5900);
        SimpleProduct product6 = new SimpleProduct("Мышка безпроводная", 678);

        productBasket1.addProduct(product1);
        productBasket1.addProduct(product2);
        productBasket1.addProduct(product3);
        productBasket1.addProduct(product4);
        productBasket1.addProduct(product5);
        productBasket1.addProduct(product6);

        productBasket1.showBasket();
        System.out.println("Демонстрация удаления товара");

        List<Product> removedItems = productBasket1.removeProductsByName("Планшет");
        productBasket1.showBasket();

        productBasket1.totalPriceBasket();
        productBasket1.showBasket();

        productBasket1.clearBasket();
        productBasket1.showBasket();
        System.out.println(productBasket1.totalPriceBasket());
        productBasket1.searchInBasket("Планшет");


        productBasket1.clearBasket();

        DiscountedProduct product7 = new DiscountedProduct("Телефон", 12000, 12);
        FixPriceProduct product8 = new FixPriceProduct("Зарядка безпроводная");

        productBasket1.addProduct(product7);
        productBasket1.addProduct(product8);
        productBasket1.printProductBasket();

        SearchEngine searchEngine = new SearchEngine(5);

        Article post1 = new Article("Сравнение iPhone 15 и iPhone 16", "Lorem ipsum dolor sit amet, consectetur Lorem ipsum dolor sit amet, consectetur Lorem ipsum dolor sit amet, consectetur Lorem ipsum dolor sit amet, consecteturadipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        Article post2 = new Article("Как выбрать наушники", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        Article post3 = new Article("Новинки", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        Article post4 = new Article("Обзор на iPhone 17 Pro", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");


        searchEngine.add(post1);
        searchEngine.add(product1);
        searchEngine.add(post3);
        searchEngine.add(product2);
        searchEngine.add(product4);
        searchEngine.add(post4);

        //Поиск по запросу
        String searchQuery = "Машина";
        System.out.println("Поиск по запросу: \"" + searchQuery + "\"");


        List<Searchable> foundItems = searchEngine.search(searchQuery);

        if (foundItems.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Searchable item : foundItems) {
                System.out.println("- Найден: " + item);
            }
            System.out.println("Всего найдено: " + foundItems.size() + " элементов.");
        }
        System.out.println();


        //Исключения
        try {
            DiscountedProduct product9 = new DiscountedProduct("Телефон Samsung", 1200, -10);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct product10 = new DiscountedProduct("Телефон Honor", -120, 10);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Article post5= new Article("Сравнение iPhone 15 и iPhone 16", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        searchEngine.add(post5);
        try {
            System.out.println(searchEngine.findBestMatch(" "));
        }catch (BestResultNotFound e){
            System.out.println(e.getMessage());
        }


    }
}