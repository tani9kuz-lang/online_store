package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.FixPriceProduct;

import java.time.format.TextStyle;


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
        FixPriceProduct product8 = new FixPriceProduct("Зарядка без проводная");

        productBasket1.addProduct(product7);

        productBasket1.addProduct(product8);
        productBasket1.showBasket();




    }
}