package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;


public class ProductBasket {
    private Map<String, List<Product>> products;
    //private List<Product> products = new LinkedList<>();

    //    public ProductBasket() {
//        this.products = new LinkedList<>();
//    }
    public ProductBasket() {
        // Инициализируем как HashMap для быстрого поиска по имени O(1)
        this.products = new HashMap<>();
    }

    //    public void addProduct(Product product) {
//        products.add(product);
//        System.out.println(product.getProductName() + " добавлен в корзину.");
//    }
    public void addProduct(Product product) {
        String name = product.getProductName();

        // Если ключа 'name' нет, создастся ArrayList, иначе вернется существующий.
        // После этого в список сразу добавляется продукт.
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);

        System.out.println(name + " добавлен в корзину.");
    }


    public int totalPriceBasket() {
        int total = 0;

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    total += product.getProductPrice();
                }
            }
        }

        System.out.println("Сумма к оплате: " + total);
        return total;
    }

    public void showBasket() {
        System.out.println("Содержимое корзины:");

        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {

            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    if (product != null) {
                        System.out.println("- " + product.getProductName() + ": " + product.getProductPrice() + " руб.");
                    }
                }
            }
        }
    }

    public boolean searchInBasket(String productName) {
        return products.containsKey(productName);
    }
//    public boolean searchInBasket(String productName) {
//        if (products.isEmpty()) {
//            return false;
//        }
//
//        for (Product product : products) {
//            if (product.getProductName().equals(productName)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public void clearBasket() {
        products.clear(); // Очищает весь список
        System.out.println("Корзина пуста");
    }

    public int countSpecialProducts() {
        int specialCount = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null && product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        return specialCount;

    }

    public void printProductBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        int specialCount = 0;

        System.out.println("Список товаров:");
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println("- " + product.getProductName() + ": " + product.getProductPrice() + " руб.");
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                }
            }
        }

        System.out.println("Итого: " + totalPriceBasket());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = products.remove(name);

        if (removedProducts == null) {
            return new LinkedList<>();
        }
        return removedProducts;
    }
}