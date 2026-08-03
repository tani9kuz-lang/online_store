package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.*;


public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        String name = product.getProductName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
        System.out.println(name + " добавлен в корзину.");
    }


    public int totalPriceBasket() {
        int total = products.values().stream()
                .filter(productList -> productList != null)
                .flatMap(java.util.List::stream)
                .filter(product -> product != null)
                .mapToInt(product -> (int) product.getProductPrice())
                .sum();
        System.out.println("Сумма к оплате: " + total);
        return total;
    }

    public void showBasket() {
        System.out.println("Содержимое корзины:");

        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            products.values().stream()
                    .filter(productList -> productList != null)
                    .flatMap(java.util.List::stream)
                    .filter(product -> product != null)
                    .forEach(product -> System.out.println("- " + product.getProductName() + ": " + product.getProductPrice() + " руб."));
        }
    }

    public boolean searchInBasket(String productName) {
        return products.containsKey(productName);
    }

    public void clearBasket() {
        products.clear(); // Очищает весь список
        System.out.println("Корзина пуста");
    }

    public int countSpecialProducts() {
        long specialCount = products.values().stream()
                .filter(productList -> productList != null)
                .flatMap(java.util.List::stream)
                .filter(product -> product != null
                        && product.isSpecial())
                .count();
        return (int) specialCount;
    }


    public void printProductBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        System.out.println("Список товаров:");
        products.values().stream()
                .filter(productList -> productList != null)
                .flatMap(java.util.List::stream)
                .forEach(product -> System.out.println("- " + product.getProductName() + ": " + product.getProductPrice() + " руб."));

        long specialCount = products.values().stream()
                .filter(productList -> productList != null)
                .flatMap(java.util.List::stream)
                .filter(product -> product != null && product.isSpecial())
                .count();

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