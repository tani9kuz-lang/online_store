package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private double discountPrice;
    private double basePrice;
    private int count;

    public DiscountedProduct(String productName, double basePrice, double discountPrice)  throws IllegalArgumentException{
        super(productName);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Указана не корректная базовая стоимость товара");
        }   else  {
            this.basePrice = basePrice;
        }
        if (discountPrice < 0 || discountPrice > 100) {
            throw new IllegalArgumentException("Указан не корректный процент скидки");
        } else{
            this.discountPrice = discountPrice;

        }

    }


    @Override
    public double getProductPrice() {
        return basePrice - (basePrice * discountPrice / 100);
    }

    @Override
    public String toString() {
        return getProductName() + " со скидкой: " + getProductPrice() + " скидка " + discountPrice + "%";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
