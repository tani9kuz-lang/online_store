package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import java.util.Arrays;


public class App {
    public static void main(String[] args) {
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

        Article post1 = new Article("Сравнение iPhone 15 и iPhone 16", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        Article post2 = new Article("Как выбрать наушники", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        Article post3 = new Article("Новинки", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        Article post4 = new Article("Обзор на iPhone 17 Pro", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");


        searchEngine.add(post1);
        searchEngine.add(product1);
        searchEngine.add(post3);
        searchEngine.add(product2);
        searchEngine.add(product4);

        Searchable[] searchables = searchEngine.search("Новинки");
        for (Searchable searchable: searchables){
            System.out.println(searchable);
        }

    }
}