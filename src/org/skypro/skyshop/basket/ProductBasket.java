package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.w3c.dom.ls.LSOutput;


import java.security.Signature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProductBasket {

    private Product[] products;
    private int count;

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;
    }

    //метод добавления в корзину. Нужна проверка на то что корзина заполнена !

    public void addProduct(Product product) {
        if (this.count == this.products.length) {
            System.out.println("Не возможно добавить продукт");
        } else {
            products[count] = product;
            count++;
            System.out.println(product.getProductName() + " добавлен в корзину.");
        }
    }

    //Метод получения общей стоимости корзины
    public int totalPriceBasket() {
        int total = 0;
        if (this.count == 0)
            return total;
        for (Product product : products) {
            if (product!= null){
            total = (int) (total + product.getProductPrice());
            }
        }
        System.out.println("Сумма к оплате: " + total);
        return total;
    }

    //метод выводы корзины
    public void showBasket() {
        System.out.println("Содержимое корзины:");

        if (count > 0) {
            for (Product product : products) {
                if (product != null) {
                    System.out.println("- " + product.getProductName() + ": " + product.getProductPrice() + " руб.");
                }
            }

        } else {
            System.out.println("в корзине пусто");

        }
    }

    // проверяющий продукт в корзине по имени
    public boolean searchInBasket(String productName) {
        if (this.count == 0) {
            return false;
        }
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }


    // Метод очистки корзины
    public void clearBasket() {
        Arrays.fill(this.products, null);
        this.count = 0;
        System.out.println("Корзина пуста");
    }


    public int countSpecialProducts() {
        int specialCount = 0;

        // Пройдем по каждому товару в корзине
        for (Product product : products) {
            // Используем метод isSpecial для проверки
            if (product!= null && product.isSpecial()) {
                specialCount++; // Увеличиваем счетчик, если товар специальный
            }
        }

        return specialCount; // Возвращаем количество специальных товаров
    }


    public void printProductBasket(){
        int specialCount = 0;
        for (Product product : products){
            if (product != null){
                System.out.println("- " + product.getProductName() + ": " + product.getProductPrice() + " руб.");
            } else if (products.length == 0){
                System.out.println("Корзина пуста");
                break;
            }
        }
        for (Product product : products){
            if (product!= null && product.isSpecial()){
                specialCount++;
            }
        }
        System.out.println("Итого: " + totalPriceBasket());
        System.out.println("Специальных товаров: " + specialCount);
    }
}



