package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private  double discountPrice;
    private  double basePrice;
    private int count;

    public DiscountedProduct(String productName, double basePrice, double discountPrice) {
        super(productName);
        this.basePrice = basePrice;
        this.discountPrice = discountPrice;
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
