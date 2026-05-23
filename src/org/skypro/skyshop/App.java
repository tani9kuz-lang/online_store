package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;



public class App {
    public static void main(String[] args) {
        ProductBasket productBasket1 = new ProductBasket();
        Product product1 = new Product("Планшет", 23567);
        Product product2 = new Product("Зарядное устройство", 1500);
        Product product3 = new Product("Защитное стекло для планшета", 980);
        Product product4 = new Product("Чехол для планшета", 1050);
        Product product5 = new Product("Наушники безпроводные", 5900);
        Product product6 = new Product("Мышка безпроводная", 678);


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
    }
}